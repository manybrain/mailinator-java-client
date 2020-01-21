package com.manybrain.mailinator.client.rule;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RuleToCreate
{

    @JsonProperty("description")
    private String description;
    @Builder.Default
    @JsonProperty("enabled")
    private Boolean enabled = Boolean.TRUE;
    @Builder.Default
    @JsonProperty("match")
    public MatchType match = MatchType.ALL;
    @NonNull
    @JsonProperty("name")
    private String name;
    @NonNull
    @JsonProperty("priority")
    private Integer priority;
    @NonNull
    @JsonProperty("conditions")
    private List<Condition> conditions;
    @NonNull
    @JsonProperty("actions")
    private List<Action> actions;
}