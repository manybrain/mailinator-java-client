package com.manybrain.mailinator.client.message;

import java.io.File;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariables;
import static com.manybrain.mailinator.client.TestEnv.*;

class GetInboxMessageAttachmentRequestTest
{

    @Test
    @EnabledIfEnvironmentVariables({
            @EnabledIfEnvironmentVariable(named = ENV_API_TOKEN, matches = "[^\\s]+"),
            @EnabledIfEnvironmentVariable(named = ENV_DOMAIN_PRIVATE, matches = "[^\\s]+"),
            @EnabledIfEnvironmentVariable(named = ENV_INBOX_TEST, matches = "[^\\s]+"),
            @EnabledIfEnvironmentVariable(named = ENV_MESSAGE_WITH_ATTACHMENT_ID, matches = "[^\\s]+"),
            @EnabledIfEnvironmentVariable(named = ENV_ATTACHMENT_ID, matches = "[^\\s]+")
    })
    void testInboxMessageAttachmentRequest()
    {
        String domain = getPrivateDomain();

        File file = getMailinatorClient().request(
                new GetInboxMessageAttachmentRequest(domain, getInboxTest(), getMessageWithAttachmentId(), getAttachmentId()));
        Assertions.assertNotNull(file);
        Assertions.assertTrue(file.exists());
        Assertions.assertTrue(file.isFile());
    }
}
