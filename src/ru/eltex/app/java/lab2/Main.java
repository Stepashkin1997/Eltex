package ru.eltex.app.java.lab2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final String Type;//Тип объекта
        int count;//Число объектов
        Drinks drinks = null;

        try {
            count = Integer.parseInt(args[0]);
            Type = args[1];
        } catch (Exception ex) {
            System.err.println("ERROR");
            return;
        }

        /*Создание пользователя*/
        Credentials credentials = new Credentials("Lol", "Kekovich", "Azaza", "123@ololo.ua");
        ShoppingCart cart = new ShoppingCart();//Создание корзины
        Orders orders = new Orders();//Список заказов

        for (int i = 0; i < count; i++) {
            switch (Type) {

                case "Tea": {
                    drinks = new Tea();
                    break;
                }

                case "Coffee": {
                    drinks = new Coffee();
                    break;
                }

                default: {
                    System.err.println("ERROR");
                    return;
                }
            }
            drinks.update();
            cart.add(drinks);//Добавление товара в корзину
        }

        /*установка даты ожидания заказа*/
        SimpleDateFormat sdf = new SimpleDateFormat("ss");
        Date date = null;
        try {
            date = sdf.parse("4");
        } catch (ParseException e) {
            e.printStackTrace();
            return;
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        orders.purchase(date, cart, credentials);
        orders.show();

        for (var item : orders.list) {
            item.setStatus("Done");
        }

        orders.clear();
        orders.show();

    }
}
