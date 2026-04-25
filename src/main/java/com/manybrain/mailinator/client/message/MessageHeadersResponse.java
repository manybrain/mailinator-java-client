package com.manybrain.mailinator.client.message;

import com.manybrain.mailinator.client.JsonUtils;
import lombok.Data;
import org.json.simple.JSONObject;

import java.util.Map;

@Data
public class MessageHeadersResponse
{
    private Map<String, Object> headers;

    @SuppressWarnings("unchecked")
    public static MessageHeadersResponse fromJson(JSONObject json) {
        if (json == null) return null;
        MessageHeadersResponse r = new MessageHeadersResponse();
        r.headers = (JSONObject) json.get("headers");
        return r;
    }
}
