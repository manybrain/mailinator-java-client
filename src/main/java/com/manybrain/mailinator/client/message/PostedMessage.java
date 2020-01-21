package com.manybrain.mailinator.client.message;

import static com.manybrain.mailinator.client.JerseyClient.OBJECT_MAPPER;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.manybrain.mailinator.client.rule.Rule;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostedMessage
{

    @JsonProperty("status")
    private String status;
    @JsonProperty("id")
    private String id;
    @JsonProperty("rules_fired")
    private List<Rule> rulesFired;

}