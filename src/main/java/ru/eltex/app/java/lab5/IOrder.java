package ru.eltex.app.java.lab5;

import ru.eltex.app.java.lab2.Order;
import ru.eltex.app.java.lab2.Orders;

import java.util.UUID;

/**
 * интерфейс для хранения заказов
 */
public interface IOrder {

    /**
     * чтенние из файла по id
     *
     * @param id индификтатор покоторому ищется
     * @return возвращает Order
     */
    Order readById(UUID id);

    /**
     * сохранение в файл по id
     *
     * @param order заказ который будет записан
     */
    void saveById(Order order);

    /**
     * чтение в файл всех объектов
     *
     * @return возвращает Orders
     */
    Orders readAll();

    /**
     * сохранение в файл всех объектов
     *
     * @param orders заказы которые будут записаны
     */
    void saveAll(Orders orders);

}
