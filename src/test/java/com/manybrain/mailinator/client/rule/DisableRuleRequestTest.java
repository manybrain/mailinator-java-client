package com.manybrain.mailinator.client.rule;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariables;

import com.manybrain.mailinator.client.ResponseStatus;
import com.manybrain.mailinator.client.domain.Domain;

import static com.manybrain.mailinator.client.TestEnv.ENV_API_TOKEN;
import static com.manybrain.mailinator.client.TestEnv.ENV_DOMAIN_RULES_LESS_THAN_LIMIT;
import static com.manybrain.mailinator.client.TestEnv.getMailinatorClient;
import static com.manybrain.mailinator.client.TestUtils.createNewRule;
import static com.manybrain.mailinator.client.TestUtils.getFirstAvailableDomain;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DisableRuleRequestTest {

	@Test
	@EnabledIfEnvironmentVariables({
			@EnabledIfEnvironmentVariable(named = ENV_API_TOKEN, matches = "[^\\s]+"),
			@EnabledIfEnvironmentVariable(named = ENV_DOMAIN_RULES_LESS_THAN_LIMIT, matches = "true")
	})
	void testDisableRuleRequest() {
		Domain domain = getFirstAvailableDomain();

		Rule rule = createNewRule();

		ResponseStatus responseStatus = getMailinatorClient().request(new DisableRuleRequest(domain.getName(), rule.getId()));
		assertNotNull(responseStatus);
	}
}
