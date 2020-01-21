package com.manybrain.mailinator.client.rule;

import java.io.IOException;

import com.manybrain.mailinator.client.JerseyClient;
import com.manybrain.mailinator.client.domain.Domain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static com.manybrain.mailinator.client.TestEnv.MAILINATOR_CLIENT;
import static com.manybrain.mailinator.client.TestUtils.*;

class GetRuleRequestTest
{

    @Disabled("Mailinator BUG: HTTP 404 ERROR: Unknown path")
    @Test
    void testGetRuleRequest()
    {
        Domain domain = getFirstAvailableDomain();

        Rule rule = createNewRule();

        final Rule ruleResponse =
                MAILINATOR_CLIENT.request(new GetRuleRequest(domain.getId(), rule.getId()));
        Assertions.assertNotNull(ruleResponse);
    }

    /**
     * Test prepared to test response from {@link GetRuleRequest}
     * <p>
     * File response taken from https://manybrain.github.io/m8rdocs/#get-rule
     */
    @Test
    void testGetRuleRequestResponseParser()
            throws IOException
    {
        Rule rule = JerseyClient.OBJECT_MAPPER
                            .readValue(readTestFile("GetRuleRequestTest-response.json"), Rule.class);

        Assertions.assertNotNull(rule);
    }
}
