package com.manybrain.mailinator.client.stats;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MembersItem{

	@JsonProperty("role")
	private String role;

	@JsonProperty("_id")
	private String id;

	@JsonProperty("email")
	private String email;
}