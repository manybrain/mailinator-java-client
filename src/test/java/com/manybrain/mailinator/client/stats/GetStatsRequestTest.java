package com.manybrain.mailinator.client.stats;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariables;

import static com.manybrain.mailinator.client.TestEnv.ENV_API_TOKEN;
import static com.manybrain.mailinator.client.TestEnv.getMailinatorClient;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class GetStatsRequestTest {

	@Test
	@EnabledIfEnvironmentVariables({
			@EnabledIfEnvironmentVariable(named = ENV_API_TOKEN, matches = "[^\\s]+")
	})
	void testGetStatsRequest()
	{
		Stats stats = getMailinatorClient().request(new GetStatsRequest());
		assertNotNull(stats);
	}
}
