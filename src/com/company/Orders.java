package com.company;

import java.util.Date;
import java.util.LinkedList;

/*Класс коллекция заказы*/
public class Orders {
    private LinkedList<Order> list;

    public Orders() {
        list = new LinkedList();
    }

    /*функция вывода*/
    public void show() {
        for (var item : list) {
            System.out.println(item);
        }
    }

    /*оформит покупку*/
    public void purchase(Date waitingtime, ShoppingCart cart, Credentials credentials) {
        Order order = new Order(waitingtime, cart, credentials);
        list.add(order);
    }

    /*обход коллекции и удаление всех объектов, время ожидания которых истекло и статус «обработан»*/
    public void clear() {
        for (var item : list) {
            if (item.getWaitingtime().before(new Date()) || item.getStatus().toString().equals("Done")) {
                list.remove(item);
            }
        }
    }
}
