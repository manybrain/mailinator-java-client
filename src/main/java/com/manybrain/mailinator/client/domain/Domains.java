package com.manybrain.mailinator.client.domain;

import com.manybrain.mailinator.client.JsonUtils;
import lombok.Data;
import org.json.simple.JSONObject;

import java.util.List;

@Data
public class Domains
{
    private List<Domain> domains;

    public static Domains fromJson(JSONObject json) {
        if (json == null) return null;
        Domains d = new Domains();
        d.domains = JsonUtils.getList(json, "domains", Domain::fromJson);
        return d;
    }
}