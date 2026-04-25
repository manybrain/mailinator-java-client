package com.manybrain.mailinator.client.authenticator;

import com.manybrain.mailinator.client.JsonUtils;
import lombok.Data;
import org.json.simple.JSONObject;

import java.util.List;

@Data
public class Authenticator {
    private String id;
    private Integer timeStep;
    private List<String> futureCodes;
    private Integer nextResetSeconds;
    private String passcode;

    public static Authenticator fromJson(JSONObject json) {
        if (json == null) return null;
        Authenticator a = new Authenticator();
        a.id = JsonUtils.getString(json, "id");
        a.timeStep = JsonUtils.getInteger(json, "time_step");
        a.futureCodes = JsonUtils.getStringList(json, "futurecodes");
        a.nextResetSeconds = JsonUtils.getInteger(json, "next_reset_secs");
        a.passcode = JsonUtils.getString(json, "passcode");
        return a;
    }
}
