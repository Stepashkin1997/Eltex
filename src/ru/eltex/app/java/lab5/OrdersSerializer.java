package ru.eltex.app.java.lab5;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.sql.Date;
import java.util.HashMap;

public class OrdersSerializer implements JsonSerializer<Orders> {
    @Override
    public JsonElement serialize(Orders orders, Type type, JsonSerializationContext context) {
        JsonObject result = new JsonObject();
        Type itemsMapType = new TypeToken<HashMap<Order, Date>>() {
        }.getType();
        result.add("map", context.serialize(orders.getCreateTime(), itemsMapType));

        return result;
    }
}
