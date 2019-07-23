package ru.eltex.app.java.lab2;

import java.sql.Date;
import java.util.HashMap;
import java.util.LinkedList;


/**
 * Класс коллекция заказы
 */
public class Orders {
    private LinkedList<Order> list;//Коллекция для хранения объектов в классе «заказы»
    private HashMap<Order, Date> createTime;//Коллекция для хранения объектов по времени создания

    public Orders() {
        list = new LinkedList();
        createTime = new HashMap();
    }


    /**
     * Функция вывода
     */
    public void show() {
        for (var item : createTime.keySet()) {
            System.out.println("****************************");
            System.out.println("Заказ:");
            item.print();
            System.out.println("****************************");
        }
    }

    /**
     * Оформление покупки
     * @param cart Корзина
     * @param credentials Данные пользователя
     */
    public void purchase(ShoppingCart cart, Credentials credentials) {
        Order order = new Order(cart, credentials);
        list.add(order);
        createTime.put(order, order.getOrdertime());
    }


    /**
     * обход коллекции и удаление всех объектов, время ожидания которых истекло и статус «обработан»
     */
    public void clear() {
        var iter = createTime.keySet().iterator();

        while (iter.hasNext()) {
            var item = iter.next();
            if ((item.getDiff() + item.getOrdertime().getTime()) <=
                    new Date(System.currentTimeMillis()).getTime() && item.getStatus() == OrderStatus.DONE) {
                iter.remove();
                createTime.remove(item);
            }
        }
    }

    /**
     * Установить все в готовое
     */
    public void setDoneAll(){
        for (var item : list) {
            item.setStatus(OrderStatus.DONE);
        }
    }
}
