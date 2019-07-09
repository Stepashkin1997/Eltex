package ru.eltex.app.java.lab2;

public class Main {

    public static void main(String[] args) {

        /*Создание пользователя*/
        Credentials user1 = new Credentials("Lol", "Kekovich", "Azaza", "123@ololo.ua");
        Credentials user2 = new Credentials("Kek", "Lolovich", "Azaza", "123@ololo.ua");
        ShoppingCart cartuser1 = new ShoppingCart();//Создание корзины
        ShoppingCart cartuser2 = new ShoppingCart();//Создание корзины
        Orders orders = new Orders();//Список заказов

        Coffee coffee = new Coffee("A", 123, "IBM", "Eltex", "Arabic");
        cartuser1.add(coffee);
        cartuser1.add(new Coffee("B", 321, "IBM", "Eltex", "Arabic"));

        cartuser2.add(new Tea("C", 456, "IBM", "Eltex", "Pacet"));
        cartuser2.add(new Tea("D", 654, "IBM", "Eltex", "Pacet"));

        orders.purchase(cartuser1, user1);
        orders.purchase(cartuser2, user2);

        /*Поиск в корзине*/
        System.out.println();
        System.out.println("Поиск в корзине: ");
        System.out.println("есть ли id=" + coffee.getId() + " в корзине: " + cartuser1.search(coffee.getId()));

        /*Показ корзины*/
        System.out.println();
        System.out.println("Показ корзины: ");
        cartuser1.show();//показ всей корзины

        //Удаление из корзины
        System.out.println();
        System.out.println("Удаление из корзины: ");
        cartuser1.delete(coffee);//удаление

        /*Показ корзины*/
        System.out.println();
        System.out.println("Показ корзины: ");
        cartuser1.show();//показ всей корзины

        /*Показ списка заказов*/
        System.out.println();
        System.out.println("Показ списка заказов:");
        orders.show();//показать

        /*Все заказы в orders готовы*/
        orders.setDoneAll();

        /*Отчистка и показ*/
        System.out.println();
        System.out.println("Отчистка и показ:");
        orders.clear();//отчистить заказы от готовых
        orders.show();//показать

    }
}
