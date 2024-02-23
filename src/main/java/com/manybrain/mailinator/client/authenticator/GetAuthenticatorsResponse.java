package com.manybrain.mailinator.client.authenticator;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetAuthenticatorsResponse {

  @JsonProperty("passcodes")
  private List<Authenticator> Passcodes;

}
