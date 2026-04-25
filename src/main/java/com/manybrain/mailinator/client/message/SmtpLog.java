package com.manybrain.mailinator.client.message;

import com.manybrain.mailinator.client.JsonUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.simple.JSONObject;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SmtpLog {
    private List<EmailLogEntry> logEntries;

    public static SmtpLog fromJson(JSONObject json) {
        if (json == null) return null;
        SmtpLog s = new SmtpLog();
        s.logEntries = JsonUtils.getList(json, "log", EmailLogEntry::fromJson);
        return s;
    }
}