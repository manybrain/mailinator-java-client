package com.manybrain.mailinator.client.message;

import java.util.List;

import com.manybrain.mailinator.client.rule.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static com.manybrain.mailinator.client.TestEnv.*;
import static com.manybrain.mailinator.client.TestUtils.postMessage;

class PostMessageRequestTest
{

    @Test
    void testPostMessageRequest()
    {
        PostedMessage postedMessage = postMessage(DOMAIN_PRIVATE, INBOX_TEST);
        Assertions.assertNotNull(postedMessage);

        List<Rule> rulesFired = postedMessage.getRulesFired();
        Assertions.assertNotNull(rulesFired);

        Message getMessage = MAILINATOR_CLIENT.request(
                new GetMessageRequest(DOMAIN_PRIVATE, INBOX_TEST, postedMessage.getId()));
        Assertions.assertNotNull(getMessage);
    }
}
