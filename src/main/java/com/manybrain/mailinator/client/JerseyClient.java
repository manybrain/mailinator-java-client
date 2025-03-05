package com.manybrain.mailinator.client;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.ClientRequestFilter;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import org.glassfish.jersey.client.ClientProperties;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.logging.LoggingFeature;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JerseyClient
{

    public static final String BASE_URL = "https://api.mailinator.com/api/v2";
    public static final String USER_AGENT = "Mailinator SDK - Java V2.1";
    
    // Configure ObjectMapper
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    // Define a filter to set the User-Agent header
    private static final ClientRequestFilter USER_AGENT_FILTER = requestContext -> {
        requestContext.getHeaders().add("User-Agent", USER_AGENT);
    };

    public static final Client CLIENT = ClientBuilder.newClient()
                                                     .property(ClientProperties.READ_TIMEOUT, (int) TimeUnit.SECONDS.toMillis(125)) // Set read timeout to 65 sec
                                                     .register(new LoggingFeature(Logger.getLogger(
                                                             JerseyClient.class.getPackage().getName()),
                                                                                  Level.SEVERE,
                                                                                  null,
                                                                                  null))
                                                     .register(new JacksonFeature())
                                                     .register(OBJECT_MAPPER)
                                                     .register(USER_AGENT_FILTER);
}
