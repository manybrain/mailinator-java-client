package com.manybrain.mailinator.client.domain;

import static com.manybrain.mailinator.client.JerseyClient.CLIENT;
import static com.manybrain.mailinator.client.Utils.emptyIfNull;
import static javax.ws.rs.core.HttpHeaders.AUTHORIZATION;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import com.manybrain.mailinator.client.Request;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetDomainRequest implements Request<Domain> {

  private static final String URL = "https://api.mailinator.com/v2/domains/{domain_id}";

  private static final WebTarget WEB_TARGET = CLIENT.target(URL);

  @NonNull
  private final String domainId;

  @Override
  public Domain execute(String apiToken) {
    WebTarget webTarget = WEB_TARGET.resolveTemplate("domain_id", emptyIfNull(domainId));

    return webTarget.request(MediaType.APPLICATION_JSON_TYPE).header(AUTHORIZATION, apiToken)
        .get(Domain.class);
  }

}
