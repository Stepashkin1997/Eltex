package ru.eltex.app.java.lab4;

/**
 * класс автоматической генерации заказов в виде отдельного потока
 */
public class Generate extends Thread {
    private boolean work = true;
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
    public void TurnOff() {
        if (work) {
            work = false;
        } else {
            return;
        }
    }

    /**
     * метод работающий в потоке
     */
    @Override
    public void run() {
        super.run();
        while (work) {
            cart = new ShoppingCart<>();
            cart.add(new Coffee());
            cart.add(new Tea());

            orders.purchase(cart, user);

            try {
                sleep(period);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
