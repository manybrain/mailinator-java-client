package com.manybrain.mailinator.client.domain;

import com.manybrain.mailinator.client.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static com.manybrain.mailinator.client.TestEnv.MAILINATOR_CLIENT;

class GetDomainRequestTest
{

    @Test
    void testGetDomainRequest()
    {
        Domain availableDomain = TestUtils.getFirstAvailableDomain();

        Domain domain = MAILINATOR_CLIENT.request(new GetDomainRequest(availableDomain.getId()));
        Assertions.assertNotNull(domain);
    }
}
