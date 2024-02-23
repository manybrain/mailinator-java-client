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
public class PublicCustomServiceWebhookRequest implements RequestWithoutApiToken<String> {

  private static final String URL = BASE_URL + "/domains/public/{customService}";

  private static final WebTarget WEB_TARGET = CLIENT.target(URL);

  @NonNull
  private final String customService;
  @NonNull
  private final Webhook webhook;

  @Override
  public String execute() {
    WebTarget webTarget = WEB_TARGET.resolveTemplate("customService", emptyIfNull(customService));

    return webTarget.request(MediaType.APPLICATION_JSON_TYPE)
        .post(Entity.json(webhook), String.class);
  }

}
