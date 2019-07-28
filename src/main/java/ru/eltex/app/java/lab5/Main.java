package ru.eltex.app.java.lab5;

import ru.eltex.app.java.lab1.Coffee;
import ru.eltex.app.java.lab1.Drinks;
import ru.eltex.app.java.lab1.Tea;
import ru.eltex.app.java.lab2.Credentials;
import ru.eltex.app.java.lab2.Order;
import ru.eltex.app.java.lab2.Orders;
import ru.eltex.app.java.lab2.ShoppingCart;

public class Main {

    public static void main(String[] args) {
        Credentials user = new Credentials("Lol", "Kekovich", "Azaza", "123@ololo.ua");
        ShoppingCart<Drinks> cart1 = new ShoppingCart();//Создание корзины
        ShoppingCart<Drinks> cart2 = new ShoppingCart();//Создание корзины2
        ManagerOrderJSON json = new ManagerOrderJSON();
        ManagerOrderFile orderFile = new ManagerOrderFile();
        Orders<Order> orders = new Orders();//Список заказов
        Coffee coffee = new Coffee("A", 123, "IBM", "Eltex", "Arabic");
        cart1.add(coffee);
        cart1.add(new Tea("C", 456, "IBM", "Eltex", "Pacet"));
        orders.purchase(cart1, user);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        cart2.add(new Coffee("C", 222, "IBM", "Eltex", "Arabic"));
        cart2.add(new Coffee("B", 321, "IBM", "Eltex", "Arabic"));
        orders.purchase(cart2, user);

        Order order = new Order(cart1, user);
        json.saveById(order);//сохранение заказов
        Orders orders1 = json.readAll();//чение заказов
        orders1.show();
       /*orderFile.saveAll(orders);
        Orders orders1 = orderFile.readAll();//чение заказов*/
        /*orderFile.saveById(order);
        Order order1 = orderFile.readById(order.getId());//чение заказов
        order1.print();//показ*/
    }

}
