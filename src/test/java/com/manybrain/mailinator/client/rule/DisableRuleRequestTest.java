package com.manybrain.mailinator.client.rule;

import org.junit.jupiter.api.Test;

import com.manybrain.mailinator.client.domain.Domain;

import static com.manybrain.mailinator.client.TestEnv.getMailinatorClient;
import static com.manybrain.mailinator.client.TestUtils.createNewRule;
import static com.manybrain.mailinator.client.TestUtils.getFirstAvailableDomain;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DisableRuleRequestTest {

	@Test
	void testDisableRuleRequest() {
		Domain domain = getFirstAvailableDomain();

		Rule rule = createNewRule();

		ResponseStatus responseStatus = getMailinatorClient().request(new DisableRuleRequest(domain.getId(), rule.getId()));
		assertNotNull(responseStatus);
	}
}
