package ru.eltex.app.java.lab5;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.sql.Date;
import java.util.HashMap;
import java.util.LinkedList;

public final class OrdersDeserializer implements JsonDeserializer<Orders> {
    @Override
    public Orders deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        Type listType = new TypeToken<LinkedList<Order>>() {
        }.getType();
        LinkedList<Order> list = context.deserialize(jsonObject.get("map"), listType);
        HashMap<Date, Order> map = new HashMap<>();
        for (var item : list) {
            map.put(item.getOrdertime(),item);
        }
        return new Orders(list,map);
    }
}
