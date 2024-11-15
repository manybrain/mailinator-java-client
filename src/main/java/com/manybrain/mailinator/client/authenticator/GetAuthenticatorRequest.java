package com.manybrain.mailinator.client.authenticator;

import static com.manybrain.mailinator.client.JerseyClient.BASE_URL;
import static com.manybrain.mailinator.client.JerseyClient.CLIENT;
import static jakarta.ws.rs.core.HttpHeaders.AUTHORIZATION;

import com.manybrain.mailinator.client.Request;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetAuthenticatorRequest implements Request<GetAuthenticatorsResponse> {

  private static final String URL = BASE_URL + "/authenticators";

  private static final WebTarget WEB_TARGET = CLIENT.target(URL);

  @Override
  public GetAuthenticatorsResponse execute(String apiToken) {
    return WEB_TARGET.request(MediaType.APPLICATION_JSON_TYPE).header(AUTHORIZATION, apiToken)
        .get(GetAuthenticatorsResponse.class);
  }

}
