package com.manybrain.mailinator.client.message;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;


import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

import com.manybrain.mailinator.client.Request;

import static com.manybrain.mailinator.client.JerseyClient.BASE_URL;
import static com.manybrain.mailinator.client.JerseyClient.CLIENT;
import static com.manybrain.mailinator.client.Utils.emptyIfNull;
import static jakarta.ws.rs.core.HttpHeaders.AUTHORIZATION;

@RequiredArgsConstructor
public class GetLatestInboxMessagesRequest
        implements Request<Inbox>
{

    private static final String URL = BASE_URL + "/domains/{domain}/inboxes/{inbox}/messages/*";

    private static final WebTarget WEB_TARGET = CLIENT.target(URL);

    @NonNull
    private final String domain;
    @NonNull
    private final String inbox;

    public Inbox execute(String apiToken)
    {
        WebTarget webTarget = WEB_TARGET.resolveTemplate("domain", emptyIfNull(domain))
                                        .resolveTemplate("inbox", emptyIfNull(inbox));

        return webTarget.request(MediaType.APPLICATION_JSON_TYPE)
                        .header(AUTHORIZATION, apiToken)
                        .get(Inbox.class);
    }


}
