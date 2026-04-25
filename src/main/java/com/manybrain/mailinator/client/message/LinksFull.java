package com.manybrain.mailinator.client.message;

import com.manybrain.mailinator.client.JsonUtils;
import lombok.Data;
import org.json.simple.JSONObject;

import java.util.List;

@Data
public class LinksFull {
    private List<LinkEntity> links;

    public static LinksFull fromJson(JSONObject json) {
        if (json == null) return null;
        LinksFull l = new LinksFull();
        l.links = JsonUtils.getList(json, "links", LinkEntity::fromJson);
        return l;
    }
}