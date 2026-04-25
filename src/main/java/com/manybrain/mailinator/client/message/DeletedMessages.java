package com.manybrain.mailinator.client.message;

import com.manybrain.mailinator.client.JsonUtils;
import lombok.Data;
import org.json.simple.JSONObject;

@Data
public class DeletedMessages {
    private String status;
    private Integer count;

    public static DeletedMessages fromJson(JSONObject json) {
        if (json == null) return null;
        DeletedMessages d = new DeletedMessages();
        d.status = JsonUtils.getString(json, "status");
        d.count = JsonUtils.getInteger(json, "count");
        return d;
    }
}
