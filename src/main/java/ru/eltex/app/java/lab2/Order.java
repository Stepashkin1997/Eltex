package ru.eltex.app.java.lab2;

import javax.persistence.*;
import java.io.Serializable;
import java.net.InetAddress;
import java.sql.Date;
import java.util.UUID;

/**
 * класс заказ
 */
@Entity
@Table(name = "`Order`")
public final class Order implements Serializable {
    @Id
    private UUID id;//id для заказа

    @Enumerated(EnumType.STRING)
    private OrderStatus status;//статус заказа
    private Date ordertime;//время покупки
    private long diff;//время ожидания

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ShoppingCart.class)
    @JoinColumn(name = "id_cart")
    private ShoppingCart<?> cart;//Агрегация ссылка на ShoppingCart

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Credentials.class)
    @JoinColumn(name = "id_credentials")
    private Credentials credentials;//Агрегация ссылка на Credentials

    private InetAddress address;//Адресс отправителя заказа
    private int port;//Порт отправителя заказа

    public Order() {
    }

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

    public UUID getOrder_id() {
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