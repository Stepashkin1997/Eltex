package ru.eltex.app.java.lab4;

/**
 * поток проверяет заказы по статусу «обработан».
 * Если заказ обнаружен в этом состоянии, заказ удаляется из списка.
 */
public class DoneThread extends ACheck {
    private boolean work = true;

    public DoneThread(Orders<?> orders) {
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
                orders.removeDone();
                orders.show();
            }
        }
    }
}
