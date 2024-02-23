package com.manybrain.mailinator.client.webhook;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PrivateWebhookResponse
{

    @JsonProperty("id")
    private String id;
    @JsonProperty("status")
    private String status;

}
