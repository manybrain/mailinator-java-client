package com.manybrain.mailinator.client.stats;

import lombok.Data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Team{

	@JsonProperty("private_domains")
	private List<PrivateDomainsItem> privateDomains;

	@JsonProperty("sms_numbers")
	private List<SmsNumbersItem> smsNumbers;

	@JsonProperty("members")
	private List<MembersItem> members;

	@JsonProperty("plan_data")
	private PlanData planData;

	@JsonProperty("_id")
	private String id;

	@JsonProperty("plan")
	private String plan;

	@JsonProperty("team_name")
	private String teamName;

	@JsonProperty("token")
	private String token;

	@JsonProperty("status")
	private String status;
}