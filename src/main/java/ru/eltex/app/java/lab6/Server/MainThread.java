package ru.eltex.app.java.lab6.Server;

import ru.eltex.app.java.lab2.Orders;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.*;

public final class MainThread implements Runnable {
    private Socket socket;
    private Orders<?> orders;

    public MainThread(Orders<?> orders, Socket socket) {
        this.orders = orders;
        this.socket = socket;
    }

    @Override
    public void run() {
        try (ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream())) {
            Orders<?> new_orders = (Orders) inputStream.readObject();
            for (var item : new_orders.getList()) {
                orders.purchase(item.getCart(), item.getCredentials(), socket.getLocalAddress());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
