package com.company;

import java.util.ArrayList;
import java.util.UUID;


/*класс коллекция корзина*/
public class ShoppingCart {
    private ArrayList<Drinks> list;

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
    public void show(UUID id) {
        for (var item : list) {
            System.out.println(item);
        }
    }

    /*функция поиска по индефикатору*/
    public Drinks search(UUID id) {
        for (var item : list) {
            System.out.println(item);
            if (item.getID().equals(id))
                return item;
        }
        return null;
    }
}
