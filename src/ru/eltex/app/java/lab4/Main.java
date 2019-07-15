package ru.eltex.app.java.lab4;

public class Main {

    public static void main(String[] args) {
        Orders<Order> orders = new Orders();
        Credentials user = new Credentials("Lol", "Kekovich", "Azaza", "123@ololo.ua");


        Generate generate = new Generate(1000,user,orders);
        generate.start();

        Thread doneThread = new Thread(new DoneThread(orders));
        Thread waitThread = new Thread(new WaitThread(orders));
        doneThread.start();
        waitThread.start();


        System.out.println("start");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        generate.TurnOff();
        System.out.println("stop");
        System.out.println();
    }
}
