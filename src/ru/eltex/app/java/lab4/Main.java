package ru.eltex.app.java.lab4;

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
