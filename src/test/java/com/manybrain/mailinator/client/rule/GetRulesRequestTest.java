package com.manybrain.mailinator.client.rule;

import java.io.IOException;

import com.manybrain.mailinator.client.JerseyClient;
import com.manybrain.mailinator.client.TestUtils;
import com.manybrain.mailinator.client.domain.Domain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static com.manybrain.mailinator.client.TestEnv.getMailinatorClient;
import static com.manybrain.mailinator.client.TestUtils.readTestFile;

class GetRulesRequestTest
{

    @Disabled("Mailinator BUG: HTTP 404 ERROR: Unknown path")
    @Test
    void testGetRulesRequest()
    {
        Domain domain = TestUtils.getFirstAvailableDomain();

        Rules rules = getMailinatorClient().request(new GetRulesRequest(domain.getId()));
        Assertions.assertNotNull(rules);
    }

    /**
     * Test prepared to test response from {@link GetRulesRequest}
     * <p>
     * File response taken from https://manybrain.github.io/m8rdocs/#get-all-rules
     */
    @Test
    void testGetRulesRequestResponseParser()
            throws IOException
    {
        Rules rules = JerseyClient.OBJECT_MAPPER
                              .readValue(readTestFile("GetRulesRequestTest-response.json"), Rules.class);
        Assertions.assertNotNull(rules);
    }
}
