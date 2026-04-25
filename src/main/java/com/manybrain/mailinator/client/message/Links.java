package com.manybrain.mailinator.client.message;

import com.manybrain.mailinator.client.JsonUtils;
import lombok.Data;
import org.json.simple.JSONObject;

import java.util.List;

@Data
public class Links {
    private List<String> links;

    public static Links fromJson(JSONObject json) {
        if (json == null) return null;
        Links l = new Links();
        l.links = JsonUtils.getStringList(json, "links");
        return l;
    }
}