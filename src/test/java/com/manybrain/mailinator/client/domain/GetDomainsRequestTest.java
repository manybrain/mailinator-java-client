package com.manybrain.mailinator.client.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static com.manybrain.mailinator.client.TestEnv.MAILINATOR_CLIENT;

class GetDomainsRequestTest
{

    @Test
    void testGetDomainsRequest()
    {
        Domains domains = MAILINATOR_CLIENT.request(new GetDomainsRequest());
        Assertions.assertNotNull(domains);
    }
}
