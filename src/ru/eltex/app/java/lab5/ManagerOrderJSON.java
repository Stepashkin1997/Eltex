package ru.eltex.app.java.lab5;

import com.google.gson.Gson;

import java.io.*;
import java.util.UUID;

/**
 * класс  ManagerOrderJSON для хранения заказов в виде текстового файла в формате JSON
 */
public final class ManagerOrderJSON extends AManageOrder {
    private Gson gson;

    public ManagerOrderJSON() {
        gson = new Gson();
        file = new File("/home/nikita/work/dump.json");
    }

    @Override
    public Order readById(UUID id) {
        Order order = null;
        gson = new Gson();
        try (FileReader reader = new FileReader(file.getAbsoluteFile())) {
            order = gson.fromJson(reader, Order.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public void saveById(Order order) {
        gson = new Gson();
        try (FileWriter writer = new FileWriter(file.getAbsoluteFile())) {
            gson.toJson(order, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Orders readAll() {
        Orders orders = null;
        gson = new Gson();
        try (FileReader reader = new FileReader(file.getAbsoluteFile())) {
            orders = gson.fromJson(reader, Orders.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public void saveAll(Orders orders) {
        gson = new Gson();
        try (FileWriter writer = new FileWriter(file.getAbsoluteFile())) {
            gson.toJson(orders, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
