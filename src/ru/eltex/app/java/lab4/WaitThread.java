package ru.eltex.app.java.lab4;


/**
 * делает проверку коллекции и проверяет заказы по статусу «в ожидании».
 * Если заказ обнаружен в этом состоянии, то меняется статус заказа на состояние «обработан».
 */
public class WaitThread extends ACheck {
    private boolean work = true;

    public WaitThread(Orders<?> orders) {
        super(orders);
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

    /**
     * метод работающий в потоке
     */
    @Override
    public void run() {
        while (work) {
            synchronized (orders) {
                orders.show();
                orders.setDone();
                System.out.println("wait");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
