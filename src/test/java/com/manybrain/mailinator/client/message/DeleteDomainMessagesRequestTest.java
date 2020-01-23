package com.manybrain.mailinator.client.message;

import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariables;
import static com.manybrain.mailinator.client.TestEnv.*;
import static com.manybrain.mailinator.client.TestUtils.postMessage;

class DeleteDomainMessagesRequestTest
{

    @Test
    @EnabledIfEnvironmentVariables({
            @EnabledIfEnvironmentVariable(named = ENV_API_TOKEN, matches = "[^\\s]+"),
            @EnabledIfEnvironmentVariable(named = ENV_DOMAIN_PRIVATE, matches = "[^\\s]+"),
            @EnabledIfEnvironmentVariable(named = ENV_DELETE_DOMAIN, matches = "true")
    })
    void testDeleteDomainMessagesRequest()
    {
        String inbox = "inbox " + UUID.randomUUID().toString();
        String domain = getPrivateDomain();

        postMessage(domain, inbox);
        postMessage(domain, inbox);
        postMessage(domain, inbox);

        DeletedMessages message = getMailinatorClient().request(new DeleteDomainMessagesRequest(domain));

        Assertions.assertNotNull(message);
    }
}
