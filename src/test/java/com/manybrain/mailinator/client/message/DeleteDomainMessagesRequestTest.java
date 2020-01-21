package com.manybrain.mailinator.client.message;

import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static com.manybrain.mailinator.client.TestEnv.DOMAIN_PRIVATE;
import static com.manybrain.mailinator.client.TestEnv.MAILINATOR_CLIENT;
import static com.manybrain.mailinator.client.TestUtils.postMessage;

class DeleteDomainMessagesRequestTest
{

    @Disabled // it will clear whole domain
    @Test
    void testDeleteDomainMessagesRequest()
    {
        String inbox = "inbox " + UUID.randomUUID().toString();

        postMessage(DOMAIN_PRIVATE, inbox);
        postMessage(DOMAIN_PRIVATE, inbox);
        postMessage(DOMAIN_PRIVATE, inbox);

        DeletedMessages message = MAILINATOR_CLIENT.request(new DeleteDomainMessagesRequest(DOMAIN_PRIVATE));

        Assertions.assertNotNull(message);
    }
}
