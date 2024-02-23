package com.manybrain.mailinator.client.message;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmailLogEntry {

	@JsonProperty("log")
	private String log;
	@JsonProperty("time")
	private String time;
	@JsonProperty("event")
	private String event;

}