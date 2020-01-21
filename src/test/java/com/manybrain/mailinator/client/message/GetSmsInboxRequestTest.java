package com.manybrain.mailinator.client.message;

import com.manybrain.mailinator.client.domain.DomainType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import static com.manybrain.mailinator.client.TestEnv.MAILINATOR_CLIENT;
import static com.manybrain.mailinator.client.TestEnv.PHONE_NUMBER;

class GetSmsInboxRequestTest
{

    @Test
    @EnabledIfEnvironmentVariable(named = "MAILINATOR_TEST_USER", matches = "manybrain")
        // it assumes some external test data
    void testSmsMessageRequest()
    {
        Inbox inbox =
                MAILINATOR_CLIENT.request(new GetSmsInboxRequest(DomainType.PUBLIC, PHONE_NUMBER));
        Assertions.assertNotNull(inbox);
    }
}
