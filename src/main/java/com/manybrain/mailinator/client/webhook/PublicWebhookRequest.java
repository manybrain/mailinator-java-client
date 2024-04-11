package com.manybrain.mailinator.client.webhook;

import static com.manybrain.mailinator.client.JerseyClient.BASE_URL;
import static com.manybrain.mailinator.client.JerseyClient.CLIENT;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import com.manybrain.mailinator.client.RequestWithoutApiToken;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PublicWebhookRequest implements RequestWithoutApiToken<PublicWebhookResponse> {

  private static final String URL = BASE_URL + "/domains/public/webhook";

  private static final WebTarget WEB_TARGET = CLIENT.target(URL);

  @NonNull
  private final Webhook webhook;

  @Override
  public PublicWebhookResponse execute() {
    return WEB_TARGET.request(MediaType.APPLICATION_JSON_TYPE)
        .post(Entity.json(webhook), PublicWebhookResponse.class);
  }

}
