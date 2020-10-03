package com.manybrain.mailinator.client.rule;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariables;

import static com.manybrain.mailinator.client.TestEnv.ENV_API_TOKEN;
import static com.manybrain.mailinator.client.TestEnv.ENV_DOMAIN_RULES_LESS_THAN_LIMIT;
import static com.manybrain.mailinator.client.TestUtils.createNewRule;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CreateRuleRequestTest {

	@Test
	@EnabledIfEnvironmentVariables({
			@EnabledIfEnvironmentVariable(named = ENV_API_TOKEN, matches = "[^\\s]+"),
			@EnabledIfEnvironmentVariable(named = ENV_DOMAIN_RULES_LESS_THAN_LIMIT, matches = "true")
	})
	void testCreateRuleRequest() {
		Rule rule = createNewRule();
		assertNotNull(rule);
	}

}
