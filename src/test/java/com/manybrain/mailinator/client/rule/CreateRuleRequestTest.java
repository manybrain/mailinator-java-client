package com.manybrain.mailinator.client.rule;

import java.io.IOException;

import com.manybrain.mailinator.client.JerseyClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static com.manybrain.mailinator.client.TestUtils.createNewRule;
import static com.manybrain.mailinator.client.TestUtils.readTestFile;

class CreateRuleRequestTest
{

    @Disabled("Mailinator BUG: HTTP 404 ERROR: Unknown path")
    @Test
    void testCreateRuleRequest()
    {
        Rule rule = createNewRule();
        Assertions.assertNotNull(rule);
    }

    /**
     * Test prepared to test response from {@link CreateRuleRequest}
     * <p>
     * File response taken from https://manybrain.github.io/m8rdocs/#create-rule
     */
    @Test
    void testCreateRuleRequestResponseParser()
            throws IOException
    {
        Rule rule = JerseyClient.OBJECT_MAPPER.readValue(readTestFile("CreateRuleRequestTest-response.json"),
                                                         Rule.class);
        Assertions.assertNotNull(rule);
    }

}
