package com.company;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

/*Класс коллекция заказы*/
public class Orders {
    private LinkedList<Order> list;
    private HashMap<Order, Date> createTime;

    public Orders() {
        list = new LinkedList();
        createTime = new HashMap();
    }

    /*функция вывода*/
    public void show() {
        for (var item : list) {
            item.show();
        }
    }

    /*оформит покупку*/
    public void purchase(Date waitingtime, ShoppingCart cart, Credentials credentials) {
        Order order = new Order(waitingtime, cart, credentials);
        list.add(order);
        createTime.put(order, new Date());
    }

    /*обход коллекции и удаление всех объектов, время ожидания которых истекло и статус «обработан»*/
    public void clear() {
        for (var item : list) {
            if ((item.getWaitingtime().getTime() + item.getOrdertime().getTime()) <= new Date().getTime() && item.getStatus().toString().equals("Done")) {
                list.remove(item);
                createTime.remove(item);
            }
        }
    }
}
