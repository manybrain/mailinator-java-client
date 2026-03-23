package com.manybrain.mailinator.client.authenticator;

import com.manybrain.mailinator.client.JsonUtils;
import lombok.Data;
import org.json.simple.JSONObject;

import java.util.List;

@Data
public class InstantTOTP2FACodeResponse {
    private Integer timeStep;
    private List<String> futureCodes;
    private Integer nextResetSeconds;
    private String passcode;

    public static InstantTOTP2FACodeResponse fromJson(JSONObject json) {
        if (json == null) return null;
        InstantTOTP2FACodeResponse r = new InstantTOTP2FACodeResponse();
        r.timeStep = JsonUtils.getInteger(json, "time_step");
        r.futureCodes = JsonUtils.getStringList(json, "futurecodes");
        r.nextResetSeconds = JsonUtils.getInteger(json, "next_reset_secs");
        r.passcode = JsonUtils.getString(json, "passcode");
        return r;
    }
}
