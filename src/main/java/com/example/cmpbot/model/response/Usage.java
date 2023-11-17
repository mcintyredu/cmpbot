package com.example.cmpbot.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Usage(

    @JsonProperty("completion_tokens")
    Integer completionTokens,
    @JsonProperty("prompt_tokens")
    Integer promptTokens,
    @JsonProperty("total_tokens")
    Integer totalTokens
) {}