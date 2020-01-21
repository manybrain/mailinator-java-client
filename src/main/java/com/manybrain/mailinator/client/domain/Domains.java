package com.manybrain.mailinator.client.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Domains
{

    @JsonProperty("domains")
    private List<Domain> domains;
}