package com.manybrain.mailinator.client.rule;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariables;

import com.manybrain.mailinator.client.domain.Domain;

import static com.manybrain.mailinator.client.TestEnv.ENV_API_TOKEN;
import static com.manybrain.mailinator.client.TestEnv.ENV_DOMAIN_RULES_LESS_THAN_LIMIT;
import static com.manybrain.mailinator.client.TestEnv.getMailinatorClient;
import static com.manybrain.mailinator.client.TestUtils.createNewRule;
import static com.manybrain.mailinator.client.TestUtils.getFirstAvailableDomain;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class GetRuleRequestTest {

	@Test
	@EnabledIfEnvironmentVariables({
			@EnabledIfEnvironmentVariable(named = ENV_API_TOKEN, matches = "[^\\s]+"),
			@EnabledIfEnvironmentVariable(named = ENV_DOMAIN_RULES_LESS_THAN_LIMIT, matches = "true")
	})
	void testGetRuleRequest() {
		Domain domain = getFirstAvailableDomain();

		Rule rule = createNewRule();

		final Rule ruleResponse = getMailinatorClient().request(new GetRuleRequest(domain.getName(), rule.getId()));
		assertNotNull(ruleResponse);
	}
}
