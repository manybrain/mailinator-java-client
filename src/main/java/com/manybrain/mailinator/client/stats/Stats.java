package com.manybrain.mailinator.client.stats;

import com.manybrain.mailinator.client.JsonUtils;
import lombok.Data;
import org.json.simple.JSONObject;

import java.util.List;

@Data
public class Stats {
    private List<StatsItem> stats;

    public static Stats fromJson(JSONObject json) {
        if (json == null) return null;
        Stats s = new Stats();
        s.stats = JsonUtils.getList(json, "stats", StatsItem::fromJson);
        return s;
    }
}