package ru.eltex.app.java.lab5;

/**
 * класс, описывающий проверку заказов по статусу
 */
public abstract class ACheck implements Runnable {
    protected Orders<?> orders;

    public ACheck(Orders<?> orders) {
        this.orders = orders;
    }
}
