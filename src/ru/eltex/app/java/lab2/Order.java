package ru.eltex.app.java.lab2;

import java.sql.Date;

/*класс заказ*/
public class Order {
    private OrderStatus status;//статус заказа
    private Date ordertime;//время покупки
    private long diff;//время ожидания
    private ShoppingCart cart;//Агрегация ссылка на ShoppingCart
    private Credentials credentials;//Агрегация ссылка на Credentials

    public Order(ShoppingCart cart, Credentials credentials) {
        this.status = OrderStatus.WAITING;
        this.cart = cart;
        this.credentials = credentials;
        this.ordertime = new Date(System.currentTimeMillis());
        diff = (long) (Math.random() * 10);
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

    public ShoppingCart getCart() {
        return cart;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    /*метод вывода содержимого объекта на экран*/
    public void print() {
        System.out.println("Status: " + status);
        System.out.println("Order time: " + ordertime);
        System.out.println("Waiting time: " + new Date(ordertime.getTime() + diff));
        System.out.println("Список товаров в заказе:");
        cart.show();
    }


}
