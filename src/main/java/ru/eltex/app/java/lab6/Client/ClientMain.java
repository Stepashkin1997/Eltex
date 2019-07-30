package ru.eltex.app.java.lab6.Client;

import ru.eltex.app.java.lab2.Credentials;
import ru.eltex.app.java.lab2.Order;
import ru.eltex.app.java.lab2.Orders;
import ru.eltex.app.java.lab4.Generate;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.*;

/**
 * Класс клиента для работы с сервером и заказами
 */
public final class ClientMain {
    private final int RECEIVEPORT = 9999;//Порт прослушивания основной
    private final int RECEIVEPORTREST = 7777;//Порт прослушивания резервный
    private int acceptport;//спободный порт для получения подтверждения
    private int port;//порт на установку TCP соединения
    private InetAddress address;//адресс отправки по TCP
    private Credentials user;//информация о пользователе
    private Orders<?> orders;//заказы
    private DatagramSocket socket;

    private ClientMain(Credentials user, Orders<?> orders) {
        this.user = user;
        this.orders = orders;
        this.acceptport = 0;
    }

    public static void main(String[] args) {
        Orders<Order> orders = new Orders();
        Credentials user = new Credentials("Lol", "Kekovich", "Azaza", "123@ololo.ua");
        Generate generate = new Generate(1000, user, orders);
        generate.start();
        ClientMain clientMain = new ClientMain(user, orders);
        while (true) {
            clientMain.udpReceivePort();
            clientMain.sendTCP();
            generate.setWait();
            clientMain.udpReceiveAccept();
            synchronized (generate) {
                generate.notify();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *
     * Получить порт на отправку
     */
    public void udpReceivePort() {
        byte[] buf = new byte[255];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        try {
            socket = new DatagramSocket(RECEIVEPORT);
        } catch (SocketException e) {
            try {
                socket = new DatagramSocket(RECEIVEPORTREST);
            } catch (SocketException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("Ждем на порту " + socket.getLocalPort() + "...");
        try {
            socket.receive(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
        socket.close();
        System.out.println("Получили порт...");

        String received = new String(packet.getData(), 0, packet.getLength());
        port = Integer.parseInt(received);
        address = packet.getAddress();
        System.out.println(received);
    }

    /**
     * Получение подтверждения
     */
    public void udpReceiveAccept() {
        byte[] buf = new byte[255];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        try (DatagramSocket socket = new DatagramSocket(acceptport)) {
            System.out.println("Ждем подтверждение на порту " + acceptport + "...");
            socket.receive(packet);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String received = new String(packet.getData(), 0, packet.getLength());
        System.out.println("время обработки заказа:" + received);
        System.out.println("Получили подтверждение...");
    }

    /**
     * Отправить заказы по TCP
     */
    public void sendTCP() {
        try (Socket socket = new Socket(address, port)) {
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(orders);
            outputStream.flush();
            acceptport = socket.getLocalPort();
            outputStream.writeInt(acceptport);
            outputStream.flush();
            System.out.println("отправили...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
