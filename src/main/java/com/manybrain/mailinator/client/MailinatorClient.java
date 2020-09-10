package com.manybrain.mailinator.client;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class MailinatorClient {
    private final String apiToken;
    public <T> T request(Request<T> request)
    {
        return request.execute(apiToken);
    }
}
