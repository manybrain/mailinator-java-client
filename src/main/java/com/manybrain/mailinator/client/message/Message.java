package com.manybrain.mailinator.client.message;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Message
{

    @JsonProperty("fromfull")
    private String fromfull;
    @JsonProperty("headers")
    private Map<String, Object> headers;
    @JsonProperty("subject")
    private String subject;
    @JsonProperty("parts")
    private List<Part> parts;
    @JsonProperty("from")
    private String from;
    @JsonProperty("to")
    private String to;
    @JsonProperty("id")
    private String id;
    @JsonProperty("time")
    private Long time;
    @JsonProperty("seconds_ago")
    private Long secondsAgo;
    @JsonProperty("domain")
    private String domain;
    @JsonProperty("origfrom")
    private String origfrom;
    @JsonProperty("mrid")
    private String mrid;
    @JsonProperty("size")
    private Integer size;
    @JsonProperty("stream")
    private String stream;
    @JsonProperty("msg_type")
    private String msgType;
    @JsonProperty("source")
    private String source;
    @JsonProperty("text")
    private String text;

}
