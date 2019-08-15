package ru.eltex.app.java.lab7.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.eltex.app.java.lab1.Coffee;
import ru.eltex.app.java.lab1.Drinks;
import ru.eltex.app.java.lab1.Tea;
import ru.eltex.app.java.lab2.Credentials;
import ru.eltex.app.java.lab2.Order;
import ru.eltex.app.java.lab2.Orders;
import ru.eltex.app.java.lab2.ShoppingCart;
import ru.eltex.app.java.lab5.DrinksDeserializer;
import ru.eltex.app.java.lab5.OrderDeserializer;
import ru.eltex.app.java.lab5.OrdersDeserializer;
import ru.eltex.app.java.lab5.OrdersSerializer;
import ru.eltex.app.java.lab8.repositories.CredentialsRepository;
import ru.eltex.app.java.lab8.repositories.ShoppingCartRepository;
import ru.eltex.app.java.lab8.services.DrinksService;
import ru.eltex.app.java.lab8.services.OrderService;

@RestController
public class MyController {
    private static final Logger logger = Logger.getLogger(MyController.class);
    private final Gson gson = new GsonBuilder().registerTypeAdapter(Order.class, new OrderDeserializer())
            .registerTypeAdapter(Orders.class, new OrdersSerializer())
            .registerTypeAdapter(Orders.class, new OrdersDeserializer())
            .registerTypeAdapter(Drinks.class, new DrinksDeserializer()).excludeFieldsWithoutExposeAnnotation()
            .setPrettyPrinting().create();

    @Autowired
    private OrderService orderService;
    @Autowired
    private DrinksService drinksService;
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;
    @Autowired
    private CredentialsRepository credentialsRepository;

    @GetMapping(params = "command=readall")
    public String readall() {
        logger.info("readall");
        var A = orderService.readall();
        return gson.toJson(A);
    }

    @GetMapping(params = "command=readById")
    public String readById(String order_id) {
        logger.info("readById");
        var a = orderService.readById(order_id);
        if (a == null) {
            throw new NullPointerException();
        }
        return gson.toJson(a);
    }

    @GetMapping(params = "command=addToCard")
    public String addToCard(String card_id) {
        logger.info("addToCard");
        var cart = shoppingCartRepository.findById(card_id).get();
        if (cart == null) {
            throw new NullPointerException();
        }
        Drinks coffee = new Coffee();
        coffee.setCart(cart);
        drinksService.addToCard(coffee);
        return coffee.getId().toString();
    }

    @GetMapping(params = "command=delById")
    public String delById(String order_id) {
        logger.info("delById");
        Order order = orderService.readById(order_id);
        if (order == null) {
            throw new NullPointerException();
        }
        orderService.delete(order);
        return "0";
    }

    @GetMapping("/purchase")
    public String purchase() {
        Credentials user1 = new Credentials("Lol", "Kekovich", "Azaza", "123@ololo.ua");
        Credentials user2 = new Credentials("Kek", "Lolovich", "Azaza", "123@ololo.ua");
        credentialsRepository.saveAndFlush(user1);
        credentialsRepository.saveAndFlush(user2);

        ShoppingCart cartuser1 = new ShoppingCart();//Создание корзины
        ShoppingCart cartuser2 = new ShoppingCart();//Создание корзины
        shoppingCartRepository.saveAndFlush(cartuser1);
        shoppingCartRepository.saveAndFlush(cartuser2);

        Coffee coffee = new Coffee("A", 123, "IBM", "Eltex", "Arabic", cartuser1);
        drinksService.addToCard(coffee);
        drinksService.addToCard(new Coffee("B", 321, "IBM", "Eltex", "Arabic",
                cartuser1));

        drinksService.addToCard(new Tea("C", 456, "IBM", "Eltex", "Pacet", cartuser2));
        drinksService.addToCard(new Tea("D", 654, "IBM", "Eltex", "Pacet", cartuser2));

        orderService.add(new Order(cartuser1, user1));
        orderService.add(new Order(cartuser2, user2));

        return "DONE";
    }
}
