package ru.eltex.app.java.lab4;

import ru.eltex.app.java.lab2.Credentials;
import ru.eltex.app.java.lab2.Order;
import ru.eltex.app.java.lab2.Orders;

public class Main {

    public static void main(String[] args) {
        Orders<Order> orders = new Orders();
        Credentials user = new Credentials("Lol", "Kekovich", "Azaza", "123@ololo.ua");


        Generate generate = new Generate(1000, user, orders);
        generate.start();

        DoneThread doneThread1 = new DoneThread(orders);
        WaitThread waitThread1 = new WaitThread(orders);

        Thread doneThread = new Thread(doneThread1);
        Thread waitThread = new Thread(waitThread1);

        waitThread.start();


        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

       doneThread.start();


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        generate.turnOff();
        doneThread1.turnOff();
        waitThread1.turnOff();

    }
}
