package com.manybrain.mailinator.client.authenticator;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InstantTOTP2FACodeResponse {

  @JsonProperty("time_step")
  private Integer TimeStep;
  @JsonProperty("futurecodes")
  private List<String> FutureCodes;
  @JsonProperty("next_reset_secs")
  private Integer NextResetSeconds;
  @JsonProperty("passcode")
  private String Passcode;

}
