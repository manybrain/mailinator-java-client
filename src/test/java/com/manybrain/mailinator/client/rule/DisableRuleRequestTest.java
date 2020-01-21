package com.manybrain.mailinator.client.rule;

import java.io.IOException;

import com.manybrain.mailinator.client.JerseyClient;
import com.manybrain.mailinator.client.domain.Domain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static com.manybrain.mailinator.client.TestEnv.MAILINATOR_CLIENT;
import static com.manybrain.mailinator.client.TestUtils.*;

class DisableRuleRequestTest
{

    @Disabled("Mailinator BUG: HTTP 404 ERROR: Unknown path")
    @Test
    void testDisableRuleRequest()
    {
        Domain domain = getFirstAvailableDomain();

        Rule rule = createNewRule();

        ResponseStatus responseStatus =
                MAILINATOR_CLIENT.request(new DisableRuleRequest(domain.getId(), rule.getId()));
        Assertions.assertNotNull(responseStatus);
    }

    /**
     * Test prepared to test response from {@link DisableRuleRequest}
     * <p>
     * File response taken from https://manybrain.github.io/m8rdocs/#disable-rule
     */
    @Test
    void testDisableRuleRequestResponseParser()
            throws IOException
    {
        ResponseStatus responseStatus = JerseyClient.OBJECT_MAPPER
                                                .readValue(readTestFile("DisableRuleRequestTest-response.json"),
                                                           ResponseStatus.class);

        Assertions.assertNotNull(responseStatus);
    }
}
