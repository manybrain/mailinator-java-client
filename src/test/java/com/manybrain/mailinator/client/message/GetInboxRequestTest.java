package com.manybrain.mailinator.client.message;

import com.manybrain.mailinator.client.domain.DomainType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static com.manybrain.mailinator.client.TestEnv.*;

class GetInboxRequestTest
{

    @Test
    void testInboxRequestWithPrivateDomain()
    {
        Inbox inbox = MAILINATOR_CLIENT.request(new GetInboxRequest(DOMAIN_PRIVATE));
        Assertions.assertNotNull(inbox);
    }

    @Test
    void testInboxRequestWithPrivateDomainAndInbox()
    {
        Inbox inbox = MAILINATOR_CLIENT
                              .request(GetInboxRequest.builder().domain(DOMAIN_PRIVATE).inbox(INBOX_TEST).build());
        Assertions.assertNotNull(inbox);
    }

    @Test
    void testInboxRequestWithPrivateDomainCommon()
    {
        Inbox inbox =
                MAILINATOR_CLIENT.request(GetInboxRequest.builder().domain(DomainType.PRIVATE).build());
        Assertions.assertNotNull(inbox);
    }

    @Test
    void testInboxRequestWithPublicDomainCommon()
    {
        Inbox inbox = MAILINATOR_CLIENT
                              .request(GetInboxRequest.builder().domain(DomainType.PUBLIC).inbox(INBOX_TEST).build());
        Assertions.assertNotNull(inbox);
    }

    @Test
    void testInboxRequestWithPrivateDomainWithQueryParams()
    {
        Inbox inbox = MAILINATOR_CLIENT.request(GetInboxRequest.builder().domain(DOMAIN_PRIVATE)
                                                               .skip(10).limit(20).sort(Sort.ASC).decodeSubject(
                        true).build());
        Assertions.assertNotNull(inbox);
    }
}
