package com.manybrain.mailinator.client.domain;

import com.manybrain.mailinator.client.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariables;
import static com.manybrain.mailinator.client.TestEnv.ENV_API_TOKEN;
import static com.manybrain.mailinator.client.TestEnv.getMailinatorClient;

class GetDomainRequestTest
{

    @Test
    @EnabledIfEnvironmentVariables({
            @EnabledIfEnvironmentVariable(named = ENV_API_TOKEN, matches = "[^\\s]+")
    })
    void testGetDomainRequest()
    {
        Domain availableDomain = TestUtils.getFirstAvailableDomain();

        Domain domain = getMailinatorClient().request(new GetDomainRequest(availableDomain.getName()));
        Assertions.assertNotNull(domain);
    }
}
