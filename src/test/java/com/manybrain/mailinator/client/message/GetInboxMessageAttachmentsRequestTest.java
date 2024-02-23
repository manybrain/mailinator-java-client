package com.manybrain.mailinator.client.message;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariables;
import static com.manybrain.mailinator.client.TestEnv.*;
import static com.manybrain.mailinator.client.TestUtils.postMessage;


class GetInboxMessageAttachmentsRequestTest
{

    @Test
    @EnabledIfEnvironmentVariables({
            @EnabledIfEnvironmentVariable(named = ENV_API_TOKEN, matches = "[^\\s]+"),
            @EnabledIfEnvironmentVariable(named = ENV_DOMAIN_PRIVATE, matches = "[^\\s]+"),
            @EnabledIfEnvironmentVariable(named = ENV_INBOX_TEST, matches = "[^\\s]+"),
            @EnabledIfEnvironmentVariable(named = ENV_MESSAGE_WITH_ATTACHMENT_ID, matches = "[^\\s]+")
    })
    void testInboxMessageAttachmentsRequest()
    {
        String domain = getPrivateDomain();
        Attachments attachments = getMailinatorClient()
                                          .request(new GetInboxMessageAttachmentsRequest(domain,
                                                                             getInboxTest(),
                                                                             getMessageWithAttachmentId()));
        Assertions.assertNotNull(attachments);
    }

    @Test
    @EnabledIfEnvironmentVariables({
            @EnabledIfEnvironmentVariable(named = ENV_API_TOKEN, matches = "[^\\s]+"),
            @EnabledIfEnvironmentVariable(named = ENV_DOMAIN_PRIVATE, matches = "[^\\s]+"),
            @EnabledIfEnvironmentVariable(named = ENV_INBOX_TEST, matches = "[^\\s]+")
    })
    void testInboxMessageAttachmentsMissingRequest()
    {
        String domain = getPrivateDomain();
        String inbox = getInboxTest();

        PostedMessage postedMessage = postMessage(domain, inbox);

        Attachments attachments =
                getMailinatorClient().request(new GetInboxMessageAttachmentsRequest(domain, inbox, postedMessage.getId()));
        Assertions.assertNotNull(attachments);
        Assertions
                .assertTrue(attachments.getAttachments() == null || attachments.getAttachments().isEmpty());
                
        DeletedMessages message =
        getMailinatorClient().request(new DeleteMessageRequest(domain, inbox, postedMessage.getId()));
    }
}
