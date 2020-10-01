package com.manybrain.mailinator.client.rule;

import org.junit.jupiter.api.Test;

import com.manybrain.mailinator.client.TestUtils;
import com.manybrain.mailinator.client.domain.Domain;

import static com.manybrain.mailinator.client.TestEnv.getMailinatorClient;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class GetRulesRequestTest {

	@Test
	void testGetRulesRequest() {
		Domain domain = TestUtils.getFirstAvailableDomain();

		Rules rules = getMailinatorClient().request(new GetRulesRequest(domain.getId()));
		assertNotNull(rules);
	}
}
