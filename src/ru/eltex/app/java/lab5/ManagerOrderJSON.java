package ru.eltex.app.java.lab5;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.UUID;

/**
 * класс  ManagerOrderJSON для хранения заказов в виде текстового файла в формате JSON
 */
public final class ManagerOrderJSON extends AManageOrder {
    private final Gson gson;

    public ManagerOrderJSON() {
        final GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Order.class, new OrderDeserializer())
                .registerTypeAdapter(Orders.class, new OrdersSerializer())
                .registerTypeAdapter(Drinks.class, new DrinksDeserializer());
        gsonBuilder.serializeNulls();
        gson = gsonBuilder.setPrettyPrinting().create();
        file = new File("/home/nikita/work/dump.json");
    }

    @Override
    public Order readById(UUID id) {
        Order order = null;
        try (FileReader reader = new FileReader(file.getAbsoluteFile())) {
            Type type = new TypeToken<Order>() {
            }.getType();
            order = gson.fromJson(reader, type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public void saveById(Order order) {
        try (FileWriter writer = new FileWriter(file.getAbsoluteFile())) {

            gson.toJson(order, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Orders readAll() {
        Orders orders = null;
        try (FileReader reader = new FileReader(file.getAbsoluteFile())) {
            Type fooType = new TypeToken<Orders<Order>>() {
            }.getType();

            orders = gson.fromJson(reader, fooType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public void saveAll(Orders orders) {
        try (FileWriter writer = new FileWriter(file.getAbsoluteFile())) {
            gson.toJson(orders, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
