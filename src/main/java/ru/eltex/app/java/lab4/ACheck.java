package ru.eltex.app.java.lab4;

import ru.eltex.app.java.lab2.Orders;

/**
 * класс, описывающий проверку заказов по статусу
 */
public abstract class ACheck implements Runnable {
    protected Orders<?> orders;

    public ACheck(Orders<?> orders) {
        this.orders = orders;
    }
}
