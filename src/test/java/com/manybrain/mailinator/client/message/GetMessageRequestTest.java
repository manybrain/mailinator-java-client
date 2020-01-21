package com.manybrain.mailinator.client.message;

import javax.ws.rs.InternalServerErrorException;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static com.manybrain.mailinator.client.TestEnv.*;
import static com.manybrain.mailinator.client.TestUtils.postMessage;

class GetMessageRequestTest
{

    @Test
    void testMessageRequest()
    {
        String domain = DOMAIN_PRIVATE;
        String inbox = INBOX_TEST;

        PostedMessage postedMessage = postMessage(domain, inbox);

        Message message = MAILINATOR_CLIENT.request(new GetMessageRequest(domain, inbox, postedMessage.getId()));
        Assertions.assertNotNull(message);
    }

    @Test
    void testMessageRequestWhenMessageDoesNotExist()
    {
        Assertions.assertThrows(InternalServerErrorException.class, () -> MAILINATOR_CLIENT.request(
                new GetMessageRequest(DOMAIN_PRIVATE, INBOX_TEST, UUID.randomUUID().toString())));
    }
}
