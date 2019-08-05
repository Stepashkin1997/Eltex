package ru.eltex.app.java.lab7;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.eltex.app.java.lab1.Coffee;
import ru.eltex.app.java.lab1.Drinks;
import ru.eltex.app.java.lab1.Tea;
import ru.eltex.app.java.lab2.Credentials;
import ru.eltex.app.java.lab2.Order;
import ru.eltex.app.java.lab2.Orders;
import ru.eltex.app.java.lab2.ShoppingCart;

@SpringBootApplication
public class SpringMvcApplication {
    private static final Logger logger = Logger.getLogger(SpringMvcApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcApplication.class, args);
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
    }
}
