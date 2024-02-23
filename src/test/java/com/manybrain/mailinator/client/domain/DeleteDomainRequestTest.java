package com.manybrain.mailinator.client.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariables;

import com.manybrain.mailinator.client.ResponseStatus;

import static com.manybrain.mailinator.client.TestEnv.ENV_API_TOKEN;
import static com.manybrain.mailinator.client.TestEnv.getMailinatorClient;
import static com.manybrain.mailinator.client.TestUtils.createNewDomain;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DeleteDomainRequestTest {

	@Test
	@EnabledIfEnvironmentVariables({
			@EnabledIfEnvironmentVariable(named = ENV_API_TOKEN, matches = "[^\\s]+")
	})
	void testDeleteRuleRequest() {
		String domainNameToCreate = "testjava.testinator.com";
		ResponseStatus responseStatus = createNewDomain(domainNameToCreate);
		assertNotNull(responseStatus);

		responseStatus = getMailinatorClient().request(new DeleteDomainRequest(domainNameToCreate));
		assertNotNull(responseStatus);
	}
}
