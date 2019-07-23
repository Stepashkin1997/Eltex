package ru.eltex.app.java.lab6;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashMap;
import java.util.LinkedList;


/**
 * Класс коллекция заказы
 *
 * @param <T> extends Order
 */
public final class Orders<T extends Order> implements Serializable {
    private LinkedList<T> list;//Коллекция для хранения объектов в классе «заказы»
    private HashMap<Date, T> createTime;//Коллекция для хранения объектов по времени создания

    public Orders() {
        list = new LinkedList();
        createTime = new HashMap();
    }

    public Orders(LinkedList<T> list, HashMap<Date, T> createTime) {
        this.list = list;
        this.createTime = createTime;
    }

    public LinkedList<T> getList() {
        return list;
    }

    public HashMap<Date, T> getCreateTime() {
        return createTime;
    }

    /**
     * Функция вывода
     */
    public void show() {

        var iter = createTime.values().iterator();

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
        createTime.put(order.getOrdertime(),(T) order);
    }


    /**
     * обход коллекции и удаление всех объектов, время ожидания которых истекло и статус «обработан»
     */
    public void clear() {
        var iter = createTime.values().iterator();

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
        var iter = createTime.values().iterator();

        while (iter.hasNext()) {
            var item = iter.next();
            if (item.getStatus() == OrderStatus.DONE) {
                iter.remove();
                list.remove(item);
            }
        }
    }

    public T getFirstOrder() {
        return list.getFirst();
    }

}
