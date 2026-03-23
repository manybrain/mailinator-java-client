package com.manybrain.mailinator.client.stats;

import com.manybrain.mailinator.client.JsonUtils;
import lombok.Data;
import org.json.simple.JSONObject;

import java.util.List;

@Data
public class Team {
    private List<PrivateDomainsItem> privateDomains;
    private List<SmsNumbersItem> smsNumbers;
    private List<MembersItem> members;
    private PlanData planData;
    private String id;
    private String plan;
    private String teamName;
    private String token;
    private String status;

    public static Team fromJson(JSONObject json) {
        if (json == null) return null;
        Team t = new Team();
        t.privateDomains = JsonUtils.getList(json, "private_domains", PrivateDomainsItem::fromJson);
        t.smsNumbers = JsonUtils.getList(json, "sms_numbers", SmsNumbersItem::fromJson);
        t.members = JsonUtils.getList(json, "members", MembersItem::fromJson);
        t.planData = PlanData.fromJson(JsonUtils.getObject(json, "plan_data"));
        t.id = JsonUtils.getString(json, "_id");
        t.plan = JsonUtils.getString(json, "plan");
        t.teamName = JsonUtils.getString(json, "team_name");
        t.token = JsonUtils.getString(json, "token");
        t.status = JsonUtils.getString(json, "status");
        return t;
    }
}