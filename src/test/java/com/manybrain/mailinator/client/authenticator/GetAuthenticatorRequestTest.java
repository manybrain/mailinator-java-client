package com.manybrain.mailinator.client.authenticator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariables;
import static com.manybrain.mailinator.client.TestEnv.ENV_API_TOKEN;
import static com.manybrain.mailinator.client.TestEnv.getMailinatorClient;

class GetAuthenticatorRequestTest
{

    @Test
    @EnabledIfEnvironmentVariables({
            @EnabledIfEnvironmentVariable(named = ENV_API_TOKEN, matches = "[^\\s]+")
    })
    void testGetAuthenticatorRequest()
    {
        GetAuthenticatorsResponse response = getMailinatorClient().request(new GetAuthenticatorRequest());
        Assertions.assertNotNull(response);
    }
}
