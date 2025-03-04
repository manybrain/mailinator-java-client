package com.manybrain.mailinator.client.message;

import com.manybrain.mailinator.client.domain.DomainType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariables;
import static com.manybrain.mailinator.client.TestEnv.*;

class GetInboxRequestTest
{

    @Test
    @EnabledIfEnvironmentVariables({
            @EnabledIfEnvironmentVariable(named = ENV_API_TOKEN, matches = "[^\\s]+"),
            @EnabledIfEnvironmentVariable(named = ENV_DOMAIN_PRIVATE, matches = "[^\\s]+")
    })
    void testInboxRequestWithPrivateDomain()
    {
        String domain = getPrivateDomain();
        Inbox inbox = getMailinatorClient().request(new GetInboxRequest(domain));
        Assertions.assertNotNull(inbox);
    }

    @Test
    @EnabledIfEnvironmentVariables({
            @EnabledIfEnvironmentVariable(named = ENV_API_TOKEN, matches = "[^\\s]+"),
            @EnabledIfEnvironmentVariable(named = ENV_DOMAIN_PRIVATE, matches = "[^\\s]+"),
            @EnabledIfEnvironmentVariable(named = ENV_INBOX_TEST, matches = "[^\\s]+")
    })
    void testInboxRequestWithPrivateDomainAndInbox()
    {
        String domain = getPrivateDomain();
        Inbox inbox = getMailinatorClient()
                              .request(GetInboxRequest.builder().domain(domain).inbox(getInboxTest()).build());
        Assertions.assertNotNull(inbox);
    }

    @Test
    @EnabledIfEnvironmentVariables({
            @EnabledIfEnvironmentVariable(named = ENV_API_TOKEN, matches = "[^\\s]+")
    })
    void testInboxRequestWithPrivateDomainCommon()
    {
        Inbox inbox =
                getMailinatorClient().request(GetInboxRequest.builder().domain(DomainType.PRIVATE).build());
        Assertions.assertNotNull(inbox);
    }

    @Test
    @EnabledIfEnvironmentVariables({
            @EnabledIfEnvironmentVariable(named = ENV_API_TOKEN, matches = "[^\\s]+"),
            @EnabledIfEnvironmentVariable(named = ENV_INBOX_TEST, matches = "[^\\s]+")
    })
    void testInboxRequestWithPublicDomainCommon()
    {
        Inbox inbox = getMailinatorClient()
                              .request(GetInboxRequest.builder().domain(DomainType.PUBLIC).inbox(getInboxTest()).build());
        Assertions.assertNotNull(inbox);
    }

    @Test
    @EnabledIfEnvironmentVariables({
            @EnabledIfEnvironmentVariable(named = ENV_API_TOKEN, matches = "[^\\s]+"),
            @EnabledIfEnvironmentVariable(named = ENV_DOMAIN_PRIVATE, matches = "[^\\s]+")
    })
    void testInboxRequestWithPrivateDomainWithQueryParams()
    {
        String domain = getPrivateDomain();
        Inbox inbox = getMailinatorClient().request(
                GetInboxRequest.builder()
                               .domain(domain)
                               .skip(10)
                               .limit(20)
                               .sort(Sort.ASC)
                               .decodeSubject(true)
                               .build());
        Assertions.assertNotNull(inbox);
    }

    @Test
    @EnabledIfEnvironmentVariables({
            @EnabledIfEnvironmentVariable(named = ENV_API_TOKEN, matches = "[^\\s]+"),
            @EnabledIfEnvironmentVariable(named = ENV_DOMAIN_PRIVATE, matches = "[^\\s]+")
    })
    void testInboxRequestWithPrivateDomainWithCursorQueryParams()
    {
        String domain = getPrivateDomain();
        Inbox inbox1 = getMailinatorClient().request(
                GetInboxRequest.builder()
                               .domain(domain)
                               .limit(1)
                               .build());
        Assertions.assertNotNull(inbox1);

        Inbox inbox2 = getMailinatorClient().request(
                GetInboxRequest.builder()
                               .domain(domain)
                               .limit(1)
                               .cursor(inbox1.getCursor())
                               .build());
        Assertions.assertNotNull(inbox2);
    }

    @Test
    @EnabledIfEnvironmentVariables({
            @EnabledIfEnvironmentVariable(named = ENV_API_TOKEN, matches = "[^\\s]+"),
            @EnabledIfEnvironmentVariable(named = ENV_DOMAIN_PRIVATE, matches = "[^\\s]+")
    })
    void testInboxRequestWithPrivateDomainWithFullQueryParams()
    {
        String domain = getPrivateDomain();
        Inbox inbox = getMailinatorClient().request(
                GetInboxRequest.builder()
                               .domain(domain)
                               .full(true)
                               .limit(1)
                               .build());
        Assertions.assertNotNull(inbox);
    }

    @Test
    @EnabledIfEnvironmentVariables({
            @EnabledIfEnvironmentVariable(named = ENV_API_TOKEN, matches = "[^\\s]+"),
            @EnabledIfEnvironmentVariable(named = ENV_DOMAIN_PRIVATE, matches = "[^\\s]+")
    })
    void testInboxRequestWithPrivateDomainWithDeleteQueryParams()
    {
        String domain = getPrivateDomain();
        Inbox inbox = getMailinatorClient().request(
                GetInboxRequest.builder()
                               .domain(domain)
                               .limit(1)
                               .delete("1m")
                               .build());
        Assertions.assertNotNull(inbox);
    }

    @Test
    @EnabledIfEnvironmentVariables({
            @EnabledIfEnvironmentVariable(named = ENV_API_TOKEN, matches = "[^\\s]+"),
            @EnabledIfEnvironmentVariable(named = ENV_DOMAIN_PRIVATE, matches = "[^\\s]+")
    })
    void testInboxRequestWithPrivateDomainWithWaitQueryParams()
    {
        String domain = getPrivateDomain();
        Inbox inbox = getMailinatorClient().request(
                GetInboxRequest.builder()
                               .domain(domain)
                               .limit(1)
                               .wait("1m")
                               .build());
        Assertions.assertNotNull(inbox);
    }
}
