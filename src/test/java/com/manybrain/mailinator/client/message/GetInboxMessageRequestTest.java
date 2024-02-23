package com.manybrain.mailinator.client.message;

import javax.ws.rs.InternalServerErrorException;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariables;
import static com.manybrain.mailinator.client.TestEnv.*;
import static com.manybrain.mailinator.client.TestUtils.postMessage;

class GetInboxMessageRequestTest
{

    @Test
    @EnabledIfEnvironmentVariables({
            @EnabledIfEnvironmentVariable(named = ENV_API_TOKEN, matches = "[^\\s]+"),
            @EnabledIfEnvironmentVariable(named = ENV_DOMAIN_PRIVATE, matches = "[^\\s]+"),
            @EnabledIfEnvironmentVariable(named = ENV_INBOX_TEST, matches = "[^\\s]+")
    })
    void testInboxMessageRequest()
    {
        String domain = getPrivateDomain();
        String inbox = getInboxTest();

        PostedMessage postedMessage = postMessage(domain, inbox);

        Message message = getMailinatorClient().request(new GetInboxMessageRequest(domain, inbox, postedMessage.getId()));
        Assertions.assertNotNull(message);
        
        DeletedMessages deletedMessages =
                getMailinatorClient().request(new DeleteMessageRequest(domain, inbox, postedMessage.getId()));
    }

    @Test
    @EnabledIfEnvironmentVariables({
            @EnabledIfEnvironmentVariable(named = ENV_API_TOKEN, matches = "[^\\s]+"),
            @EnabledIfEnvironmentVariable(named = ENV_DOMAIN_PRIVATE, matches = "[^\\s]+"),
            @EnabledIfEnvironmentVariable(named = ENV_INBOX_TEST, matches = "[^\\s]+")
    })
    void testInboxMessageRequestWhenMessageDoesNotExist()
    {
        String domain = getPrivateDomain();
        Assertions.assertThrows(InternalServerErrorException.class, () -> getMailinatorClient().request(
                new GetInboxMessageRequest(domain, getInboxTest(), UUID.randomUUID().toString())));
    }
}
