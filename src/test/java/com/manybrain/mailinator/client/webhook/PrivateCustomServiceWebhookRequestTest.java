package com.manybrain.mailinator.client.webhook;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariables;

import static com.manybrain.mailinator.client.TestEnv.ENV_WEBHOOKTOKEN_CUSTOMSERVICE;
import static com.manybrain.mailinator.client.TestEnv.ENV_WEBHOOK_CUSTOMSERVICE;
import static com.manybrain.mailinator.client.TestEnv.getMailinatorClientWithoutApiToken;
import static com.manybrain.mailinator.client.TestUtils.getWebhookToAdd;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PrivateCustomServiceWebhookRequestTest {

	@Test
	@EnabledIfEnvironmentVariables({
		@EnabledIfEnvironmentVariable(named = ENV_WEBHOOKTOKEN_CUSTOMSERVICE, matches = "[^\\s]+"),
		@EnabledIfEnvironmentVariable(named = ENV_WEBHOOK_CUSTOMSERVICE, matches = "[^\\s]+")
	})
	void testPrivateCustomServiceWebhookRequest() {
		Webhook webhook = getWebhookToAdd();

		String response = getMailinatorClientWithoutApiToken().request(new PrivateCustomServiceWebhookRequest(ENV_WEBHOOKTOKEN_CUSTOMSERVICE, ENV_WEBHOOK_CUSTOMSERVICE, webhook));
		// assertNotNull(responseStatus);
	}

}
