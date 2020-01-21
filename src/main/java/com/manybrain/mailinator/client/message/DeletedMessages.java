package com.manybrain.mailinator.client.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeletedMessages {

  @JsonProperty("status")
  private String status;
  @JsonProperty("count")
  private Integer count;

}
