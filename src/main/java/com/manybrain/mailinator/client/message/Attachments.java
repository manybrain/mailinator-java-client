package com.manybrain.mailinator.client.message;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Attachments
{
    @JsonProperty("attachments")
    private List<Attachment> attachments;

}