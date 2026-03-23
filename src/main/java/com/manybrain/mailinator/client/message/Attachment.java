package com.manybrain.mailinator.client.message;

import com.manybrain.mailinator.client.JsonUtils;
import lombok.Data;
import org.json.simple.JSONObject;

@Data
public class Attachment
{
    private String filename;
    private String contentDisposition;
    private String contentTransferEncoding;
    private String contentType;
    private Integer attachmentId;

    public static Attachment fromJson(JSONObject json) {
        if (json == null) return null;
        Attachment a = new Attachment();
        a.filename = JsonUtils.getString(json, "filename");
        a.contentDisposition = JsonUtils.getString(json, "content-disposition");
        a.contentTransferEncoding = JsonUtils.getString(json, "content-transfer-encoding");
        a.contentType = JsonUtils.getString(json, "content-type");
        a.attachmentId = JsonUtils.getInteger(json, "attachment-id");
        return a;
    }
}