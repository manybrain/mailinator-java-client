package com.manybrain.mailinator.client.stats;

import com.manybrain.mailinator.client.JsonUtils;
import lombok.Data;
import org.json.simple.JSONObject;

@Data
public class PlanData {
    private Integer storageMb;
    private Integer numPrivateDomains;
    private Integer emailReadsPerDay;
    private Integer teamAccounts;

    public static PlanData fromJson(JSONObject json) {
        if (json == null) return null;
        PlanData p = new PlanData();
        p.storageMb = JsonUtils.getInteger(json, "storage_mb");
        p.numPrivateDomains = JsonUtils.getInteger(json, "num_private_domains");
        p.emailReadsPerDay = JsonUtils.getInteger(json, "email_reads_per_day");
        p.teamAccounts = JsonUtils.getInteger(json, "team_accounts");
        return p;
    }
}