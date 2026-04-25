package com.manybrain.mailinator.client.message;

import com.manybrain.mailinator.client.JsonUtils;
import lombok.Data;
import org.json.simple.JSONObject;

@Data
public class MessageTextResponse
{
    private String text;

    public static MessageTextResponse fromJson(JSONObject json) {
        if (json == null) return null;
        MessageTextResponse r = new MessageTextResponse();
        r.text = JsonUtils.getString(json, "text");
        return r;
    }
}
