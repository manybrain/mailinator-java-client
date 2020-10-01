package com.manybrain.mailinator.client.rule;

import org.junit.jupiter.api.Test;

import com.manybrain.mailinator.client.domain.Domain;

import static com.manybrain.mailinator.client.TestEnv.getMailinatorClient;
import static com.manybrain.mailinator.client.TestUtils.createNewRule;
import static com.manybrain.mailinator.client.TestUtils.getFirstAvailableDomain;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class EnableRuleRequestTest {

	@Test
	void testEnableRuleRequest() {
		Domain domain = getFirstAvailableDomain();

		Rule rule = createNewRule();

		ResponseStatus responseStatus = getMailinatorClient().request(new EnableRuleRequest(domain.getId(), rule.getId()));
		assertNotNull(responseStatus);
	}

}
