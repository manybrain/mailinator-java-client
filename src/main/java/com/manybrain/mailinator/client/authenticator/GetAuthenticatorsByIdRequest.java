package com.manybrain.mailinator.client.authenticator;

import static com.manybrain.mailinator.client.JerseyClient.BASE_URL;
import static com.manybrain.mailinator.client.JerseyClient.CLIENT;
import static com.manybrain.mailinator.client.Utils.emptyIfNull;
import static javax.ws.rs.core.HttpHeaders.AUTHORIZATION;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import com.manybrain.mailinator.client.Request;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetAuthenticatorsByIdRequest implements Request<Authenticator> {

  private static final String URL = BASE_URL + "/authenticators/{auth_id}";

  private static final WebTarget WEB_TARGET = CLIENT.target(URL);

  @NonNull
  private final String Id;

  @Override
  public Authenticator execute(String apiToken) {
    WebTarget webTarget = WEB_TARGET.resolveTemplate("auth_id", emptyIfNull(Id));

    return webTarget.request(MediaType.APPLICATION_JSON_TYPE).header(AUTHORIZATION, apiToken)
        .get(Authenticator.class);
  }

}
