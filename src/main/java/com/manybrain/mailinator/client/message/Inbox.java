package com.manybrain.mailinator.client.message;

import com.manybrain.mailinator.client.JsonUtils;
import lombok.Data;
import org.json.simple.JSONObject;

import java.util.List;

@Data
public class Inbox
{
    private String domain;
    private String to;
    private List<Message> msgs;
    private String cursor;

    public static Inbox fromJson(JSONObject json) {
        if (json == null) return null;
        Inbox i = new Inbox();
        i.domain = JsonUtils.getString(json, "domain");
        i.to = JsonUtils.getString(json, "to");
        i.msgs = JsonUtils.getList(json, "msgs", Message::fromJson);
        i.cursor = JsonUtils.getString(json, "cursor");
        return i;
    }
}
