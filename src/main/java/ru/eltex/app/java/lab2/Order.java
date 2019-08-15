package ru.eltex.app.java.lab2;

import com.google.gson.annotations.Expose;

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
public class Order implements Serializable {
    @Id
    @Expose
    private String id;//id для заказа

    @Enumerated(EnumType.STRING)
    @Expose
    private OrderStatus status;//статус заказа

    @Expose
    private Date ordertime;//время покупки

    @Expose
    private long diff;//время ожидания

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cart")
    @Expose
    private ShoppingCart<?> cart = new ShoppingCart<>();//Агрегация ссылка на ShoppingCart

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_credentials")
    @Expose
    private Credentials credentials = new Credentials();//Агрегация ссылка на Credentials

    @Expose
    private InetAddress address;//Адресс отправителя заказа

    @Expose
    private int port;//Порт отправителя заказа

    public Order() {
    }

    public Order(ShoppingCart<?> cart, Credentials credentials) {
        this.id = String.valueOf(UUID.randomUUID());
        this.status = OrderStatus.WAITING;
        this.cart = cart;
        this.credentials = credentials;
        this.ordertime = new Date(System.currentTimeMillis());
        this.diff = (long) (Math.random() * 100);
        this.address = InetAddress.getLoopbackAddress();
        this.port = 0;
    }

    public Order(ShoppingCart<?> cart, Credentials credentials, InetAddress address, int port) {
        this.id = String.valueOf(UUID.randomUUID());
        this.status = OrderStatus.WAITING;
        this.cart = cart;
        this.credentials = credentials;
        this.ordertime = new Date(System.currentTimeMillis());
        this.diff = (long) (Math.random() * 100);
        this.address = address;
        this.port = port;
    }

    public Order(UUID id, OrderStatus status, Date ordertime, long diff, ShoppingCart<?> cart, Credentials credentials) {
        this.id = String.valueOf(id);
        this.status = status;
        this.ordertime = ordertime;
        this.diff = diff;
        this.cart = cart;
        this.credentials = credentials;
        this.address = InetAddress.getLoopbackAddress();
        this.port = 0;
    }

    public UUID getId() {
        return UUID.fromString(id);
    }

    public void setId(UUID id) {
        this.id = String.valueOf(id);
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

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public long getDiff() {
        return diff;
    }

    public void setDiff(long diff) {
        this.diff = diff;
    }

    public ShoppingCart<?> getCart() {
        return cart;
    }

    public void setCart(ShoppingCart<?> cart) {
        this.cart = cart;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    public InetAddress getAddress() {
        return address;
    }

    public void setAddress(InetAddress address) {
        this.address = address;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
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