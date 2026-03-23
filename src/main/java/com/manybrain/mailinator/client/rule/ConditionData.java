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
public class ConditionData
{
    public OperationType operation;
    @Builder.Default
    public String field = "to";
    public String value;

    public static ConditionData fromJson(JSONObject json) {
        if (json == null) return null;
        ConditionData c = new ConditionData();
        String op = JsonUtils.getString(json, "operation");
        c.operation = op != null ? OperationType.valueOf(op) : null;
        c.field = JsonUtils.getString(json, "field");
        c.value = JsonUtils.getString(json, "value");
        return c;
    }

    @SuppressWarnings("unchecked")
    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        if (operation != null) json.put("operation", operation.name());
        if (field != null) json.put("field", field);
        if (value != null) json.put("value", value);
        return json;
    }
}