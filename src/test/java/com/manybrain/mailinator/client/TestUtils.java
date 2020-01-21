package com.manybrain.mailinator.client;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.UUID;

import com.manybrain.mailinator.client.domain.Domain;
import com.manybrain.mailinator.client.domain.Domains;
import com.manybrain.mailinator.client.domain.GetDomainsRequest;
import com.manybrain.mailinator.client.message.MessageToPost;
import com.manybrain.mailinator.client.message.PostMessageRequest;
import com.manybrain.mailinator.client.message.PostedMessage;
import com.manybrain.mailinator.client.rule.*;
import org.junit.jupiter.api.Assertions;
import static com.manybrain.mailinator.client.TestEnv.MAILINATOR_CLIENT;
import static com.manybrain.mailinator.client.rule.ActionType.WEBHOOK;
import static com.manybrain.mailinator.client.rule.OperationType.EQUALS;

public class TestUtils
{

    public static PostedMessage postMessage(String domain,
                                            String inbox)
    {
        String random = UUID.randomUUID().toString();
        MessageToPost message =
                new MessageToPost("raul", "testPostMessageRequest " + random, "text " + random);

        PostedMessage postedMessage =
                MAILINATOR_CLIENT.request(new PostMessageRequest(domain, inbox, message));
        Assertions.assertNotNull(postedMessage);

        return postedMessage;
    }

    public static Domain getFirstAvailableDomain()
    {
        Domains domains = MAILINATOR_CLIENT.request(new GetDomainsRequest());
        Assertions.assertNotNull(domains);
        return domains.getDomains().get(0);
    }

    public static Rule createNewRule()
    {
        Domain domain = getFirstAvailableDomain();

        ActionData actionData =
                ActionData.builder().url("https://www.mywebsite.com/restendpoint").build();
        Action action = Action.builder().action(WEBHOOK).actionData(actionData).build();

        Condition condition = Condition.builder().operation(EQUALS).value("raul").build();

        String random = UUID.randomUUID().toString();
        RuleToCreate ruleToCreate = RuleToCreate.builder().name("rule name " + random).priority(15)
                                                .conditions(Arrays.asList(condition)).actions(
                        Arrays.asList(action)).build();

        Rule rule = MAILINATOR_CLIENT.request(new CreateRuleRequest(domain.getId(), ruleToCreate));
        Assertions.assertNotNull(rule);

        return rule;
    }

    /**
     * Works running from IDE and from maven
     */
    public static File readTestFile(String filename)
    {
        URL resource = TestUtils.class.getClassLoader().getResource(filename);
        if (resource == null)
        {
            resource = TestUtils.class.getClassLoader().getResource("src/test/resources/" + filename);
            if (resource == null)
            {
                throw new IllegalArgumentException(filename + " not found");
            }
        }


        File file;
        try
        {
            file = new File(resource.toURI());
        }
        catch (URISyntaxException e)
        {
            throw new IllegalArgumentException(filename + " URISyntaxException", e);
        }
        Assertions.assertTrue(file.exists());

        return file;
    }
}
