package com.manybrain.mailinator.client.rule;

import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import jakarta.ws.rs.client.Entity;
import com.manybrain.mailinator.client.Request;
import com.manybrain.mailinator.client.ResponseStatus;

import static com.manybrain.mailinator.client.JerseyClient.BASE_URL;
import static com.manybrain.mailinator.client.JerseyClient.CLIENT;
import static com.manybrain.mailinator.client.Utils.emptyIfNull;
import static jakarta.ws.rs.core.HttpHeaders.AUTHORIZATION;

@RequiredArgsConstructor
public class DisableRuleRequest implements Request<ResponseStatus> {

	private static final String URL = BASE_URL + "/domains/{domain_id}/rules/{rule_id}/disable";

	private static final WebTarget WEB_TARGET = CLIENT.target(URL);

	@NonNull
	private final String domainId;
	@NonNull
	private final String ruleId;

	public ResponseStatus execute(String apiToken) {
		WebTarget webTarget = WEB_TARGET.resolveTemplate("domain_id", emptyIfNull(domainId))
										.resolveTemplate("rule_id", emptyIfNull(ruleId));

		return webTarget.request(MediaType.APPLICATION_JSON_TYPE)
						.header(AUTHORIZATION, apiToken)
						.put(Entity.json("{}"), ResponseStatus.class);
	}

}
