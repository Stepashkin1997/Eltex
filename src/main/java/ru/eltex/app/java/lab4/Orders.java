package ru.eltex.app.java.lab4;

import java.sql.Date;
import java.util.HashMap;
import java.util.LinkedList;


/**
 * Класс коллекция заказы
 *
 * @param <T> extends Order
 */
public class Orders<T extends Order> {
    private LinkedList<T> list;//Коллекция для хранения объектов в классе «заказы»
    private HashMap<T, Date> createTime;//Коллекция для хранения объектов по времени создания

    public Orders() {
        list = new LinkedList();
        createTime = new HashMap();
    }


    /**
     * Функция вывода
     */
    public void show() {

        var iter = createTime.keySet().iterator();

        while (iter.hasNext()) {
            var item = iter.next();
            System.out.println("****************************");
            System.out.println("Заказ:");
            item.print();
            System.out.println("****************************");
        }
    }

    /**
     * Оформление покупки
     *
     * @param cart        Корзина
     * @param credentials Данные пользователя
     */
    public void purchase(ShoppingCart cart, Credentials credentials) {
        Order order = new Order(cart, credentials);
        list.add((T) order);
        createTime.put((T) order, order.getOrdertime());
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
     * Переводит ожидающие заказы в готовые
     */
    public void setDone() {
        for (var item : list) {
            if (item.getStatus() == OrderStatus.WAITING) {
                item.setStatus(OrderStatus.DONE);
            }
        }
    }

    /**
     * Удаляет готовые заказы
     */
    public void removeDone() {
        var iter = createTime.keySet().iterator();

        while (iter.hasNext()) {
            var item = iter.next();
            if (item.getStatus() == OrderStatus.DONE) {
                iter.remove();
                list.remove(item);
            }
        }
    }
}
