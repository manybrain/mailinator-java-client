package com.manybrain.mailinator.client.message;

import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

import com.manybrain.mailinator.client.JsonUtils;
import com.manybrain.mailinator.client.Request;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import static com.manybrain.mailinator.client.JerseyClient.BASE_URL;
import static com.manybrain.mailinator.client.JerseyClient.CLIENT;
import static com.manybrain.mailinator.client.Utils.emptyIfNull;
import static jakarta.ws.rs.core.HttpHeaders.AUTHORIZATION;


@RequiredArgsConstructor
public class GetSmsInboxRequest
        implements Request<Inbox>
{

    private static final String URL = BASE_URL + "/domains/{domain}/inboxes/{phoneNumber}";

    private static final WebTarget WEB_TARGET = CLIENT.target(URL);

    @NonNull
    private final String domain;
    @NonNull
    private final String phoneNumber;

    public Inbox execute(String apiToken)
    {
        WebTarget webTarget = WEB_TARGET.resolveTemplate("domain", emptyIfNull(domain))
                                        .resolveTemplate("phoneNumber", emptyIfNull(phoneNumber));

        String response = webTarget.request(MediaType.APPLICATION_JSON_TYPE)
                        .header(AUTHORIZATION, apiToken)
                        .get(String.class);
        return Inbox.fromJson(JsonUtils.parseObject(response));
    }


}
