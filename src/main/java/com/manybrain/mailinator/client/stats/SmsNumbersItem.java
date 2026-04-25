package com.manybrain.mailinator.client.stats;

import com.manybrain.mailinator.client.JsonUtils;
import lombok.Data;
import org.json.simple.JSONObject;

@Data
public class SmsNumbersItem {
    private String number;
    private String country;
    private String status;

    public static SmsNumbersItem fromJson(JSONObject json) {
        if (json == null) return null;
        SmsNumbersItem s = new SmsNumbersItem();
        s.number = JsonUtils.getString(json, "number");
        s.country = JsonUtils.getString(json, "country");
        s.status = JsonUtils.getString(json, "status");
        return s;
    }
}