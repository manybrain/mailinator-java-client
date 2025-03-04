package com.manybrain.mailinator.client.webhook;

import static com.manybrain.mailinator.client.JerseyClient.BASE_URL;
import static com.manybrain.mailinator.client.JerseyClient.CLIENT;
import static com.manybrain.mailinator.client.Utils.emptyIfNull;
import com.manybrain.mailinator.client.RequestWithoutApiToken;

import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PrivateInboxWebhookRequest implements RequestWithoutApiToken<PrivateWebhookResponse> {

  private static final String URL = BASE_URL + "/domains/private/webhook/{inbox}";

  private static final WebTarget WEB_TARGET = CLIENT.target(URL);

  @NonNull
  private final String webhookToken;
  @NonNull
  private final String inbox;
  @NonNull
  private final Webhook webhook;

  @Override
  public PrivateWebhookResponse execute() {
    WebTarget webTarget = WEB_TARGET.resolveTemplate("wh-token", emptyIfNull(webhookToken))
                                    .resolveTemplate("inbox", emptyIfNull(inbox));

    if (webhookToken != null)
    {
        webTarget = webTarget.queryParam("whtoken", webhookToken);
    }
                          
    return webTarget.request(MediaType.APPLICATION_JSON_TYPE)
        .post(Entity.json(webhook), PrivateWebhookResponse.class);
  }

}
