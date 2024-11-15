package com.manybrain.mailinator.client.domain;

import static com.manybrain.mailinator.client.JerseyClient.BASE_URL;
import static com.manybrain.mailinator.client.JerseyClient.CLIENT;
import static com.manybrain.mailinator.client.Utils.emptyIfNull;
import static jakarta.ws.rs.core.HttpHeaders.AUTHORIZATION;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import com.manybrain.mailinator.client.Request;
import com.manybrain.mailinator.client.ResponseStatus;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteDomainRequest implements Request<ResponseStatus> {

  private static final String URL = BASE_URL + "/domains/{domain_id}";

  private static final WebTarget WEB_TARGET = CLIENT.target(URL);

  @NonNull
  private final String domainId;

  @Override
  public ResponseStatus execute(String apiToken) {
    WebTarget webTarget = WEB_TARGET.resolveTemplate("domain_id", emptyIfNull(domainId));

    return webTarget.request(MediaType.APPLICATION_JSON_TYPE).header(AUTHORIZATION, apiToken)
        .delete(ResponseStatus.class);
  }

}
