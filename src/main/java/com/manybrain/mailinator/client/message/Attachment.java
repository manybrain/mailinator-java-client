package com.manybrain.mailinator.client.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Attachment
{

    @JsonProperty("filename")
    private String filename;
    @JsonProperty("content-disposition")
    private String contentDisposition;
    @JsonProperty("content-transfer-encoding")
    private String contentTransferEncoding;
    @JsonProperty("content-type")
    private String contentType;
    @JsonProperty("attachment-id")
    private Integer attachmentId;

}