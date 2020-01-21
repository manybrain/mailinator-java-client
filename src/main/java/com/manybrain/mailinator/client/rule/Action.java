package com.manybrain.mailinator.client.rule;

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
public class Action
{

    @JsonProperty("action")
    public ActionType action;
    @JsonProperty("action_data")
    public ActionData actionData;
    @JsonProperty("destination")
    public String destination;


}