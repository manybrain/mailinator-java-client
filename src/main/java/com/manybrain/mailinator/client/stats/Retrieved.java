package com.manybrain.mailinator.client.stats;

import com.manybrain.mailinator.client.JsonUtils;
import lombok.Data;
import org.json.simple.JSONObject;

@Data
public class Retrieved {
    private Integer webPublic;
    private Integer apiError;
    private Integer webPrivate;
    private Integer apiEmail;

    public static Retrieved fromJson(JSONObject json) {
        if (json == null) return null;
        Retrieved r = new Retrieved();
        r.webPublic = JsonUtils.getInteger(json, "web_public");
        r.apiError = JsonUtils.getInteger(json, "api_error");
        r.webPrivate = JsonUtils.getInteger(json, "web_private");
        r.apiEmail = JsonUtils.getInteger(json, "api_email");
        return r;
    }
}