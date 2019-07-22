package ru.eltex.app.java.lab5;

public class Main {

    public static void main(String[] args) {
        Credentials user = new Credentials("Lol", "Kekovich", "Azaza", "123@ololo.ua");
        ShoppingCart<Drinks> cart1 = new ShoppingCart();//Создание корзины
        ShoppingCart<Drinks> cart2 = new ShoppingCart();//Создание корзины2

        Orders<Order> orders = new Orders();//Список заказов
        Coffee coffee = new Coffee("A", 123, "IBM", "Eltex", "Arabic");
        cart1.add(coffee);
        cart1.add(new Tea("C", 456, "IBM", "Eltex", "Pacet"));
        orders.purchase(cart1, user);

        cart2.add(new Coffee("C", 222, "IBM", "Eltex", "Arabic"));
        cart2.add(new Coffee("B", 321, "IBM", "Eltex", "Arabic"));
        orders.purchase(cart2, user);

        ManagerOrderJSON json = new ManagerOrderJSON();
        ManagerOrderFile orderFile = new ManagerOrderFile();
    /*    Order order = new Order(cart1, user);*/
        json.saveAll(orders);
        /*Orders orders1 = json.readAll();
        orders1.show();*/
    }

}
