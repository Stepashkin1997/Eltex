package ru.eltex.app.java.lab5;

import com.google.gson.*;
import ru.eltex.app.java.lab2.Orders;

import java.lang.reflect.Type;


public final class OrdersSerializer implements JsonSerializer<Orders> {
    @Override
    public JsonElement serialize(Orders orders, Type type, JsonSerializationContext context) {
        JsonObject result = new JsonObject();
        result.add("map", context.serialize(orders.getCreateTime().values()));
        return result;
    }
}
