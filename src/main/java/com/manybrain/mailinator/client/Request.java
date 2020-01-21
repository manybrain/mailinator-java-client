package com.manybrain.mailinator.client;

public interface Request<T>
{

    T execute(String apiToken);
}
