package com.manybrain.mailinator.client.message;

import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariables;
import static com.manybrain.mailinator.client.TestEnv.*;
import static com.manybrain.mailinator.client.TestUtils.postMessage;

class DeleteInboxMessagesRequestTest
{

    @Test
    @EnabledIfEnvironmentVariables({
            @EnabledIfEnvironmentVariable(named = ENV_API_TOKEN, matches = "[^\\s]+"),
            @EnabledIfEnvironmentVariable(named = ENV_DOMAIN_PRIVATE, matches = "[^\\s]+"),
    })
    void testDeleteInboxMessagesRequest()
    {
        String inbox = "inbox " + UUID.randomUUID().toString();
        String domain = getPrivateDomain();

        postMessage(domain, inbox);
        postMessage(domain, inbox);
        postMessage(domain, inbox);

        DeletedMessages message =
                getMailinatorClient().request(new DeleteInboxMessagesRequest(domain, inbox));

        Assertions.assertNotNull(message);
        Assertions.assertEquals(Integer.valueOf(3), message.getCount());
        Assertions.assertEquals("ok", message.getStatus());
    }
}
