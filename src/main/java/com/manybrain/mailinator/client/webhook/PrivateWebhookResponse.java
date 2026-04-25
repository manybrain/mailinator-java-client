package com.manybrain.mailinator.client.webhook;

import com.manybrain.mailinator.client.JsonUtils;
import lombok.Data;
import org.json.simple.JSONObject;

@Data
public class PrivateWebhookResponse
{
    private String id;
    private String status;

    public static PrivateWebhookResponse fromJson(JSONObject json) {
        if (json == null) return null;
        PrivateWebhookResponse r = new PrivateWebhookResponse();
        r.id = JsonUtils.getString(json, "id");
        r.status = JsonUtils.getString(json, "status");
        return r;
    }
}
