package ru.eltex.app.java.lab7.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.eltex.app.java.lab1.Coffee;
import ru.eltex.app.java.lab1.Drinks;
import ru.eltex.app.java.lab2.Order;
import ru.eltex.app.java.lab2.Orders;
import ru.eltex.app.java.lab5.DrinksDeserializer;
import ru.eltex.app.java.lab5.OrderDeserializer;
import ru.eltex.app.java.lab5.OrdersDeserializer;
import ru.eltex.app.java.lab5.OrdersSerializer;

@Controller
public class MyController {
    private static final Logger logger = Logger.getLogger(MyController.class);
    private final Gson gson = new GsonBuilder().registerTypeAdapter(Order.class, new OrderDeserializer())
            .registerTypeAdapter(Orders.class, new OrdersSerializer())
            .registerTypeAdapter(Orders.class, new OrdersDeserializer())
            .registerTypeAdapter(Drinks.class, new DrinksDeserializer()).setPrettyPrinting().create();

    @RequestMapping(method = RequestMethod.GET, params = "command=readall")
    @ResponseBody
    public String readall() {
        return "readall";
    }

    @RequestMapping(method = RequestMethod.GET, params = "command=readById")
    @ResponseBody
    public String readById(int order_id) {
        String A = gson.toJson(order);
        return A;
    }

    @RequestMapping(method = RequestMethod.GET, params = "command=addToCard")
    @ResponseBody
    public String addToCard(int card_id) {
        Coffee coffee = new Coffee();
        return String.valueOf(coffee.getId());
    }


    @RequestMapping(method = RequestMethod.GET, params = "command=delById")
    @ResponseBody
    public String delById(int order_id) {
        return "delById";
    }
}
