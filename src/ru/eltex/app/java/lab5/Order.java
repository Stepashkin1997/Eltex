package ru.eltex.app.java.lab5;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

/**
 * класс заказ
 */
public final class Order implements Serializable {
    private UUID id;//id для заказа
    private OrderStatus status;//статус заказа
    private Date ordertime;//время покупки
    private long diff;//время ожидания
    private ShoppingCart<?> cart;//Агрегация ссылка на ShoppingCart
    private Credentials credentials;//Агрегация ссылка на Credentials

    public Order(ShoppingCart<?> cart, Credentials credentials) {
        this.id = UUID.randomUUID();
        this.status = OrderStatus.WAITING;
        this.cart = cart;
        this.credentials = credentials;
        this.ordertime = new Date(System.currentTimeMillis());
        this.diff = (long) (Math.random() * 100);
    }

    public UUID getId() {
        return id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public long getDiff() {
        return diff;
    }

    public ShoppingCart<?> getCart() {
        return cart;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    /**
     * метод вывода содержимого объекта на экран
     */
    public void print() {
        System.out.println("Status: " + status);
        System.out.println("Order time: " + ordertime);
        System.out.println("Waiting time: " + diff);
        System.out.println("Список товаров в заказе:");
        cart.show();
        System.out.println("Данные о пользователе:");
        credentials.show();
    }
}
