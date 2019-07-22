package ru.eltex.app.java.lab5;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.UUID;

public final class OrderDeserializer implements JsonDeserializer<Order> {
    @Override
    public Order deserialize(JsonElement json, Type type, JsonDeserializationContext context)
            throws JsonParseException {
        JsonObject jobject = json.getAsJsonObject();
        Gson gson = new GsonBuilder()
         .registerTypeAdapter(Drinks.class, new DrinksDeserializer())
         .create();
        UUID id = UUID.fromString(jobject.get("id").getAsString());
        var status = OrderStatus.valueOf(jobject.get("status").getAsString());

        Date ordertime=null;
        DateFormat format = new SimpleDateFormat("MMMM d, yyyy");
        try {
            ordertime=new Date(format.parse(jobject.get("ordertime").getAsString()).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        var diff = jobject.get("diff").getAsLong();
        Type typecart = new TypeToken<ShoppingCart<Drinks>>() {
        }.getType();
        ShoppingCart<Drinks> cart=context.deserialize(jobject.get("cart"), typecart);
        Credentials credentials = new Gson().fromJson(jobject.get("credentials"), Credentials.class);
        return new Order(id,status,ordertime,diff,cart, credentials);

    }
}
