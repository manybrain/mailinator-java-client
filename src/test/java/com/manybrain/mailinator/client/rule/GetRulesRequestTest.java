package com.manybrain.mailinator.client.rule;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariables;

import com.manybrain.mailinator.client.TestUtils;
import com.manybrain.mailinator.client.domain.Domain;

import static com.manybrain.mailinator.client.TestEnv.ENV_API_TOKEN;
import static com.manybrain.mailinator.client.TestEnv.ENV_DOMAIN_RULES_LESS_THAN_LIMIT;
import static com.manybrain.mailinator.client.TestEnv.getMailinatorClient;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class GetRulesRequestTest {

	@Test
	@EnabledIfEnvironmentVariables({
			@EnabledIfEnvironmentVariable(named = ENV_API_TOKEN, matches = "[^\\s]+"),
			@EnabledIfEnvironmentVariable(named = ENV_DOMAIN_RULES_LESS_THAN_LIMIT, matches = "true")
	})
	void testGetRulesRequest() {
		Domain domain = TestUtils.getFirstAvailableDomain();

		Rules rules = getMailinatorClient().request(new GetRulesRequest(domain.getId()));
		assertNotNull(rules);
	}
}
