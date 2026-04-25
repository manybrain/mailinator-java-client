package com.manybrain.mailinator.client.message;

import com.manybrain.mailinator.client.JsonUtils;
import com.manybrain.mailinator.client.rule.Rule;
import lombok.Data;
import org.json.simple.JSONObject;

import java.util.List;

@Data
public class PostedMessage
{
    private String status;
    private String id;
    private List<Rule> rulesFired;

    public static PostedMessage fromJson(JSONObject json) {
        if (json == null) return null;
        PostedMessage p = new PostedMessage();
        p.status = JsonUtils.getString(json, "status");
        p.id = JsonUtils.getString(json, "id");
        p.rulesFired = JsonUtils.getList(json, "rules_fired", Rule::fromJson);
        return p;
    }
}