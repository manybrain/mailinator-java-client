package com.manybrain.mailinator.client.message;

import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

import com.manybrain.mailinator.client.Request;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import static com.manybrain.mailinator.client.JerseyClient.BASE_URL;
import static com.manybrain.mailinator.client.JerseyClient.CLIENT;
import static com.manybrain.mailinator.client.Utils.emptyIfNull;
import static jakarta.ws.rs.core.HttpHeaders.AUTHORIZATION;

/**
 * Fetches the next message arriving in a specific inbox of a domain via the Mailinator stream endpoint.
 * <p>
 * The server uses HTTP long-polling and sends newline-delimited JSON. Ping frames
 * ({@code {"ping":...}}) are transparently skipped. The first real message is
 * returned as an {@link Inbox}.
 * <p>
 * URL: {@code GET /api/v2/domains/{domain}/stream/{inbox}}
 */
@RequiredArgsConstructor
public class GetStreamInboxMessagesRequest
        implements Request<Inbox>
{

    private static final String URL = BASE_URL + "/domains/{domain}/stream/{inbox}";

    private static final WebTarget WEB_TARGET = CLIENT.target(URL);

    @NonNull
    private final String domain;
    @NonNull
    private final String inbox;

    public Inbox execute(String apiToken)
    {
        String response = WEB_TARGET
                .resolveTemplate("domain", emptyIfNull(domain))
                .resolveTemplate("inbox", emptyIfNull(inbox))
                .request(MediaType.APPLICATION_JSON_TYPE)
                .header(AUTHORIZATION, apiToken)
                .get(String.class);

        return GetStreamDomainMessagesRequest.parseStreamResponse(response, domain);
    }
}
