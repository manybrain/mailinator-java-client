package com.manybrain.mailinator.client;

//import lombok.RequiredArgsConstructor;


//@RequiredArgsConstructor
public class MailinatorClient {
    private final String apiToken;

    public MailinatorClient() {
        this.apiToken = null;
    }

    public MailinatorClient(String apiToken) {
        this.apiToken = apiToken;
    }

    public <T> T request(Request<T> request) //throws Exception
    {
        // if (apiToken != null) {
            return request.execute(apiToken);
        // } else {
        //     throw new Exception("API token is not provided.");
        // }
    }

    public <T> T request(RequestWithoutApiToken<T> request)
    {
        return request.execute();
    }
}
