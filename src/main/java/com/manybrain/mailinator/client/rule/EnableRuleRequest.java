package com.manybrain.mailinator.client.rule;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.manybrain.mailinator.client.Request;
import com.manybrain.mailinator.client.ResponseStatus;

import static com.manybrain.mailinator.client.JerseyClient.BASE_URL;
import static com.manybrain.mailinator.client.JerseyClient.CLIENT;
import static com.manybrain.mailinator.client.Utils.emptyIfNull;
import static javax.ws.rs.core.HttpHeaders.AUTHORIZATION;

@RequiredArgsConstructor
public class EnableRuleRequest implements Request<ResponseStatus> {

	private static final String URL = BASE_URL + "/domains/{domain_id}/rules/{rule_id}/enable";

	private static final WebTarget WEB_TARGET = CLIENT.target(URL);

	@NonNull
	private final String streamId;
	@NonNull
	private final String ruleId;

	public ResponseStatus execute(String apiToken) {
		WebTarget webTarget = WEB_TARGET.resolveTemplate("domain_id", emptyIfNull(streamId))
										.resolveTemplate("rule_id", emptyIfNull(ruleId));

		return webTarget.request(MediaType.APPLICATION_JSON_TYPE)
						.header(AUTHORIZATION, apiToken)
						.put(Entity.json("{}"), ResponseStatus.class);
	}

}
