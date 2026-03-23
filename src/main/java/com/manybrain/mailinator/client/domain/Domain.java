package com.manybrain.mailinator.client.domain;

import com.manybrain.mailinator.client.JsonUtils;
import com.manybrain.mailinator.client.rule.Rule;
import lombok.Data;
import org.json.simple.JSONObject;

import java.util.List;

@Data
public class Domain {
    private String id;
    private String description;
    private Boolean enabled;
    private String name;
    private String ownerid;
    private List<Rule> rules;

    public static Domain fromJson(JSONObject json) {
        if (json == null) return null;
        Domain d = new Domain();
        d.id = JsonUtils.getString(json, "_id");
        d.description = JsonUtils.getString(json, "description");
        d.enabled = JsonUtils.getBoolean(json, "enabled");
        d.name = JsonUtils.getString(json, "name");
        d.ownerid = JsonUtils.getString(json, "ownerid");
        d.rules = JsonUtils.getList(json, "rules", Rule::fromJson);
        return d;
    }
}
