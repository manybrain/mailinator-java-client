package com.manybrain.mailinator.client.rule;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConditionData
{

    @JsonProperty("operation")
    public OperationType operation;
    @Builder.Default
    @JsonProperty("field")
    public String field = "to";
    @JsonProperty("value")
    public String value;

}