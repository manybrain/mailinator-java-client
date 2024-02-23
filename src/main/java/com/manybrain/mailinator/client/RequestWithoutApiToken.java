package com.manybrain.mailinator.client;

public interface RequestWithoutApiToken<T>
{

    T execute();
}
