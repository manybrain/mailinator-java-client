package com.manybrain.mailinator.client;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Utils
{

    public static String emptyIfNull(String value)
    {
        return value != null ? value : "";
    }
}
