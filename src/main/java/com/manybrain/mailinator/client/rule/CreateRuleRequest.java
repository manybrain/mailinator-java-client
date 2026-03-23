package com.manybrain.mailinator.client.rule;

import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

import com.manybrain.mailinator.client.JsonUtils;
import com.manybrain.mailinator.client.Request;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import static com.manybrain.mailinator.client.JerseyClient.BASE_URL;
import static com.manybrain.mailinator.client.JerseyClient.CLIENT;
import static com.manybrain.mailinator.client.Utils.emptyIfNull;
import static jakarta.ws.rs.core.HttpHeaders.AUTHORIZATION;

/**
 * @deprecated Rules management endpoints have been deprecated and will be removed in a future release.
 */
@Deprecated
@RequiredArgsConstructor
public class CreateRuleRequest
        implements Request<Rule>
{

    private static final String URL = BASE_URL + "/domains/{domain_id}/rules/";

    private static final WebTarget WEB_TARGET = CLIENT.target(URL);

    @NonNull
    private final String domainId;
    @NonNull
    private final RuleToCreate rule;

    public Rule execute(String apiToken)
    {
        WebTarget webTarget = WEB_TARGET.resolveTemplate("domain_id", emptyIfNull(domainId));

        String response = webTarget.request(MediaType.APPLICATION_JSON_TYPE)
                        .header(AUTHORIZATION, apiToken)
                        .post(Entity.entity(rule.toJSON().toJSONString(), MediaType.APPLICATION_JSON_TYPE), String.class);
        return Rule.fromJson(JsonUtils.parseObject(response));
    }


}
