package com.manybrain.mailinator.client.webhook;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariables;

import static com.manybrain.mailinator.client.TestEnv.ENV_WEBHOOK_CUSTOMSERVICE;
import static com.manybrain.mailinator.client.TestEnv.getMailinatorClientWithoutApiToken;
import static com.manybrain.mailinator.client.TestUtils.getWebhookToAdd;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PublicCustomServiceWebhookRequestTest {

	@Test
	@EnabledIfEnvironmentVariables({
		@EnabledIfEnvironmentVariable(named = ENV_WEBHOOK_CUSTOMSERVICE, matches = "[^\\s]+")
	})
	void testPublicCustomServiceWebhookRequest() {
		Webhook webhook = getWebhookToAdd();

		String response = getMailinatorClientWithoutApiToken().request(new PublicCustomServiceWebhookRequest(ENV_WEBHOOK_CUSTOMSERVICE, webhook));
		// assertNotNull(responseStatus);
	}

}
