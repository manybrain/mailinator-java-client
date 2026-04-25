package com.manybrain.mailinator.client.message;

import com.manybrain.mailinator.client.JsonUtils;
import lombok.Data;
import org.json.simple.JSONObject;

import java.util.Map;

@Data
public class Part
{
    private Map<String, Object> headers;
    private String body;

    @SuppressWarnings("unchecked")
    public static Part fromJson(JSONObject json) {
        if (json == null) return null;
        Part p = new Part();
        p.headers = (JSONObject) json.get("headers");
        p.body = JsonUtils.getString(json, "body");
        return p;
    }
}