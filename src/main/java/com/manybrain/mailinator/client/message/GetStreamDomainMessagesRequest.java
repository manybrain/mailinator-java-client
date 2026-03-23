package com.manybrain.mailinator.client.message;

import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

import com.manybrain.mailinator.client.JsonUtils;
import com.manybrain.mailinator.client.Request;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import org.json.simple.JSONObject;

import static com.manybrain.mailinator.client.JerseyClient.BASE_URL;
import static com.manybrain.mailinator.client.JerseyClient.CLIENT;
import static com.manybrain.mailinator.client.Utils.emptyIfNull;
import static jakarta.ws.rs.core.HttpHeaders.AUTHORIZATION;

import java.util.Collections;

/**
 * Fetches the next message arriving in any inbox of a domain via the Mailinator stream endpoint.
 * <p>
 * The server uses HTTP long-polling and sends newline-delimited JSON. Ping frames
 * ({@code {"ping":...}}) are transparently skipped. The first real message is
 * returned as an {@link Inbox}.
 * <p>
 * URL: {@code GET /api/v2/domains/{domain}/stream}
 */
@RequiredArgsConstructor
public class GetStreamDomainMessagesRequest
        implements Request<Inbox>
{

    private static final String URL = BASE_URL + "/domains/{domain}/stream";

    private static final WebTarget WEB_TARGET = CLIENT.target(URL);

    @NonNull
    private final String domain;

    public Inbox execute(String apiToken)
    {
        String response = WEB_TARGET
                .resolveTemplate("domain", emptyIfNull(domain))
                .request(MediaType.APPLICATION_JSON_TYPE)
                .header(AUTHORIZATION, apiToken)
                .get(String.class);

        return parseStreamResponse(response, domain);
    }

    static Inbox parseStreamResponse(String response, String domain)
    {
        if (response == null) return null;
        for (String line : response.split("\\n"))
        {
            String trimmed = line.trim();
            if (trimmed.isEmpty()) continue;
            JSONObject json = JsonUtils.parseObject(trimmed);
            if (json == null) continue;
            if (json.containsKey("ping")) continue;

            // Already an inbox-shaped payload
            if (json.containsKey("msgs"))
            {
                return Inbox.fromJson(json);
            }

            // Single message payload — wrap it
            Message msg = Message.fromJson(json);
            Inbox inbox = new Inbox();
            inbox.setDomain(domain);
            inbox.setTo(msg.getTo());
            inbox.setMsgs(Collections.singletonList(msg));
            return inbox;
        }
        return null;
    }
}
