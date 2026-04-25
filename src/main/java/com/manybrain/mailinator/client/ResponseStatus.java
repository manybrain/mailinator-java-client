package com.manybrain.mailinator.client;

import lombok.Data;
import org.json.simple.JSONObject;

@Data
public class ResponseStatus
{
    private String status;

    public static ResponseStatus fromJson(JSONObject json) {
        if (json == null) return null;
        ResponseStatus r = new ResponseStatus();
        r.status = JsonUtils.getString(json, "status");
        return r;
    }
}
