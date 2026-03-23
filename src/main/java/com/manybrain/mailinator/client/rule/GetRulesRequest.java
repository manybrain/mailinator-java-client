package com.manybrain.mailinator.client.rule;

import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


import com.manybrain.mailinator.client.JsonUtils;
import com.manybrain.mailinator.client.Request;

import static com.manybrain.mailinator.client.JerseyClient.BASE_URL;
import static com.manybrain.mailinator.client.JerseyClient.CLIENT;
import static com.manybrain.mailinator.client.Utils.emptyIfNull;
import static jakarta.ws.rs.core.HttpHeaders.AUTHORIZATION;

/**
 * @deprecated Rules management endpoints have been deprecated and will be removed in a future release.
 */
@Deprecated
@RequiredArgsConstructor
public class GetRulesRequest implements Request<Rules> {

	private static final String URL = BASE_URL + "/domains/{domain_id}/rules/";

	private static final WebTarget WEB_TARGET = CLIENT.target(URL);

	@NonNull
	private final String domainId;

	public Rules execute(String apiToken) {
		WebTarget webTarget = WEB_TARGET.resolveTemplate("domain_id", emptyIfNull(domainId));

String response = webTarget.request(MediaType.APPLICATION_JSON_TYPE)
								.header(AUTHORIZATION, apiToken)
								.get(String.class);
		return Rules.fromJson(JsonUtils.parseObject(response));
	}

}
