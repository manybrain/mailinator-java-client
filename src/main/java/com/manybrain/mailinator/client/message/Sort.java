package com.manybrain.mailinator.client.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Sort
{
    ASC("ascending"),
    DESC("descending");

    private final String type;

}
