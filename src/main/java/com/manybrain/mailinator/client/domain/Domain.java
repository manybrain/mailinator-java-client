package com.manybrain.mailinator.client.domain;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.manybrain.mailinator.client.rule.Rule;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Domain {

  @JsonProperty("_id")
  private String id;
  @JsonProperty("description")
  private String description;
  @JsonProperty("enabled")
  private Boolean enabled;
  @JsonProperty("name")
  private String name;
  @JsonProperty("ownerid")
  private String ownerid;
  @JsonProperty("rules")
  private List<Rule> rules;

}
