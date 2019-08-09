package ru.eltex.app.java.lab7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.eltex.app.java.lab1.Coffee;
import ru.eltex.app.java.lab1.Drinks;
import ru.eltex.app.java.lab1.Tea;
import ru.eltex.app.java.lab2.Credentials;
import ru.eltex.app.java.lab2.Orders;
import ru.eltex.app.java.lab2.ShoppingCart;

@SpringBootApplication
public class SpringMvcApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SpringMvcApplication.class, args);
        ShoppingCart<Drinks> cart1 = (ShoppingCart<Drinks>) ctx.getBean("Cart1");//Создание корзины
        ShoppingCart<Drinks> cart2 = (ShoppingCart<Drinks>) ctx.getBean("Cart2");//Создание корзины2
        cart1.add(new Coffee("A", 123, "IBM", "Eltex", "Arabic"));
        cart1.add(new Tea("C", 456, "IBM", "Eltex", "Pacet"));
        cart2.add(new Coffee("B", 321, "IBM", "Eltex", "Arabic"));
        cart2.add(new Tea("D", 654, "IBM", "Eltex", "Pacet"));
        Orders<?> orders = (Orders) ctx.getBean("Orders");
        orders.purchase(cart1, (Credentials) ctx.getBean("Credentials"));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        orders.purchase(cart2, (Credentials) ctx.getBean("Credentials"));
    }
}
