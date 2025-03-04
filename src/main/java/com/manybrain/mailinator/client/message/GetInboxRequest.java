package com.manybrain.mailinator.client.message;

import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

import com.manybrain.mailinator.client.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import static com.manybrain.mailinator.client.JerseyClient.BASE_URL;
import static com.manybrain.mailinator.client.JerseyClient.CLIENT;
import static com.manybrain.mailinator.client.Utils.emptyIfNull;
import static jakarta.ws.rs.core.HttpHeaders.AUTHORIZATION;

@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class GetInboxRequest
        implements Request<Inbox>
{

    private static final String URL = BASE_URL + "/domains/{domain}/inboxes/{inbox}";

    private static final WebTarget WEB_TARGET = CLIENT.target(URL);

    @NonNull
    private final String domain;

    private String inbox;

    private Integer skip;

    private Integer limit;

    private Sort sort;

    private Boolean decodeSubject;

    private String cursor;
    
    private Boolean full;
    
    private String delete;
    
    private String wait;

    public Inbox execute(String apiToken)
    {
        WebTarget webTarget = WEB_TARGET.resolveTemplate("domain", emptyIfNull(domain))
                                        .resolveTemplate("inbox", emptyIfNull(inbox));

        if (skip != null)
        {
            webTarget = webTarget.queryParam("skip", skip);
        }
        if (limit != null)
        {
            webTarget = webTarget.queryParam("limit", limit);
        }
        if (sort != null)
        {
            webTarget = webTarget.queryParam("sort", sort.getType());
        }
        if (decodeSubject != null)
        {
            webTarget = webTarget.queryParam("decode_subject", decodeSubject);
        }
        if (cursor != null)
        {
            webTarget = webTarget.queryParam("cursor", cursor);
        }
        if (full != null && full)
        {
            webTarget = webTarget.queryParam("full", full);
        }
        if (delete != null)
        {
            webTarget = webTarget.queryParam("delete", delete);
        }
        if (wait != null)
        {
            webTarget = webTarget.queryParam("wait", wait);
        }

        return webTarget.request(MediaType.APPLICATION_JSON_TYPE)
                        .header(AUTHORIZATION, apiToken)
                        .get(Inbox.class);
    }

}
