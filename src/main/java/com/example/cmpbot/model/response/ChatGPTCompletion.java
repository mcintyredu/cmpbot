package com.example.cmpbot.model.response;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ChatGPTCompletion (
    String id, 
    String object, 
    String model, 
    LocalDate created, 
    List<Choice> choices,
    @JsonProperty("system_fingerprint")
    String systemFingerprint, 
    Usage usage
    ) {}
