package com.manybrain.mailinator.client.rule;

import org.junit.jupiter.api.Test;

import static com.manybrain.mailinator.client.TestUtils.createNewRule;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CreateRuleRequestTest {

	@Test
	void testCreateRuleRequest() {
		Rule rule = createNewRule();
		assertNotNull(rule);
	}

}
