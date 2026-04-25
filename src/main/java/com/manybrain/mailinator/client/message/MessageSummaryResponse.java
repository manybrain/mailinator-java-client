package com.manybrain.mailinator.client.message;

import com.manybrain.mailinator.client.JsonUtils;
import lombok.Data;
import org.json.simple.JSONObject;

@Data
public class MessageSummaryResponse
{
    private MessageSummary summary;

    public static MessageSummaryResponse fromJson(JSONObject json) {
        if (json == null) return null;
        MessageSummaryResponse r = new MessageSummaryResponse();
        r.summary = MessageSummary.fromJson(JsonUtils.getObject(json, "summary"));
        return r;
    }
}
