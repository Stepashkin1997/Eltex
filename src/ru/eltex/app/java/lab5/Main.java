package ru.eltex.app.java.lab5;

public class Main {

    public static void main(String[] args) {
        Credentials user = new Credentials("Lol", "Kekovich", "Azaza", "123@ololo.ua");
        ShoppingCart cart1 = new ShoppingCart();//Создание корзины
        ShoppingCart cart2 = new ShoppingCart();//Создание корзины2

        Orders orders = new Orders();//Список заказов
        Coffee coffee = new Coffee("A", 123, "IBM", "Eltex", "Arabic");
        cart1.add(coffee);
        cart1.add(new Coffee("B", 321, "IBM", "Eltex", "Arabic"));
        orders.purchase(cart1, user);

        cart2.add(new Coffee("C", 222, "IBM", "Eltex", "Arabic"));
        cart2.add(new Coffee("B", 321, "IBM", "Eltex", "Arabic"));
        orders.purchase(cart1, user);

        ManagerOrderJSON json = new ManagerOrderJSON();
        ManagerOrderFile orderFile = new ManagerOrderFile();

        /*orderFile.saveAll(orders);
        Orders load=orderFile.readAll();
        load.show();*/
        /*Order qw = orders.getFirstOrder();
        orderFile.saveById(qw);
        Order order = orderFile.readById(qw.getId());
        order.print();*/
        /*json.saveAll(orders);*/
        Orders<Order> load=json.readAll();
        load.show();
    }

}
