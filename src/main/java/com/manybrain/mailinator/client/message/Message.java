package com.manybrain.mailinator.client.message;

import com.manybrain.mailinator.client.JsonUtils;
import lombok.Data;
import org.json.simple.JSONObject;

import java.util.List;
import java.util.Map;

@Data
public class Message
{
    private Boolean isFirstExchange;
    private String fromfull;
    private Map<String, Object> headers;
    private String subject;
    private List<Part> parts;
    private String from;
    private String to;
    private String id;
    private Long time;
    private Long secondsAgo;
    private String domain;
    private String origfrom;
    private String mrid;
    private Integer size;
    private String stream;
    private String msgType;
    private String source;
    private String text;

    @SuppressWarnings("unchecked")
    public static Message fromJson(JSONObject json) {
        if (json == null) return null;
        Message m = new Message();
        m.isFirstExchange = JsonUtils.getBoolean(json, "is_first_exchange");
        m.fromfull = JsonUtils.getString(json, "fromfull");
        m.headers = (JSONObject) json.get("headers");
        m.subject = JsonUtils.getString(json, "subject");
        m.parts = JsonUtils.getList(json, "parts", Part::fromJson);
        m.from = JsonUtils.getString(json, "from");
        m.to = JsonUtils.getString(json, "to");
        m.id = JsonUtils.getString(json, "id");
        m.time = JsonUtils.getLong(json, "time");
        m.secondsAgo = JsonUtils.getLong(json, "seconds_ago");
        m.domain = JsonUtils.getString(json, "domain");
        m.origfrom = JsonUtils.getString(json, "origfrom");
        m.mrid = JsonUtils.getString(json, "mrid");
        m.size = JsonUtils.getInteger(json, "size");
        m.stream = JsonUtils.getString(json, "stream");
        m.msgType = JsonUtils.getString(json, "msg_type");
        m.source = JsonUtils.getString(json, "source");
        m.text = JsonUtils.getString(json, "text");
        return m;
    }
}
