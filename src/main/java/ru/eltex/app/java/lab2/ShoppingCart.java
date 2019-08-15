package ru.eltex.app.java.lab2;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.Type;
import ru.eltex.app.java.lab1.Drinks;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * класс коллекция корзина
 *
 * @param <T> extends Drinks
 */
@Entity
public class ShoppingCart<T extends Drinks> implements Serializable {
    @Id
    @Column(name = "cart_id")
    @Expose
    private String cart_id;//id

    @Type(type = "ru.eltex.app.java.lab1.Drinks")
    @OneToMany(mappedBy = "cart", targetEntity = Drinks.class, fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @Expose
    private List<T> list = new ArrayList();//Коллекция для хранения объектов в классе «корзина»

    @Transient
    private HashSet<UUID> setId;//Коллекция для хранения и поиска уникальных идентификаторов

    @OneToMany(mappedBy = "cart", targetEntity = Order.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Order> orders = new LinkedList();

    public ShoppingCart() {
        this.cart_id = String.valueOf(UUID.randomUUID());
        this.setId = new HashSet<>();
    }

    public UUID getCart_id() {
        return UUID.fromString(cart_id);
    }

    public void setCart_id(UUID cart_id) {
        this.cart_id = String.valueOf(cart_id);
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public HashSet<UUID> getSetId() {
        return setId;
    }

    public void setSetId(HashSet<UUID> setId) {
        this.setId = setId;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
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

