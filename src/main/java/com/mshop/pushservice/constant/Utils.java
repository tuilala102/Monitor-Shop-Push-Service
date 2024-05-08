package com.mshop.pushservice.constant;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class Utils {


    private static final Gson gson = new GsonBuilder()
            // make it ignore unknown fields in json string
            .setLenient()
            .create();

    public static <T> T convertFromJson(String json, Class<T> type) {
        return gson.fromJson(json, type);
    }

    public static <T> List<T> convertFromJsonToList(String json, Class<T> type) {
        Type listType = TypeToken.getParameterized(List.class, type).getType();
        return gson.fromJson(json, listType);
    }

    public static String convertToJsonString(Object object) {
        return gson.toJson(object);
    }

}
