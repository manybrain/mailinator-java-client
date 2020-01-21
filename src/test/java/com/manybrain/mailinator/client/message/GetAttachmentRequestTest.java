package com.manybrain.mailinator.client.message;

import java.io.File;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import static com.manybrain.mailinator.client.TestEnv.*;

class GetAttachmentRequestTest
{

    @Test
    @EnabledIfEnvironmentVariable(named = "MAILINATOR_TEST_USER", matches = "manybrain")
        // it assumes some external test data
    void testAttachmentRequest()
    {
        File file = MAILINATOR_CLIENT.request(
                new GetAttachmentRequest(DOMAIN_PRIVATE, INBOX_TEST, MESSAGE_WITH_ATTACHMENT_ID, ATTACHMENT_ID));
        Assertions.assertNotNull(file);
        Assertions.assertTrue(file.exists());
        Assertions.assertTrue(file.isFile());
    }
}
