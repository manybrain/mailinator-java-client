package com.manybrain.mailinator.client.message;

import com.manybrain.mailinator.client.JsonUtils;
import lombok.Data;
import org.json.simple.JSONObject;

import java.util.List;

@Data
public class Attachments
{
    private List<Attachment> attachments;

    public static Attachments fromJson(JSONObject json) {
        if (json == null) return null;
        Attachments a = new Attachments();
        a.attachments = JsonUtils.getList(json, "attachments", Attachment::fromJson);
        return a;
    }
}