package com.manybrain.mailinator.client.stats;

import com.manybrain.mailinator.client.JsonUtils;
import lombok.Data;
import org.json.simple.JSONObject;

@Data
public class StatsItem {
    private String date;
    private Retrieved retrieved;
    private Sent sent;

    public static StatsItem fromJson(JSONObject json) {
        if (json == null) return null;
        StatsItem s = new StatsItem();
        s.date = JsonUtils.getString(json, "date");
        s.retrieved = Retrieved.fromJson(JsonUtils.getObject(json, "retrieved"));
        s.sent = Sent.fromJson(JsonUtils.getObject(json, "sent"));
        return s;
    }
}