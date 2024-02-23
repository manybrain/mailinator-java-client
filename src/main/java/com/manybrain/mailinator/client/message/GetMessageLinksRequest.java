package com.manybrain.mailinator.client.message;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.manybrain.mailinator.client.Request;

import static com.manybrain.mailinator.client.JerseyClient.BASE_URL;
import static com.manybrain.mailinator.client.JerseyClient.CLIENT;
import static com.manybrain.mailinator.client.Utils.emptyIfNull;
import static javax.ws.rs.core.HttpHeaders.AUTHORIZATION;

@RequiredArgsConstructor
public class GetMessageLinksRequest
        implements Request<Links>
{

    private static final String URL = BASE_URL + "/domains/{domain}/messages/{message_id}/links";

    private static final WebTarget WEB_TARGET = CLIENT.target(URL);

    @NonNull
    private final String domain;
    @NonNull
    private final String messageId;

    public Links execute(String apiToken)
    {
        WebTarget webTarget = WEB_TARGET.resolveTemplate("domain", emptyIfNull(domain))
                                        .resolveTemplate("message_id", emptyIfNull(messageId));

        return webTarget.request(MediaType.APPLICATION_JSON_TYPE)
                        .header(AUTHORIZATION, apiToken)
                        .get(Links.class);
    }


}
