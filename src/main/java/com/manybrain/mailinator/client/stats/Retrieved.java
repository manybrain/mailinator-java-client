package com.manybrain.mailinator.client.stats;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Retrieved{

	@JsonProperty("web_public")
	private Integer webPublic;

	@JsonProperty("api_error")
	private Integer apiError;

	@JsonProperty("web_private")
	private Integer webPrivate;

	@JsonProperty("api_email")
	private Integer apiEmail;
}