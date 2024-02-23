package com.manybrain.mailinator.client.webhook;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariables;

import static com.manybrain.mailinator.client.TestEnv.ENV_WEBHOOKTOKEN_PRIVATEDOMAIN;
import static com.manybrain.mailinator.client.TestEnv.ENV_WEBHOOK_INBOX;
import static com.manybrain.mailinator.client.TestEnv.getMailinatorClientWithoutApiToken;
import static com.manybrain.mailinator.client.TestUtils.getWebhookToAdd;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PrivateInboxWebhookRequestTest {

	@Test
	@EnabledIfEnvironmentVariables({
		@EnabledIfEnvironmentVariable(named = ENV_WEBHOOKTOKEN_PRIVATEDOMAIN, matches = "[^\\s]+"),
		@EnabledIfEnvironmentVariable(named = ENV_WEBHOOK_INBOX, matches = "[^\\s]+")
	})
	void testPrivateInboxWebhookRequest() {
		Webhook webhook = getWebhookToAdd();

		PrivateWebhookResponse response = getMailinatorClientWithoutApiToken().request(new PrivateInboxWebhookRequest(ENV_WEBHOOKTOKEN_PRIVATEDOMAIN, ENV_WEBHOOK_INBOX, webhook));
		assertNotNull(response);
	}

}
