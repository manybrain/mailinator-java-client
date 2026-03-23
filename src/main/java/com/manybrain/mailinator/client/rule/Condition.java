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
public class Condition {
    public OperationType operation;
    public ConditionData conditionData;

    public static Condition fromJson(JSONObject json) {
        if (json == null) return null;
        Condition c = new Condition();
        String op = JsonUtils.getString(json, "operation");
        c.operation = op != null ? OperationType.valueOf(op) : null;
        c.conditionData = ConditionData.fromJson(JsonUtils.getObject(json, "condition_data"));
        return c;
    }

    @SuppressWarnings("unchecked")
    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        if (operation != null) json.put("operation", operation.name());
        if (conditionData != null) json.put("condition_data", conditionData.toJSON());
        return json;
    }
}