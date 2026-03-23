package com.manybrain.mailinator.client.rule;

import com.manybrain.mailinator.client.JsonUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.simple.JSONObject;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Action
{
    public ActionType action;
    public ActionData actionData;
    public String destination;

    public static Action fromJson(JSONObject json) {
        if (json == null) return null;
        Action a = new Action();
        String act = JsonUtils.getString(json, "action");
        a.action = act != null ? ActionType.valueOf(act) : null;
        a.actionData = ActionData.fromJson(JsonUtils.getObject(json, "action_data"));
        a.destination = JsonUtils.getString(json, "destination");
        return a;
    }

    @SuppressWarnings("unchecked")
    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        if (action != null) json.put("action", action.name());
        if (actionData != null) json.put("action_data", actionData.toJSON());
        if (destination != null) json.put("destination", destination);
        return json;
    }
}