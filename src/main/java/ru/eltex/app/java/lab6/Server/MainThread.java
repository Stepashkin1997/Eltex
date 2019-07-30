package ru.eltex.app.java.lab6.Server;

import ru.eltex.app.java.lab2.Orders;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.*;

/**
 * Класс для работы в потоке для принятия заказов по TCP
 */
public final class MainThread implements Runnable {
    private Socket socket;//сокет соединения
    private Orders<?> orders;//заказы

    public MainThread(Orders<?> orders, Socket socket) {
        this.orders = orders;
        this.socket = socket;
    }

    @Override
    public void run() {
        try (ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream())) {
            Orders<?> new_orders = (Orders) inputStream.readObject();
            int port = inputStream.readInt();
            for (var item : new_orders.getList()) {
                synchronized (orders) {
                    orders.purchase(item.getCart(), item.getCredentials(), socket.getLocalAddress(), port);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
