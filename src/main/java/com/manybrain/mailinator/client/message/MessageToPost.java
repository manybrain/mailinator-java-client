package com.manybrain.mailinator.client.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
public class MessageToPost
{

    @NonNull
    @JsonProperty("subject")
    private String subject;
    @NonNull
    @JsonProperty("from")
    private String from;
    @NonNull
    @JsonProperty("text")
    private String text;
}
