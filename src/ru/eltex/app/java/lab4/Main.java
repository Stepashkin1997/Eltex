package ru.eltex.app.java.lab4;

public class Main {

    public static void main(String[] args) {
        Orders<Order> orders = new Orders();
        Credentials user = new Credentials("Lol", "Kekovich", "Azaza", "123@ololo.ua");


        Generate generate = new Generate(1000,user,orders);
        generate.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        generate.TurnOff();
        DoneThread doneThread1=new DoneThread(orders);
        WaitThread waitThread1=new WaitThread(orders);

        Thread doneThread = new Thread(doneThread1);
        Thread waitThread = new Thread(waitThread1);

        waitThread.start();
        //doneThread.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        doneThread1.turnOff();
        waitThread1.turnOff();
    }
}
