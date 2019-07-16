package ru.eltex.app.java.lab4;

/**
 * класс, описывающий проверку заказов по статусу
 */
public abstract class ACheck implements Runnable {
    protected Orders<?> orders;
    static String string = "1";

    public ACheck(Orders<?> orders) {
        this.orders = orders;
    }
}
