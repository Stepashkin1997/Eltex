package ru.eltex.app.java.lab2;

import java.io.IOException;
import java.io.Serializable;
import java.net.*;
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
     * Функция вывода по id
     *
     * @param id
     * @return
     */
    public T find(String id) {

        var iter = createTime.values().iterator();
        while (iter.hasNext()) {
            var item = iter.next();
            if (id.equals(item.getOrder_id().toString())) {
                return item;
            }
        }
        return null;
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
        createTime.put(order.getOrdertime(), (T) order);
    }

    /**
     * Оформление покупки
     *
     * @param cart        Корзина
     * @param credentials Данные пользователя
     * @param address     Адресс отправителя заказа
     */
    public void purchase(ShoppingCart cart, Credentials credentials, InetAddress address, int port) {
        Order order = new Order(cart, credentials, address, port);
        list.add((T) order);
        createTime.put(order.getOrdertime(), (T) order);
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
            item.print();
            if (item.getStatus() == OrderStatus.WAITING) {
                item.setStatus(OrderStatus.DONE);
             /*   try (DatagramSocket datagramSocket = new DatagramSocket()) {
                    String str = String.valueOf(item.getDiff());
                    byte[] buf = str.getBytes();
                    datagramSocket.send(new DatagramPacket(buf, buf.length, item.getAddress(), item.getPort()));
                } catch (SocketException e) {
                    e.printStackTrace();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }*/
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

    public void remove(String id) {
        var iter = createTime.values().iterator();

        while (iter.hasNext()) {
            var item = iter.next();
            if (item.getOrder_id().toString().equals(id)) {
                iter.remove();
                list.remove(item);
                return;
            }
        }
    }

    public ShoppingCart<?> getCart(String id) {
        var iter = createTime.values().iterator();

        while (iter.hasNext()) {
            var item = iter.next();
            if (item.getCart().getCart_id().toString().equals(id)) {
                return item.getCart();
            }
        }
        return null;
    }
}
