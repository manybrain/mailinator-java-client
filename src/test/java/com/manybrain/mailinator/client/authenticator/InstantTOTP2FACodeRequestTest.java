package com.manybrain.mailinator.client.authenticator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariables;
import static com.manybrain.mailinator.client.TestEnv.ENV_API_TOKEN;
import static com.manybrain.mailinator.client.TestEnv.ENV_AUTH_SECRET;
import static com.manybrain.mailinator.client.TestEnv.getMailinatorClient;

class InstantTOTP2FACodeTest
{

    @Test
    @EnabledIfEnvironmentVariables({
            @EnabledIfEnvironmentVariable(named = ENV_API_TOKEN, matches = "[^\\s]+"),
            @EnabledIfEnvironmentVariable(named = ENV_AUTH_SECRET, matches = "[^\\s]+")
    })
    void testInstantTOTP2FACodeRequest()
    {
        InstantTOTP2FACodeResponse response = getMailinatorClient().request(new InstantTOTP2FACodeRequest(ENV_AUTH_SECRET));
        Assertions.assertNotNull(response);
    }
}
