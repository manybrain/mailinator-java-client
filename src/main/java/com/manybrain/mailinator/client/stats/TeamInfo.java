package com.manybrain.mailinator.client.stats;

import lombok.Data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamInfo{

	@JsonProperty("server_time")
	private String serverTime;

	@JsonProperty("private_domains")
	private List<String> domains;
}