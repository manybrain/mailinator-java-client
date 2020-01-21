package com.manybrain.mailinator.client.message;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static com.manybrain.mailinator.client.TestEnv.*;
import static com.manybrain.mailinator.client.TestUtils.postMessage;

class DeleteMessageRequestTest
{

    @Test
    void testDeleteMessageRequest()
    {
        String domain = DOMAIN_PRIVATE;
        String inbox = INBOX_TEST;

        PostedMessage postedMessage = postMessage(domain, inbox);

        DeletedMessages message =
                MAILINATOR_CLIENT.request(new DeleteMessageRequest(domain, inbox, postedMessage.getId()));

        Assertions.assertNotNull(message);
        Assertions.assertEquals(Integer.valueOf(1), message.getCount());
        Assertions.assertEquals("ok", message.getStatus());
    }


}
