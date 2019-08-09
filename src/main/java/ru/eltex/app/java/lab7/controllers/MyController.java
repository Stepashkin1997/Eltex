package ru.eltex.app.java.lab7.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.eltex.app.java.lab1.Coffee;
import ru.eltex.app.java.lab1.Drinks;
import ru.eltex.app.java.lab2.Order;
import ru.eltex.app.java.lab2.Orders;
import ru.eltex.app.java.lab2.ShoppingCart;
import ru.eltex.app.java.lab5.DrinksDeserializer;
import ru.eltex.app.java.lab5.OrderDeserializer;
import ru.eltex.app.java.lab5.OrdersDeserializer;
import ru.eltex.app.java.lab5.OrdersSerializer;

@RestController
public class MyController {
    private static final Logger logger = Logger.getLogger(MyController.class);
    private final Gson gson = new GsonBuilder().registerTypeAdapter(Order.class, new OrderDeserializer())
            .registerTypeAdapter(Orders.class, new OrdersSerializer())
            .registerTypeAdapter(Orders.class, new OrdersDeserializer())
            .registerTypeAdapter(Drinks.class, new DrinksDeserializer()).setPrettyPrinting().create();
    private Orders<?> orders;

    @Autowired
    public MyController(Orders<?> orders) {
        this.orders = orders;
    }

    @GetMapping(params = "command=readall")
    public String readall() {
        logger.info("readall");
        return gson.toJson(orders);
    }

    @GetMapping(params = "command=readById")
    public String readById(String order_id) {
        logger.info("readById");
        return gson.toJson(orders.find(order_id));
    }

    @GetMapping(params = "command=addToCard")
    public String addToCard(String card_id) {
        logger.info("addToCard");
        Drinks coffee = new Coffee();
        ShoppingCart<Drinks> cart = (ShoppingCart<Drinks>) orders.getCart(card_id);
        cart.add(coffee);
        return coffee.getId().toString();
    }

    @GetMapping(params = "command=delById")
    public String delById(String order_id) {
        logger.info("delById");
        Order order = orders.find(order_id);
        if (order == null) {
            throw new NullPointerException();
        }
        orders.remove(order_id);
        return "0";
    }
}
