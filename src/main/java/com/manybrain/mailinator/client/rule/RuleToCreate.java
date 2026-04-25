package com.manybrain.mailinator.client.rule;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class RuleToCreate
{
    private String description;
    @Builder.Default
    private Boolean enabled = Boolean.TRUE;
    @Builder.Default
    public MatchType match = MatchType.ALL;
    @NonNull
    private String name;
    @NonNull
    private Integer priority;
    @NonNull
    private List<Condition> conditions;
    @NonNull
    private List<Action> actions;

    @SuppressWarnings("unchecked")
    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        if (description != null) json.put("description", description);
        json.put("enabled", enabled != null ? enabled : Boolean.TRUE);
        json.put("match", match != null ? match.name() : MatchType.ALL.name());
        json.put("name", name);
        json.put("priority", priority);
        JSONArray condArray = new JSONArray();
        if (conditions != null) {
            for (Condition c : conditions) condArray.add(c.toJSON());
        }
        json.put("conditions", condArray);
        JSONArray actArray = new JSONArray();
        if (actions != null) {
            for (Action a : actions) actArray.add(a.toJSON());
        }
        json.put("actions", actArray);
        return json;
    }
}