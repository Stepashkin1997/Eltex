package ru.eltex.app.java.lab3;

import ru.eltex.app.java.lab1.Coffee;
import ru.eltex.app.java.lab1.Drinks;
import ru.eltex.app.java.lab1.Tea;
import ru.eltex.app.java.lab2.Credentials;
import ru.eltex.app.java.lab2.Order;
import ru.eltex.app.java.lab2.Orders;
import ru.eltex.app.java.lab2.ShoppingCart;

public class Main {

    public static void main(String[] args) {
        ShoppingCart<Drinks> cart = new ShoppingCart<>();
        Tea tea = new Tea();
        Coffee coffee = new Coffee();
        cart.add(tea);
        cart.add(coffee);


        Credentials user = new Credentials("Lol", "Kekovich", "Azaza", "123@ololo.ua");

        Orders<Order> orders = new Orders();
        orders.purchase(cart, user);
        orders.show();
    }
}
