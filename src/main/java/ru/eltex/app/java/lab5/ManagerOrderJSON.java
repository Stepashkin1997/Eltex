package ru.eltex.app.java.lab5;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ru.eltex.app.java.lab1.Drinks;
import ru.eltex.app.java.lab2.Order;
import ru.eltex.app.java.lab2.Orders;

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
                .registerTypeAdapter(Orders.class, new OrdersDeserializer())
                .registerTypeAdapter(Drinks.class, new DrinksDeserializer());
        gson = gsonBuilder.setPrettyPrinting().create();
        file = new File("/home/nikita/work/dump.json");
    }

    /**
     * чтенние из файла json по id
     * @param id индификтатор покоторому ищется
     * @return заказ котрорый был записан по id
     */
    @Override
    public Order readById(UUID id) {
        Order order = null;
        try (FileReader reader = new FileReader(file.getAbsoluteFile())) {
            if (!file.exists()) {
                return null;
            }
            Type type = new TypeToken<Order>() {
            }.getType();
            order = gson.fromJson(reader, type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return order;
    }

    /**
     * сохранение в файл json по id
     * @param order заказ который будет записан
     */
    @Override
    public void saveById(Order order) {
        try (FileWriter writer = new FileWriter(file.getAbsoluteFile())) {
            if (!file.exists()) {
                file.createNewFile();
            }
            gson.toJson(order, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * чтение в файл json всех объектов
     * @return класс orders со всеми заказами
     */
    @Override
    public Orders readAll() {
        Orders orders = null;
        try (FileReader reader = new FileReader(file.getAbsoluteFile())) {
            if (!file.exists()) {
                return null;
            }
            Type fooType = new TypeToken<Orders<Order>>() {
            }.getType();
            orders = gson.fromJson(reader, fooType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return orders;
    }

    /**
     * сохранение в файл json всех объектов
     * @param orders заказы которые будут записаны
     */
    @Override
    public void saveAll(Orders orders) {
        try (FileWriter writer = new FileWriter(file.getAbsoluteFile())) {
            if (!file.exists()) {
                file.createNewFile();
            }
            gson.toJson(orders, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
