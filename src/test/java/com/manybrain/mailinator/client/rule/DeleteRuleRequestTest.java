package com.manybrain.mailinator.client.rule;

import org.junit.jupiter.api.Test;

import com.manybrain.mailinator.client.domain.Domain;

import static com.manybrain.mailinator.client.TestEnv.getMailinatorClient;
import static com.manybrain.mailinator.client.TestUtils.createNewRule;
import static com.manybrain.mailinator.client.TestUtils.getFirstAvailableDomain;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DeleteRuleRequestTest {

	@Test
	void testDeleteRuleRequest() {
		Domain domain = getFirstAvailableDomain();

		Rule rule = createNewRule();

		ResponseStatus responseStatus = getMailinatorClient().request(new DeleteRuleRequest(domain.getId(), rule.getId()));
		assertNotNull(responseStatus);
	}
}
