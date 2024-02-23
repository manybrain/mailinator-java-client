package com.manybrain.mailinator.client.message;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.manybrain.mailinator.client.Request;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import static com.manybrain.mailinator.client.JerseyClient.BASE_URL;
import static com.manybrain.mailinator.client.JerseyClient.CLIENT;
import static com.manybrain.mailinator.client.Utils.emptyIfNull;
import static javax.ws.rs.core.HttpHeaders.AUTHORIZATION;

@RequiredArgsConstructor
public class DeleteInboxMessagesRequest
        implements Request<DeletedMessages>
{

    private static final String URL = BASE_URL + "/domains/{domain}/inboxes/{inbox}";

    private static final WebTarget WEB_TARGET = CLIENT.target(URL);

    @NonNull
    private final String domain;
    @NonNull
    private final String inbox;


    public DeletedMessages execute(String apiToken)
    {
        WebTarget webTarget = WEB_TARGET.resolveTemplate("domain", emptyIfNull(domain))
                                        .resolveTemplate("inbox", emptyIfNull(inbox));

        return webTarget.request(MediaType.APPLICATION_JSON_TYPE)
                        .header(AUTHORIZATION, apiToken)
                        .delete(DeletedMessages.class);
    }


}
