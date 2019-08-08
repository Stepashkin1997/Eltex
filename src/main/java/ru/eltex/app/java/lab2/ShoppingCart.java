package ru.eltex.app.java.lab2;

import ru.eltex.app.java.lab1.Drinks;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.UUID;

/**
 * класс коллекция корзина
 *
 * @param <T> extends Drinks
 */
public final class ShoppingCart<T extends Drinks> implements Serializable {
    private UUID id;//id
    private ArrayList<T> list;//Коллекция для хранения объектов в классе «корзина»
    private HashSet<UUID> setId;//Коллекция для хранения и поиска уникальных идентификаторов

    public ShoppingCart() {
        this.id = UUID.randomUUID();
        this.list = new ArrayList();
        this.setId = new HashSet<>();
    }

    public UUID getId() {
        return id;
    }

    /**
     * метод добавления объекта из коллекции
     *
     * @param drink
     */
    public void add(T drink) {
        list.add(drink);
        setId.add(drink.getId());
    }

    /**
     * метод удаления объекта из коллекции
     *
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
     *
     * @param id id который проверяем
     * @return есть ли id в коллекции
     */
    public boolean search(UUID id) {
        return setId.contains(id);
    }
}

