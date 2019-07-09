package ru.eltex.app.java.lab2;

public class Main {

    public static void main(String[] args) {
        final String Type;//Тип объекта
        int count;//Число объектов
        Drinks drinks = null;
        /*Создание пользователя*/
        Credentials credentials = new Credentials("Lol", "Kekovich", "Azaza", "123@ololo.ua");
        ShoppingCart cart = new ShoppingCart();//Создание корзины
        Orders orders = new Orders();//Список заказов

        try {
            count = Integer.parseInt(args[0]);
            Type = args[1];
        } catch (Exception ex) {
            System.err.println("ERROR");
            return;
        }

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
            try {
                drinks.update();
            } catch (Exception e) {
                System.err.println("Wrong entering");
                return;
            }
            cart.add(drinks);//Добавление товара в корзину
        }


        System.out.println("Поиск по индефикатору в корзине " + drinks.getId() + ":");
        System.out.println(cart.search(drinks.getId()));//поиск по индефикатору

        /*Показ корзины*/
        System.out.println();
        System.out.println("Показ корзины: ");
        cart.show();//показ всей корзины

/*      //Удаление из корзины
        System.out.println();
        System.out.println("Удаление из корзины: ");
        cart.delete(drinks);//удаление*/

        /*Показ корзины*/
        System.out.println();
        System.out.println("Показ корзины: ");
        cart.show();//показ всей корзины

        /*Показ списка заказов*/
        System.out.println();
        System.out.println("Показ списка заказов:");
        orders.purchase(cart, credentials);//оформить покупку
        orders.show();//показать

        /*Все заказы в orders готовы*/
        for (var item : orders.list) {
            item.setStatus(OrderStatus.DONE);
        }

        /*Отчистка и показ*/
        System.out.println();
        System.out.println("Отчистка и показ:");
        orders.clear();//отчистить заказы от готовых
        orders.show();//показать

    }
}
