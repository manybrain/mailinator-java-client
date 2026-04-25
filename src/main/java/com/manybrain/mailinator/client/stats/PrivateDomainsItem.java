package com.manybrain.mailinator.client.stats;

import com.manybrain.mailinator.client.JsonUtils;
import lombok.Data;
import org.json.simple.JSONObject;

@Data
public class PrivateDomainsItem {
    private String pd;
    private Boolean enabled;

    public static PrivateDomainsItem fromJson(JSONObject json) {
        if (json == null) return null;
        PrivateDomainsItem p = new PrivateDomainsItem();
        p.pd = JsonUtils.getString(json, "pd");
        p.enabled = JsonUtils.getBoolean(json, "enabled");
        return p;
    }
}