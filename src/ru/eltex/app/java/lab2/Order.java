package ru.eltex.app.java.lab2;

import java.util.Date;

/*класс заказ*/
public class Order {
    private String status;//статус заказа
    private Date ordertime;//время покупки
    private Date waitingtime;//время ожидания
    private ShoppingCart cart;//Агрегация ссылка на ShoppingCart
    private Credentials credentials;//Агрегация ссылка на Credentials

    public Order(Date waitingtime, ShoppingCart cart, Credentials credentials) {
        this.status="Performed";
        this.waitingtime = waitingtime;
        this.cart = cart;
        this.credentials = credentials;
        this.ordertime = new Date();
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

    public Date getWaitingtime() {
        return waitingtime;
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    /*метод вывода содержимого объекта на экран*/
    public void show() {
        System.out.println("Status: " + status);
        System.out.println("Order time: " + ordertime);
        System.out.println("Waiting time: " + waitingtime);
    }
}
