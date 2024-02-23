package com.manybrain.mailinator.client.authenticator;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Authenticator {

  @JsonProperty("id")
  private String Id;
  @JsonProperty("time_step")
  public Integer TimeStep;
  @JsonProperty("futurecodes")
  public List<String> FutureCodes;
  @JsonProperty("next_reset_secs")
  public Integer NextResetSeconds;
  @JsonProperty("passcode")
  public String Passcode;

}
