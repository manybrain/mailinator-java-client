package com.manybrain.mailinator.client.webhook;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariables;

import static com.manybrain.mailinator.client.TestEnv.ENV_WEBHOOKTOKEN_PRIVATEDOMAIN;
import static com.manybrain.mailinator.client.TestEnv.getMailinatorClientWithoutApiToken;
import static com.manybrain.mailinator.client.TestUtils.getWebhookToAdd;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PrivateWebhookRequestTest {

	@Test
	@EnabledIfEnvironmentVariables({
		@EnabledIfEnvironmentVariable(named = ENV_WEBHOOKTOKEN_PRIVATEDOMAIN, matches = "[^\\s]+")
	})
	void testPrivateWebhookRequest() {
		Webhook webhook = getWebhookToAdd();

		PrivateWebhookResponse response = getMailinatorClientWithoutApiToken().request(new PrivateWebhookRequest(ENV_WEBHOOKTOKEN_PRIVATEDOMAIN, webhook));
		assertNotNull(response);
	}

}
