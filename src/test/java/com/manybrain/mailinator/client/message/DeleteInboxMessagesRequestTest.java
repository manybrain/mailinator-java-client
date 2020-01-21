package com.manybrain.mailinator.client.message;

import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static com.manybrain.mailinator.client.TestEnv.DOMAIN_PRIVATE;
import static com.manybrain.mailinator.client.TestEnv.MAILINATOR_CLIENT;
import static com.manybrain.mailinator.client.TestUtils.postMessage;

class DeleteInboxMessagesRequestTest
{

    @Test
    void testDeleteInboxMessagesRequest()
    {
        String inbox = "inbox " + UUID.randomUUID().toString();

        postMessage(DOMAIN_PRIVATE, inbox);
        postMessage(DOMAIN_PRIVATE, inbox);
        postMessage(DOMAIN_PRIVATE, inbox);

        DeletedMessages message =
                MAILINATOR_CLIENT.request(new DeleteInboxMessagesRequest(DOMAIN_PRIVATE, inbox));

        Assertions.assertNotNull(message);
        Assertions.assertEquals(Integer.valueOf(3), message.getCount());
        Assertions.assertEquals("ok", message.getStatus());
    }
}
