package com.manybrain.mailinator.client.message;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Part
{

    @JsonProperty("headers")
    private Map<String, Object> headers;
    @JsonProperty("body")
    private String body;

}