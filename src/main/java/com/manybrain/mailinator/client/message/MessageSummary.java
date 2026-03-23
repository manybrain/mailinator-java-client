package com.manybrain.mailinator.client.message;

import com.manybrain.mailinator.client.JsonUtils;
import lombok.Data;
import org.json.simple.JSONObject;

@Data
public class MessageSummary
{
    private String id;
    private String subject;
    private String domain;
    private String from;
    private String origfrom;
    private String to;
    private Long time;
    private Long secondsAgo;
    private String source;

    public static MessageSummary fromJson(JSONObject json) {
        if (json == null) return null;
        MessageSummary s = new MessageSummary();
        s.id = JsonUtils.getString(json, "id");
        s.subject = JsonUtils.getString(json, "subject");
        s.domain = JsonUtils.getString(json, "domain");
        s.from = JsonUtils.getString(json, "from");
        s.origfrom = JsonUtils.getString(json, "origfrom");
        s.to = JsonUtils.getString(json, "to");
        s.time = JsonUtils.getLong(json, "time");
        s.secondsAgo = JsonUtils.getLong(json, "seconds_ago");
        s.source = JsonUtils.getString(json, "source");
        return s;
    }
}
