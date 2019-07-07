package com.company;

import java.util.Date;
import java.util.HashMap;

/*класс заказ*/
public class Order {
    private StringBuilder status;//статус заказа
    private Date ordertime;//время покупки
    private Date waitingtime;//время ожидаия
    private ShoppingCart cart;//Агрегация ссылка на ShoppingCart
    private Credentials credentials;//Агрегация ссылка на Credentials
    static HashMap<Order, Date> createTime = new HashMap();

    public Order(Date waitingtime, ShoppingCart cart, Credentials credentials) {
        this.waitingtime = waitingtime;
        this.cart = cart;
        this.credentials = credentials;
        ordertime = new Date();
        createTime.put(this,ordertime);
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
}
