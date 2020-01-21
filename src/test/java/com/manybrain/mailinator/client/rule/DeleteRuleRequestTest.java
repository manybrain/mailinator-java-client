package com.manybrain.mailinator.client.rule;

import java.io.IOException;

import com.manybrain.mailinator.client.JerseyClient;
import com.manybrain.mailinator.client.domain.Domain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static com.manybrain.mailinator.client.TestEnv.MAILINATOR_CLIENT;
import static com.manybrain.mailinator.client.TestUtils.*;

class DeleteRuleRequestTest
{

    @Disabled("Mailinator BUG: HTTP 404 ERROR: Unknown path")
    @Test
    void testDeleteRuleRequest()
    {
        Domain domain = getFirstAvailableDomain();

        Rule rule = createNewRule();

        ResponseStatus responseStatus =
                MAILINATOR_CLIENT.request(new DeleteRuleRequest(domain.getId(), rule.getId()));
        Assertions.assertNotNull(responseStatus);
    }

    /**
     * Test prepared to test response from {@link DeleteRuleRequest}
     * <p>
     * File response taken from https://manybrain.github.io/m8rdocs/#delete-rule
     */
    @Test
    void testDeleteRuleRequestResponseParser()
            throws IOException
    {
        ResponseStatus responseStatus = JerseyClient.OBJECT_MAPPER
                                                .readValue(readTestFile("DeleteRuleRequest-response.json"),
                                                           ResponseStatus.class);

        Assertions.assertNotNull(responseStatus);
    }
}
