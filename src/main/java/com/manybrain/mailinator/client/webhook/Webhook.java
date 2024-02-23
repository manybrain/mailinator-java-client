package com.manybrain.mailinator.client.webhook;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Webhook {

  @JsonProperty("from")
  private String from;
  @JsonProperty("subject")
  public String subject;
  @JsonProperty("text")
  public String text;
  @JsonProperty("to")
  public String to;

}
