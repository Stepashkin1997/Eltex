package ru.eltex.app.java.lab2;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

/*Класс коллекция заказы*/
public class Orders {
    LinkedList<Order> list;//Коллекция для хранения объектов в классе «заказы»
    private HashMap<Order, Date> createTime;//Коллекция для хранения объектов по времени создания

    public Orders() {
        list = new LinkedList();
        createTime = new HashMap();
    }

    /*функция вывода*/
    public void show() {
        for (var item : createTime.keySet()) {
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
        for (var item : createTime.keySet()) {
            /*System.out.println("время: "+item.getWaitingtime().getTime() + item.getOrdertime().getTime());
            System.out.println(new Date().getTime());*/
            if ((item.getWaitingtime().getTime() + item.getOrdertime().getTime()) <= new Date().getTime() && item.getStatus().equals("Done")) {
                list.remove(item);
                createTime.remove(item);
            }
        }
    }


}
