package com.manybrain.mailinator.client.webhook;

import static com.manybrain.mailinator.client.JerseyClient.BASE_URL;
import static com.manybrain.mailinator.client.JerseyClient.CLIENT;
import static com.manybrain.mailinator.client.Utils.emptyIfNull;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import com.manybrain.mailinator.client.RequestWithoutApiToken;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PrivateWebhookRequest implements RequestWithoutApiToken<PrivateWebhookResponse> {

  private static final String URL = BASE_URL + "/domains/{wh-token}/webhook";

  private static final WebTarget WEB_TARGET = CLIENT.target(URL);

  @NonNull
  private final String webhookToken;
  @NonNull
  private final Webhook webhook;

  @Override
  public PrivateWebhookResponse execute() {
    WebTarget webTarget = WEB_TARGET.resolveTemplate("wh-token", emptyIfNull(webhookToken));

    return webTarget.request(MediaType.APPLICATION_JSON_TYPE)
        .post(Entity.json(webhook), PrivateWebhookResponse.class);
  }

}
