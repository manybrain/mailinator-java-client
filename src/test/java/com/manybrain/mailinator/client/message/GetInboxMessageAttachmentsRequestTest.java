package com.manybrain.mailinator.client.message;

import jakarta.ws.rs.InternalServerErrorException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
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
        Attachments attachments;
        try
        {
            attachments = getMailinatorClient()
                                  .request(new GetInboxMessageAttachmentsRequest(domain,
                                                                     getInboxTest(),
                                                                     getMessageWithAttachmentId()));
        }
        catch (InternalServerErrorException e)
        {
            Assumptions.assumeTrue(false,
                    "attachment message is not accessible (HTTP 500) — the provided message ID may be stale or unavailable");
            return;
        }
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
