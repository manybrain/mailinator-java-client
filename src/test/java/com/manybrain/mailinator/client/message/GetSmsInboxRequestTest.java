package com.manybrain.mailinator.client.message;

import com.manybrain.mailinator.client.domain.DomainType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariables;
import static com.manybrain.mailinator.client.TestEnv.*;

class GetSmsInboxRequestTest
{

    @Test
    @EnabledIfEnvironmentVariables({
            @EnabledIfEnvironmentVariable(named = ENV_API_TOKEN, matches = "[^\\s]+"),
            @EnabledIfEnvironmentVariable(named = ENV_PHONE_NUMBER, matches = "[^\\s]+")
    })
    void testSmsMessageRequest()
    {
        Inbox inbox =
                getMailinatorClient().request(new GetSmsInboxRequest(DomainType.PUBLIC, getPhoneNumber()));
        Assertions.assertNotNull(inbox);
    }
}
