package com.company;

import java.util.LinkedList;

/*Класс коллекция заказы*/
public class Orders {
    private LinkedList list;

    public Orders() {
        list = new LinkedList();
    }

    /*функция вывода*/
    public void show() {
        for (var item : list) {
            System.out.println(item);
        }
    }
}
