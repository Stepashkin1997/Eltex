package ru.eltex.app.java.lab4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.UUID;

/**
 * класс коллекция корзина
 * @param <T> extends Drinks
 */
public class ShoppingCart<T extends Drinks> {
    private ArrayList<T> list;//Коллекция для хранения объектов в классе «корзина»
    private HashSet<UUID> setId;//Коллекция для хранения и поиска уникальных идентификаторов

    public ShoppingCart() {
        list = new ArrayList();
        setId= new HashSet<>();
    }

    /**
     * метод добавления объекта из коллекции
     * @param drink
     */
    public void add(T drink) {
        list.add(drink);
        setId.add(drink.getId());
    }

    /**
     * метод удаления объекта из коллекции
     * @param drink
     */
    public void delete(T drink) {
        list.remove(drink);
        setId.remove(drink.getId());
    }

    /**
     * функция вывода
     */
    public void show() {
        for (var item : list) {
            item.read();
        }
    }

    /**
     * функция поиска по индефикатору
     * @param id id который проверяем
     * @return есть ли id в коллекции
     */
    public boolean search(UUID id) {
        return setId.contains(id);
    }
}
