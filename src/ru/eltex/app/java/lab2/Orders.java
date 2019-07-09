package ru.eltex.app.java.lab2;

import java.sql.Date;
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
            System.out.println("Заказ:");
            item.print();
        }
    }

    /*оформит покупку*/
    public void purchase(ShoppingCart cart, Credentials credentials) {
        Order order = new Order(cart, credentials);
        list.add(order);
        createTime.put(order, new Date(System.currentTimeMillis()));
    }

    /*обход коллекции и удаление всех объектов, время ожидания которых истекло и статус «обработан»*/
    public void clear() {
        for (var item : createTime.keySet()) {
            if ((item.getDiff() + item.getOrdertime().getTime()) <=
                    new Date(System.currentTimeMillis()).getTime() && item.getStatus() == OrderStatus.DONE) {
                list.remove(item);
                createTime.remove(item);
            }
        }
    }


}
