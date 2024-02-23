package com.manybrain.mailinator.client;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.glassfish.jersey.logging.LoggingFeature;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JerseyClient
{

    public static final String BASE_URL = "https://api.mailinator.com/api/v2";
    public static final String USER_AGENT = "Mailinator SDK - Java V1.7";
    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static final Client CLIENT = ClientBuilder.newClient()
                                                     .register(new LoggingFeature(Logger.getLogger(
                                                             JerseyClient.class.getPackage().getName()),
                                                                                  Level.SEVERE,
                                                                                  null,
                                                                                  null))
                                                     .register(OBJECT_MAPPER)
                                                     .property("User-Agent", USER_AGENT);
}
