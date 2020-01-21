package com.manybrain.mailinator.client.rule;

import java.io.IOException;

import com.manybrain.mailinator.client.JerseyClient;
import com.manybrain.mailinator.client.domain.Domain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static com.manybrain.mailinator.client.TestEnv.MAILINATOR_CLIENT;
import static com.manybrain.mailinator.client.TestUtils.*;

class EnableRuleRequestTest
{

    @Disabled("Mailinator BUG: HTTP 404 ERROR: Unknown path")
    @Test
    void testEnableRuleRequest()
    {
        Domain domain = getFirstAvailableDomain();

        Rule rule = createNewRule();

        ResponseStatus responseStatus =
                MAILINATOR_CLIENT.request(new EnableRuleRequest(domain.getId(), rule.getId()));
        Assertions.assertNotNull(responseStatus);
    }

    /**
     * Test prepared to test response from {@link EnableRuleRequest}
     * <p>
     * File response taken from https://manybrain.github.io/m8rdocs/#enable-rule
     */
    @Test
    void testEnableRuleRequestResponseParser()
            throws IOException
    {
        ResponseStatus responseStatus = JerseyClient.OBJECT_MAPPER
                                                .readValue(readTestFile("EnableRuleRequestTest-response.json"),
                                                           ResponseStatus.class);

        Assertions.assertNotNull(responseStatus);
    }

}
