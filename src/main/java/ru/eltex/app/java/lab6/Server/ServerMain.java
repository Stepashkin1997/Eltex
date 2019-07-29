package ru.eltex.app.java.lab6.Server;

import ru.eltex.app.java.lab2.Orders;
import ru.eltex.app.java.lab4.DoneThread;
import ru.eltex.app.java.lab4.WaitThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ServerMain {
    public static void main(String[] args) {
        ExecutorService executeIt = Executors.newFixedThreadPool(2);
        Orders orders = new Orders();
        DoneThread doneThread1 = new DoneThread(orders);
        WaitThread waitThread1 = new WaitThread(orders);
        Thread doneThread = new Thread(doneThread1);
        Thread waitThread = new Thread(waitThread1);
        waitThread.start();
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        doneThread.start();
        UDPAlert udpAlert = new UDPAlert(1111);
        udpAlert.start();
        try (ServerSocket serverSocket = new ServerSocket(1111)) {
            while (true) {
                executeIt.execute(new MainThread(orders, serverSocket.accept()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
