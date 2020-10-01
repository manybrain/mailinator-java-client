package com.manybrain.mailinator.client.stats;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StatsItem{

	@JsonProperty("date")
	private String date;

	@JsonProperty("retrieved")
	private Retrieved retrieved;

	@JsonProperty("sent")
	private Sent sent;
}