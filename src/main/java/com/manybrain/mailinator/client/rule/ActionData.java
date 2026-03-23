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
public class ActionData
{
    public String url;

    public static ActionData fromJson(JSONObject json) {
        if (json == null) return null;
        ActionData a = new ActionData();
        a.url = JsonUtils.getString(json, "url");
        return a;
    }

    @SuppressWarnings("unchecked")
    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        if (url != null) json.put("url", url);
        return json;
    }
}