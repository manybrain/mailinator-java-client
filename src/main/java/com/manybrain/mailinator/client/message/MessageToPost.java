package com.manybrain.mailinator.client.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import org.json.simple.JSONObject;

@Data
@AllArgsConstructor
public class MessageToPost
{
    @NonNull
    private String subject;
    @NonNull
    private String from;
    @NonNull
    private String text;

    @SuppressWarnings("unchecked")
    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        json.put("subject", subject);
        json.put("from", from);
        json.put("text", text);
        return json;
    }
}
