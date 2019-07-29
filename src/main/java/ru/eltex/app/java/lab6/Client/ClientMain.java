package ru.eltex.app.java.lab6.Client;

import ru.eltex.app.java.lab2.Credentials;
import ru.eltex.app.java.lab2.Order;
import ru.eltex.app.java.lab2.Orders;
import ru.eltex.app.java.lab4.Generate;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;


public final class ClientMain {
    private int port;
    private InetAddress address;
    private Credentials user;
    private Orders<?> orders;

    private ClientMain(Credentials user, Orders<?> orders) {
        this.user = user;
        this.orders = orders;
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


    public void udpReceivePort() {
        try (DatagramSocket socket = new DatagramSocket(9999)) {
            byte[] buf = new byte[255];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            System.out.println("Ждем...");
            socket.receive(packet);
            System.out.println("Получили порт...");
            String received = new String(packet.getData(), 0, packet.getLength());
            port = Integer.parseInt(received);
            address = packet.getAddress();
            System.out.println(received);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void udpReceiveAccept() {
        try (DatagramSocket socket = new DatagramSocket(8888)) {
            byte[] buf = new byte[255];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            System.out.println("Ждем подтверждение...");
            socket.receive(packet);
            System.out.println("Получили подтверждение...");
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendTCP() {
        try (Socket socket = new Socket(address, port)) {
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(orders);
            outputStream.flush();
            System.out.println("отправили...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
