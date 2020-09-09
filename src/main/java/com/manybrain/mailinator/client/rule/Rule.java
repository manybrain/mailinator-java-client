package com.manybrain.mailinator.client.rule;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Rule
{

    @JsonProperty("_id")
    public String id;
    @JsonProperty("description")
    public String description;
    @JsonProperty("enabled")
    public Boolean enabled;
    @JsonProperty("match")
    public MatchType match;
    @JsonProperty("name")
    public String name;
    @JsonProperty("conditions")
    public List<Condition> conditions;
    @JsonProperty("actions")
    public List<Action> actions;

}