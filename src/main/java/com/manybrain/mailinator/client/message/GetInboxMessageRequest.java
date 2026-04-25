package com.manybrain.mailinator.client.message;

import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

import com.manybrain.mailinator.client.JsonUtils;
import com.manybrain.mailinator.client.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import static com.manybrain.mailinator.client.JerseyClient.BASE_URL;
import static com.manybrain.mailinator.client.JerseyClient.CLIENT;
import static com.manybrain.mailinator.client.Utils.emptyIfNull;
import static jakarta.ws.rs.core.HttpHeaders.AUTHORIZATION;

@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class GetInboxMessageRequest
        implements Request<Message>
{

    private static final String URL = BASE_URL + "/domains/{domain}/inboxes/{inbox}/messages/{message_id}";

    private static final WebTarget WEB_TARGET = CLIENT.target(URL);

    @NonNull
    private final String domain;
    @NonNull
    private final String inbox;
    @NonNull
    private final String messageId;

    private String delete;

    public Message execute(String apiToken)
    {
        WebTarget webTarget = WEB_TARGET.resolveTemplate("domain", emptyIfNull(domain))
                                        .resolveTemplate("inbox", emptyIfNull(inbox))
                                        .resolveTemplate("message_id", emptyIfNull(messageId));

        if (delete != null)
        {
            webTarget = webTarget.queryParam("delete", delete);
        }

        String response = webTarget.request(MediaType.APPLICATION_JSON_TYPE)
                        .header(AUTHORIZATION, apiToken)
                        .get(String.class);
        return Message.fromJson(JsonUtils.parseObject(response));
    }


}
