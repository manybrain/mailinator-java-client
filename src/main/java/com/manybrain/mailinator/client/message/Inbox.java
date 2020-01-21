
package com.manybrain.mailinator.client.message;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Inbox
{

    @JsonProperty("domain")
    private String domain;
    @JsonProperty("to")
    private String to;
    @JsonProperty("msgs")
    private List<Message> msgs;

}
