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
        while (work) {
            synchronized (orders) {
                orders.setDone();
                orders.show();
            }
        }
    }
}
