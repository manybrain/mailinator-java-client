package com.manybrain.mailinator.client.message;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import static com.manybrain.mailinator.client.TestEnv.*;
import static com.manybrain.mailinator.client.TestUtils.postMessage;


class GetAttachmentsRequestTest
{

    @Test
    @EnabledIfEnvironmentVariable(named = "MAILINATOR_TEST_USER", matches = "manybrain")
        // it assumes some external test data
    void testAttachmentsRequest()
    {
        Attachments attachments = MAILINATOR_CLIENT
                                          .request(new GetAttachmentsRequest(DOMAIN_PRIVATE, INBOX_TEST,
                                                                             MESSAGE_WITH_ATTACHMENT_ID));
        Assertions.assertNotNull(attachments);
    }

    @Test
    void testAttachmentsMissingRequest()
    {
        String domain = DOMAIN_PRIVATE;
        String inbox = INBOX_TEST;

        PostedMessage postedMessage = postMessage(domain, inbox);

        Attachments attachments =
                MAILINATOR_CLIENT.request(new GetAttachmentsRequest(domain, inbox, postedMessage.getId()));
        Assertions.assertNotNull(attachments);
        Assertions
                .assertTrue(attachments.getAttachments() == null || attachments.getAttachments().isEmpty());
    }
}
