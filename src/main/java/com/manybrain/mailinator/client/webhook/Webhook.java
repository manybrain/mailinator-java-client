package com.manybrain.mailinator.client.webhook;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.simple.JSONObject;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Webhook {
    private String from;
    public String subject;
    public String text;
    public String to;

    @SuppressWarnings("unchecked")
    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        if (from != null) json.put("from", from);
        if (subject != null) json.put("subject", subject);
        if (text != null) json.put("text", text);
        if (to != null) json.put("to", to);
        return json;
    }
}
