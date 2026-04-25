package com.manybrain.mailinator.client.message;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariables;

import static com.manybrain.mailinator.client.TestEnv.ENV_API_TOKEN;
import static com.manybrain.mailinator.client.TestEnv.ENV_DOMAIN_PRIVATE;
import static com.manybrain.mailinator.client.TestEnv.ENV_ENABLE_STREAM;
import static com.manybrain.mailinator.client.TestEnv.ENV_INBOX_TEST;
import static com.manybrain.mailinator.client.TestEnv.getMailinatorClient;
import static com.manybrain.mailinator.client.TestEnv.getPrivateDomain;
import static com.manybrain.mailinator.client.TestEnv.getInboxTest;

class GetStreamInboxMessagesRequestTest
{
    @Test
    @EnabledIfEnvironmentVariables({
            @EnabledIfEnvironmentVariable(named = ENV_API_TOKEN, matches = "[^\\s]+"),
            @EnabledIfEnvironmentVariable(named = ENV_DOMAIN_PRIVATE, matches = "[^\\s]+"),
            @EnabledIfEnvironmentVariable(named = ENV_INBOX_TEST, matches = "[^\\s]+"),
            @EnabledIfEnvironmentVariable(named = ENV_ENABLE_STREAM, matches = "[^\\s]+")
    })
    void testGetStreamInboxMessagesRequest()
    {
        String domain = getPrivateDomain();
        String inbox = getInboxTest();
        Inbox result = getMailinatorClient().request(new GetStreamInboxMessagesRequest(domain, inbox));
        Assertions.assertNotNull(result);
    }
}
