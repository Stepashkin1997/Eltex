package ru.eltex.app.java.lab6;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;


public final class OrdersSerializer implements JsonSerializer<Orders> {
    @Override
    public JsonElement serialize(Orders orders, Type type, JsonSerializationContext context) {
        JsonObject result = new JsonObject();
        result.add("map", context.serialize(orders.getCreateTime().values()));
        return result;
    }
}
