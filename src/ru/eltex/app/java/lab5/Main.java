package ru.eltex.app.java.lab5;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;

public class Main {

    public static void main(String[] args) {
        Credentials user = new Credentials("Lol", "Kekovich", "Azaza", "123@ololo.ua");
        ShoppingCart<Coffee> cart1 = new ShoppingCart();//Создание корзины
        ShoppingCart<Drinks>  cart2 = new ShoppingCart();//Создание корзины2

        Orders orders = new Orders();//Список заказов
        Coffee coffee = new Coffee("A", 123, "IBM", "Eltex", "Arabic");
        cart1.add(coffee);
        cart1.add(new Coffee("B", 321, "IBM", "Eltex", "Arabic"));
        orders.purchase(cart1, user);

        cart2.add(new Coffee("C", 222, "IBM", "Eltex", "Arabic"));
        cart2.add(new Coffee("B", 321, "IBM", "Eltex", "Arabic"));
        orders.purchase(cart2, user);

      /*  ManagerOrderJSON json = new ManagerOrderJSON();
        ManagerOrderFile orderFile = new ManagerOrderFile();
        Order qw = orders.getFirstOrder();*/
        /*orderFile.saveAll(orders);
        Orders load=orderFile.readAll();
        load.show();*/
        /*
        orderFile.saveById(qw);
        Order order = orderFile.readById(qw.getId());
        order.print();*/
        /*json.saveAll(orders);
        Orders<Order> load=json.readAll();
        load.show();*/

        try (FileWriter writer = new FileWriter("/home/nikita/work/dump.json")) {

            new Gson().toJson(cart1, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileReader reader = new FileReader("/home/nikita/work/dump.json")) {
            Type type = new TypeToken<ShoppingCart<Coffee>>() {}.getType();
            ShoppingCart<Coffee> cart3 = new Gson().fromJson(reader, type);
            cart3.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
