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
public class GetMessageTextRequest
        implements Request<MessageTextResponse>
{

    private static final String URL = BASE_URL + "/domains/{domain}/messages/{message_id}/text";

    private static final WebTarget WEB_TARGET = CLIENT.target(URL);

    @NonNull
    private final String domain;
    @NonNull
    private final String messageId;

    public MessageTextResponse execute(String apiToken)
    {
        String response = WEB_TARGET
                .resolveTemplate("domain", emptyIfNull(domain))
                .resolveTemplate("message_id", emptyIfNull(messageId))
                .request(MediaType.APPLICATION_JSON_TYPE)
                .header(AUTHORIZATION, apiToken)
                .get(String.class);
        return MessageTextResponse.fromJson(JsonUtils.parseObject(response));
    }
}
