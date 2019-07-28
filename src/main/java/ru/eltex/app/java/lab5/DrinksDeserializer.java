package ru.eltex.app.java.lab5;

import com.google.gson.*;
import ru.eltex.app.java.lab1.Coffee;
import ru.eltex.app.java.lab1.Drinks;
import ru.eltex.app.java.lab1.Tea;

import java.lang.reflect.Type;

public final class DrinksDeserializer implements JsonDeserializer<Drinks> {
    @Override
    public Drinks deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        if (jsonObject.has("typecofee")){
            return context.deserialize(jsonObject,
                    Coffee.class);
        }
        else {
            return context.deserialize(jsonObject,
                    Tea.class);
        }
    }
}
