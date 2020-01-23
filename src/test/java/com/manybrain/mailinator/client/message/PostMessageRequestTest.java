package com.manybrain.mailinator.client.message;

import java.util.List;

import com.manybrain.mailinator.client.rule.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariables;
import static com.manybrain.mailinator.client.TestEnv.*;
import static com.manybrain.mailinator.client.TestUtils.postMessage;

class PostMessageRequestTest
{

    @Test
    @EnabledIfEnvironmentVariables({
            @EnabledIfEnvironmentVariable(named = ENV_API_TOKEN, matches = "[^\\s]+"),
            @EnabledIfEnvironmentVariable(named = ENV_DOMAIN_PRIVATE, matches = "[^\\s]+"),
            @EnabledIfEnvironmentVariable(named = ENV_INBOX_TEST, matches = "[^\\s]+")
    })
    void testPostMessageRequest()
    {
        String domain = getPrivateDomain();
        PostedMessage postedMessage = postMessage(domain, getInboxTest());
        Assertions.assertNotNull(postedMessage);

        List<Rule> rulesFired = postedMessage.getRulesFired();
        Assertions.assertNotNull(rulesFired);

        Message getMessage = getMailinatorClient().request(
                new GetMessageRequest(domain, getInboxTest(), postedMessage.getId()));
        Assertions.assertNotNull(getMessage);
    }
}
