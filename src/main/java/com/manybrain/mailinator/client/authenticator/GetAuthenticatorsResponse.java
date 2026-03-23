package com.manybrain.mailinator.client.authenticator;

import com.manybrain.mailinator.client.JsonUtils;
import lombok.Data;
import org.json.simple.JSONObject;

import java.util.List;

@Data
public class GetAuthenticatorsResponse {
    private List<Authenticator> passcodes;

    public static GetAuthenticatorsResponse fromJson(JSONObject json) {
        if (json == null) return null;
        GetAuthenticatorsResponse r = new GetAuthenticatorsResponse();
        r.passcodes = JsonUtils.getList(json, "passcodes", Authenticator::fromJson);
        return r;
    }
}
