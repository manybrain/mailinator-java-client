package com.manybrain.mailinator.client.webhook;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariables;

import com.manybrain.mailinator.client.ResponseStatus;

import static com.manybrain.mailinator.client.TestEnv.getMailinatorClientWithoutApiToken;
import static com.manybrain.mailinator.client.TestUtils.getWebhookToAdd;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PublicWebhookRequestTest {

	@Test
	@EnabledIfEnvironmentVariables({
	})
	void testPublicWebhookRequest() {
		Webhook webhook = getWebhookToAdd();

		PublicWebhookResponse response = getMailinatorClientWithoutApiToken().request(new PublicWebhookRequest(webhook));
		assertNotNull(response);
	}

}
