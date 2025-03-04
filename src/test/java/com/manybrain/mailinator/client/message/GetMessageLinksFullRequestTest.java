package com.manybrain.mailinator.client.message;

import java.util.UUID;

import jakarta.ws.rs.InternalServerErrorException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariables;

import static com.manybrain.mailinator.client.TestEnv.ENV_API_TOKEN;
import static com.manybrain.mailinator.client.TestEnv.ENV_DOMAIN_PRIVATE;
import static com.manybrain.mailinator.client.TestEnv.ENV_INBOX_TEST;
import static com.manybrain.mailinator.client.TestEnv.getInboxTest;
import static com.manybrain.mailinator.client.TestEnv.getMailinatorClient;
import static com.manybrain.mailinator.client.TestEnv.getPrivateDomain;
import static com.manybrain.mailinator.client.TestUtils.postMessage;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GetMessageLinksFullRequestTest
{

    @Test
//     @EnabledIfEnvironmentVariables({
//             @EnabledIfEnvironmentVariable(named = ENV_API_TOKEN, matches = "[^\\s]+"),
//             @EnabledIfEnvironmentVariable(named = ENV_DOMAIN_PRIVATE, matches = "[^\\s]+"),
//             @EnabledIfEnvironmentVariable(named = ENV_INBOX_TEST, matches = "[^\\s]+")
//     })
    void testGetLinksFullRequest()
    {
        String domain = getPrivateDomain();
        String inbox = getInboxTest();

        PostedMessage postedMessage = postMessage(domain, inbox);

        LinksFull linksFull = getMailinatorClient().request(new GetMessageLinksFullRequest(domain, postedMessage.getId()));
        assertNotNull(linksFull);
        
        DeletedMessages message =
                getMailinatorClient().request(new DeleteMessageRequest(domain, inbox, postedMessage.getId()));
    }

    @Test
//     @EnabledIfEnvironmentVariables({
//             @EnabledIfEnvironmentVariable(named = ENV_API_TOKEN, matches = "[^\\s]+"),
//             @EnabledIfEnvironmentVariable(named = ENV_DOMAIN_PRIVATE, matches = "[^\\s]+")
//     })
    void testGetMessageLinksFullRequestWhenMessageDoesNotExist()
    {
        String domain = getPrivateDomain();
        assertThrows(InternalServerErrorException.class, () -> getMailinatorClient().request(
                new GetMessageLinksFullRequest(domain, UUID.randomUUID().toString())));
    }
}
