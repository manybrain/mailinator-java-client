package com.manybrain.mailinator.client.stats;

import com.manybrain.mailinator.client.JsonUtils;
import lombok.Data;
import org.json.simple.JSONObject;

@Data
public class MembersItem {
    private String role;
    private String id;
    private String email;

    public static MembersItem fromJson(JSONObject json) {
        if (json == null) return null;
        MembersItem m = new MembersItem();
        m.role = JsonUtils.getString(json, "role");
        m.id = JsonUtils.getString(json, "_id");
        m.email = JsonUtils.getString(json, "email");
        return m;
    }
}