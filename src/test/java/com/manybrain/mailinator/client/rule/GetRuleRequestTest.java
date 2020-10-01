package com.manybrain.mailinator.client.rule;

import org.junit.jupiter.api.Test;

import com.manybrain.mailinator.client.domain.Domain;

import static com.manybrain.mailinator.client.TestEnv.getMailinatorClient;
import static com.manybrain.mailinator.client.TestUtils.createNewRule;
import static com.manybrain.mailinator.client.TestUtils.getFirstAvailableDomain;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class GetRuleRequestTest {

	@Test
	void testGetRuleRequest() {
		Domain domain = getFirstAvailableDomain();

		Rule rule = createNewRule();

		final Rule ruleResponse = getMailinatorClient().request(new GetRuleRequest(domain.getId(), rule.getId()));
		assertNotNull(ruleResponse);
	}
}
