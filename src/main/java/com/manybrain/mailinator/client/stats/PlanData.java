package com.manybrain.mailinator.client.stats;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlanData{

	@JsonProperty("storage_mb")
	private Integer storageMb;

	@JsonProperty("num_private_domains")
	private Integer numPrivateDomains;

	@JsonProperty("email_reads_per_day")
	private Integer emailReadsPerDay;

	@JsonProperty("team_accounts")
	private Integer teamAccounts;
}