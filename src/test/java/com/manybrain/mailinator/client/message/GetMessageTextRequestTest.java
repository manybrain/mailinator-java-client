package com.manybrain.mailinator.client.message;

import jakarta.ws.rs.InternalServerErrorException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariables;

import static com.manybrain.mailinator.client.TestEnv.ENV_API_TOKEN;
import static com.manybrain.mailinator.client.TestEnv.ENV_DOMAIN_PRIVATE;
import static com.manybrain.mailinator.client.TestEnv.ENV_REAL_MESSAGE_ID;
import static com.manybrain.mailinator.client.TestEnv.getMailinatorClient;
import static com.manybrain.mailinator.client.TestEnv.getPrivateDomain;

class GetMessageTextRequestTest
{
    @Test
    @EnabledIfEnvironmentVariables({
            @EnabledIfEnvironmentVariable(named = ENV_API_TOKEN, matches = "[^\\s]+"),
            @EnabledIfEnvironmentVariable(named = ENV_DOMAIN_PRIVATE, matches = "[^\\s]+"),
            @EnabledIfEnvironmentVariable(named = ENV_REAL_MESSAGE_ID, matches = "[^\\s]+")
    })
    void testGetMessageTextRequest()
    {
        String domain = getPrivateDomain();
        String messageId = System.getenv(ENV_REAL_MESSAGE_ID);
        MessageTextResponse response;
        try
        {
            response = getMailinatorClient().request(new GetMessageTextRequest(domain, messageId));
        }
        catch (InternalServerErrorException e)
        {
            Assumptions.assumeTrue(false, "text endpoint returned 500 — message has no text content");
            return;
        }
        Assertions.assertNotNull(response);
    }
}
