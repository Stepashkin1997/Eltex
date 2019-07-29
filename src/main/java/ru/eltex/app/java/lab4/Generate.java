package ru.eltex.app.java.lab4;

import ru.eltex.app.java.lab1.Coffee;
import ru.eltex.app.java.lab1.Drinks;
import ru.eltex.app.java.lab1.Tea;
import ru.eltex.app.java.lab2.Credentials;
import ru.eltex.app.java.lab2.Orders;
import ru.eltex.app.java.lab2.ShoppingCart;

/**
 * класс автоматической генерации заказов в виде отдельного потока
 */
public final class Generate extends Thread {
    private volatile boolean work = true;
    private volatile boolean wait = false;
    private long period;
    private Credentials user;
    private ShoppingCart<Drinks> cart;
    private Orders<?> orders;

    public Generate(long period, Credentials user, Orders<?> orders) {
        this.period = period;
        this.user = user;
        this.orders = orders;
    }

    /**
     * Остановка работы потока
     */
    public void turnOff() {
        if (work) {
            work = false;
        } else {
            return;
        }
    }

    public void setWait() {
        wait = true;
    }

    /**
     * метод работающий в потоке
     */
    @Override
    public void run() {
        super.run();
        while (work) {
            cart = new ShoppingCart<>();

            synchronized (cart) {
                cart.add(new Coffee());
                cart.add(new Tea());

                orders.purchase(cart, user);
            }
            if (wait) {
                try {
                    synchronized (this) {
                        wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                sleep(period);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
