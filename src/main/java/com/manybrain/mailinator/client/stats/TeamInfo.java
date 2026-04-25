package com.manybrain.mailinator.client.stats;

import com.manybrain.mailinator.client.JsonUtils;
import lombok.Data;
import org.json.simple.JSONObject;

import java.util.List;

@Data
public class TeamInfo {
    private String serverTime;
    private List<String> domains;

    public static TeamInfo fromJson(JSONObject json) {
        if (json == null) return null;
        TeamInfo t = new TeamInfo();
        t.serverTime = JsonUtils.getString(json, "server_time");
        t.domains = JsonUtils.getStringList(json, "private_domains");
        return t;
    }
}