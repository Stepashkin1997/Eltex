package ru.eltex.app.java.lab2;

import java.util.Date;

/*класс заказ*/
public class Order {
    private String status;//статус заказа
    private Date ordertime;//время покупки
    long diff;//время ожидания
    private ShoppingCart cart;//Агрегация ссылка на ShoppingCart
    private Credentials credentials;//Агрегация ссылка на Credentials

    public Order(Date waitingtime, ShoppingCart cart, Credentials credentials) {
        this.status = "Performed";
        this.cart = cart;
        this.credentials = credentials;
        this.ordertime = new Date();
        diff = waitingtime.getTime() - ordertime.getTime();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getOrdertime() {
        return ordertime;
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
