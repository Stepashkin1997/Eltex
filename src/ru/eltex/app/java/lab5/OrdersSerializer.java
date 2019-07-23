package ru.eltex.app.java.lab5;

import com.google.gson.*;
import java.lang.reflect.Type;


public final class OrdersSerializer implements JsonSerializer<Orders> {
    @Override
    public JsonElement serialize(Orders orders, Type type, JsonSerializationContext context) {
        JsonObject result = new JsonObject();
        result.add("map", context.serialize(orders.getCreateTime().values()));
        return result;
    }
}
