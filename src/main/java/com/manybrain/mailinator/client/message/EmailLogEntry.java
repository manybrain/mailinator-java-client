package com.manybrain.mailinator.client.message;

import com.manybrain.mailinator.client.JsonUtils;
import lombok.Data;
import org.json.simple.JSONObject;

@Data
public class EmailLogEntry {
    private String log;
    private String time;
    private String event;

    public static EmailLogEntry fromJson(JSONObject json) {
        if (json == null) return null;
        EmailLogEntry e = new EmailLogEntry();
        e.log = JsonUtils.getString(json, "log");
        e.time = JsonUtils.getString(json, "time");
        e.event = JsonUtils.getString(json, "event");
        return e;
    }
}