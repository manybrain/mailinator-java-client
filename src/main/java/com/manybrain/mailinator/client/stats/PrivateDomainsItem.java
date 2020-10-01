package com.manybrain.mailinator.client.stats;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PrivateDomainsItem{

	@JsonProperty("pd")
	private String pd;

	@JsonProperty("enabled")
	private Boolean enabled;
}