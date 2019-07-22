package ru.eltex.app.java.lab5;

import java.io.*;
import java.util.UUID;

/**
 * класс  ManagerOrderFile для хранения заказов в виде двоичного файла
 */
public final class ManagerOrderFile extends AManageOrder {

    public ManagerOrderFile() {
        file = new File("/home/nikita/work/dump.bin");
    }

    @Override
    public Order readById(UUID id) {
        Order order = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file.getAbsoluteFile()))) {
            if (!file.exists()) {
                return null;
            }
            order = (Order) objectInputStream.readObject();

            if (!order.getId().equals(id)) {
                order = null;
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return order;
    }

    @Override
    public void saveById(Order order) {

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file.getAbsoluteFile()))) {
            if (file.exists()) ;
            else
                file.createNewFile();

            objectOutputStream.writeObject(order);
            objectOutputStream.flush();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public Orders readAll() {
        Orders orders = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file.getAbsoluteFile()))) {
            if (!file.exists()) {
                return null;
            }

            orders = (Orders) objectInputStream.readObject();

        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return orders;
    }

    @Override
    public void saveAll(Orders orders) {

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file.getAbsoluteFile()))) {

            if (file.exists()) ;
            else
                file.createNewFile();

            objectOutputStream.writeObject(orders);
            objectOutputStream.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
