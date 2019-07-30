package ru.eltex.app.java.lab2;

import java.io.Serializable;
import java.net.InetAddress;
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
    private InetAddress address;//Адресс отправителя заказа
    private int port;//Порт отправителя заказа

    public Order(ShoppingCart<?> cart, Credentials credentials) {
        this.id = UUID.randomUUID();
        this.status = OrderStatus.WAITING;
        this.cart = cart;
        this.credentials = credentials;
        this.ordertime = new Date(System.currentTimeMillis());
        this.diff = (long) (Math.random() * 100);
        this.address = InetAddress.getLoopbackAddress();
        this.port = 0;
    }

    public Order(ShoppingCart<?> cart, Credentials credentials, InetAddress address, int port) {
        this.id = UUID.randomUUID();
        this.status = OrderStatus.WAITING;
        this.cart = cart;
        this.credentials = credentials;
        this.ordertime = new Date(System.currentTimeMillis());
        this.diff = (long) (Math.random() * 100);
        this.address = address;
        this.port = port;
    }

    public Order(UUID id, OrderStatus status, Date ordertime, long diff, ShoppingCart<?> cart, Credentials credentials) {
        this.id = id;
        this.status = status;
        this.ordertime = ordertime;
        this.diff = diff;
        this.cart = cart;
        this.credentials = credentials;
        this.address = InetAddress.getLoopbackAddress();
        this.port = 0;
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

    public InetAddress getAddress() {
        return address;
    }

    public int getPort() {
        return port;
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