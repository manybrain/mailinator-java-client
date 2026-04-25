package com.manybrain.mailinator.client.rule;

import com.manybrain.mailinator.client.JsonUtils;
import lombok.Data;
import org.json.simple.JSONObject;

import java.util.List;

@Data
public class Rule
{
    public String id;
    public String description;
    public Boolean enabled;
    public MatchType match;
    public String name;
    public List<Condition> conditions;
    public List<Action> actions;

    public static Rule fromJson(JSONObject json) {
        if (json == null) return null;
        Rule r = new Rule();
        r.id = JsonUtils.getString(json, "_id");
        r.description = JsonUtils.getString(json, "description");
        r.enabled = JsonUtils.getBoolean(json, "enabled");
        String match = JsonUtils.getString(json, "match");
        r.match = match != null ? MatchType.valueOf(match) : null;
        r.name = JsonUtils.getString(json, "name");
        r.conditions = JsonUtils.getList(json, "conditions", Condition::fromJson);
        r.actions = JsonUtils.getList(json, "actions", Action::fromJson);
        return r;
    }
}