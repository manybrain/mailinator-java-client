package com.manybrain.mailinator.client.message;

import java.util.UUID;

import jakarta.ws.rs.InternalServerErrorException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariables;
import static com.manybrain.mailinator.client.TestEnv.*;
import static com.manybrain.mailinator.client.TestUtils.postMessage;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GetMessageRequestTest
{

    @Test
    @EnabledIfEnvironmentVariables({
            @EnabledIfEnvironmentVariable(named = ENV_API_TOKEN, matches = "[^\\s]+"),
            @EnabledIfEnvironmentVariable(named = ENV_DOMAIN_PRIVATE, matches = "[^\\s]+"),
            @EnabledIfEnvironmentVariable(named = ENV_INBOX_TEST, matches = "[^\\s]+")
    })
    void testMessageRequest()
    {
        String domain = getPrivateDomain();
        String inbox = getInboxTest();

        PostedMessage postedMessage = postMessage(domain, inbox);

        Message message = getMailinatorClient().request(new GetMessageRequest(domain, postedMessage.getId()));
        Assertions.assertNotNull(message);
        
        DeletedMessages deletedMessages =
                getMailinatorClient().request(new DeleteMessageRequest(domain, inbox, postedMessage.getId()));
    }

    @Test
    @EnabledIfEnvironmentVariables({
            @EnabledIfEnvironmentVariable(named = ENV_API_TOKEN, matches = "[^\\s]+"),
            @EnabledIfEnvironmentVariable(named = ENV_DOMAIN_PRIVATE, matches = "[^\\s]+")
    })
    void testMessageRequestWhenMessageDoesNotExist()
    {
        String domain = getPrivateDomain();
        Assertions.assertThrows(InternalServerErrorException.class, () -> getMailinatorClient().request(
                new GetMessageRequest(domain, UUID.randomUUID().toString())));
    }

    @Test
    @EnabledIfEnvironmentVariables({
            @EnabledIfEnvironmentVariable(named = ENV_API_TOKEN, matches = "[^\\s]+"),
            @EnabledIfEnvironmentVariable(named = ENV_DOMAIN_PRIVATE, matches = "[^\\s]+"),
            @EnabledIfEnvironmentVariable(named = ENV_INBOX_TEST, matches = "[^\\s]+")
    })
    void testGetMessageAndDeleteRequest()
    {
        String domain = getPrivateDomain();
        String inbox = getInboxTest();

        PostedMessage postedMessage = postMessage(domain, inbox);

        GetMessageRequest request = GetMessageRequest.builder()
                                         .domain(domain)
                                         .messageId(postedMessage.getId())
                                         .delete("5s")
                                         .build();
        Message message = getMailinatorClient().request(request);
        Assertions.assertNotNull(message);

        try {
                // Wait 45 seconds
                Thread.sleep(45000);
        } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                Assertions.fail("Interrupted during wait", e);
        }

        assertThrows(InternalServerErrorException.class, () -> getMailinatorClient().request(new GetMessageRequest(domain, postedMessage.getId())));
    }
}
