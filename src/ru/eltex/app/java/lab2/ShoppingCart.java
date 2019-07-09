package ru.eltex.app.java.lab2;

import java.util.ArrayList;
import java.util.UUID;


/*класс коллекция корзина*/
public class ShoppingCart {
    private ArrayList<Drinks> list;//Коллекция для хранения объектов в классе «корзина»

    public ShoppingCart() {
        list = new ArrayList();
    }

    /*метод добавления объекта из коллекции*/
    public void add(Drinks drink) {
        list.add(drink);
    }

    /*метод удаления объекта из коллекции*/
    public void delete(Drinks drink) {
        list.remove(drink);
    }

    /*функция вывода*/
    public void show() {
        for (var item : list) {
            item.read();
        }
    }

    /*функция поиска по индефикатору*/
    public Drinks search(UUID id) {
        for (var item : list) {
            if (item.getId().equals(id))
                return item;
        }
        return null;
    }
}
