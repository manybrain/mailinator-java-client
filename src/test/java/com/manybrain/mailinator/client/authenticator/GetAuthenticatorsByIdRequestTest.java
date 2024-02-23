package com.manybrain.mailinator.client.authenticator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariables;
import static com.manybrain.mailinator.client.TestEnv.ENV_API_TOKEN;
import static com.manybrain.mailinator.client.TestEnv.ENV_AUTH_ID;
import static com.manybrain.mailinator.client.TestEnv.getMailinatorClient;

class GetAuthenticatorsByIdRequestTest
{

    @Test
    @EnabledIfEnvironmentVariables({
            @EnabledIfEnvironmentVariable(named = ENV_API_TOKEN, matches = "[^\\s]+"),
            @EnabledIfEnvironmentVariable(named = ENV_AUTH_ID, matches = "[^\\s]+")
    })
    void testGetAuthenticatorsByIdRequest()
    {
        Authenticator authenticator = getMailinatorClient().request(new GetAuthenticatorsByIdRequest(ENV_AUTH_ID));
        Assertions.assertNotNull(authenticator);
    }
}
