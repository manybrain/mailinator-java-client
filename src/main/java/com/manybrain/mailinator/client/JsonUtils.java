package com.manybrain.mailinator.client;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JsonUtils {

    public static JSONObject parseObject(String json) {
        try {
            if (json == null || json.trim().isEmpty()) return null;
            Object parsed = new JSONParser().parse(json);
            if (parsed instanceof JSONObject) return (JSONObject) parsed;
            return null;
        } catch (ParseException e) {
            throw new RuntimeException("Failed to parse JSON object", e);
        }
    }

    public static String getString(JSONObject obj, String key) {
        if (obj == null) return null;
        Object val = obj.get(key);
        return val != null ? val.toString() : null;
    }

    public static Integer getInteger(JSONObject obj, String key) {
        if (obj == null) return null;
        Object val = obj.get(key);
        if (val == null) return null;
        if (val instanceof Long) return ((Long) val).intValue();
        if (val instanceof Integer) return (Integer) val;
        return Integer.parseInt(val.toString());
    }

    public static Long getLong(JSONObject obj, String key) {
        if (obj == null) return null;
        Object val = obj.get(key);
        if (val == null) return null;
        if (val instanceof Long) return (Long) val;
        if (val instanceof Integer) return ((Integer) val).longValue();
        return Long.parseLong(val.toString());
    }

    public static Boolean getBoolean(JSONObject obj, String key) {
        if (obj == null) return null;
        Object val = obj.get(key);
        if (val == null) return null;
        if (val instanceof Boolean) return (Boolean) val;
        return Boolean.parseBoolean(val.toString());
    }

    public static JSONObject getObject(JSONObject obj, String key) {
        if (obj == null) return null;
        return (JSONObject) obj.get(key);
    }

    public static <T> List<T> getList(JSONObject obj, String key, Function<JSONObject, T> mapper) {
        if (obj == null) return null;
        JSONArray arr = (JSONArray) obj.get(key);
        if (arr == null) return null;
        List<T> list = new ArrayList<>();
        for (Object item : arr) {
            list.add(mapper.apply((JSONObject) item));
        }
        return list;
    }

    public static List<String> getStringList(JSONObject obj, String key) {
        if (obj == null) return null;
        JSONArray arr = (JSONArray) obj.get(key);
        if (arr == null) return null;
        List<String> list = new ArrayList<>();
        for (Object item : arr) {
            list.add(item != null ? item.toString() : null);
        }
        return list;
    }
}
