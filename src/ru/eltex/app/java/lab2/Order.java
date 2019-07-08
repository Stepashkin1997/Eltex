package ru.eltex.app.java.lab2;

import java.util.Date;

/*класс заказ*/
public class Order {
    private StringBuilder status;//статус заказа
    private Date ordertime;//время покупки
    private Date waitingtime;//время ожидаия
    private ShoppingCart cart;//Агрегация ссылка на ShoppingCart
    private Credentials credentials;//Агрегация ссылка на Credentials

    public Order(Date waitingtime, ShoppingCart cart, Credentials credentials) {
        this.waitingtime = waitingtime;
        this.cart = cart;
        this.credentials = credentials;
        this.ordertime = new Date();
    }

    public StringBuilder getStatus() {
        return status;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public Date getWaitingtime() {
        return waitingtime;
    }

    public void show(){
        System.out.println("ID: " + status);
        System.out.println("Name: " + ordertime);
        System.out.println("Coast: " + waitingtime);
    }
}
