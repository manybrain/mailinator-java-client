package com.manybrain.mailinator.client.message;

import com.manybrain.mailinator.client.JsonUtils;
import lombok.Data;
import org.json.simple.JSONObject;

@Data
public class LinkEntity
{
    private String link;
    private String text;

    public static LinkEntity fromJson(JSONObject json) {
        if (json == null) return null;
        LinkEntity e = new LinkEntity();
        e.link = JsonUtils.getString(json, "link");
        e.text = JsonUtils.getString(json, "text");
        return e;
    }
}
