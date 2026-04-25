package com.manybrain.mailinator.client.rule;

import com.manybrain.mailinator.client.JsonUtils;
import org.json.simple.JSONObject;

import java.util.List;

public class Rules
{
    public List<Rule> rules;

    public static Rules fromJson(JSONObject json) {
        if (json == null) return null;
        Rules r = new Rules();
        r.rules = JsonUtils.getList(json, "rules", Rule::fromJson);
        return r;
    }
}