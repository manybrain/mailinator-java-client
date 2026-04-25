package com.manybrain.mailinator.client.stats;

import com.manybrain.mailinator.client.JsonUtils;
import lombok.Data;
import org.json.simple.JSONObject;

@Data
public class Sent {
    private Integer sms;
    private Integer email;

    public static Sent fromJson(JSONObject json) {
        if (json == null) return null;
        Sent s = new Sent();
        s.sms = JsonUtils.getInteger(json, "sms");
        s.email = JsonUtils.getInteger(json, "email");
        return s;
    }
}