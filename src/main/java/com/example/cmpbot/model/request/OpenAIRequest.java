package com.example.cmpbot.model.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpenAIRequest implements Serializable {

    public OpenAIRequest(
        String model,
        String message,
        Double temperature,
        Integer maxTokens,
        Double topP
    ) {
        this.model = model;
        messages = new ArrayList<Message>();
        messages.add(new Message(message, "user","R2D2"));
        this.temperature = temperature;
        this.maxTokens = maxTokens;
        this.topP = topP;
    }

    private List<Message> messages;

    private String model;

    @JsonProperty("frequency_penalty")
    private Double frequencyPenalty = 0.0;

    // Number of choices to generate for each input message
    @JsonProperty("n")
    private Integer numChoices;

    //private String prompt;

    private Double temperature = 1.0;

    @JsonProperty("max_tokens")
    private Integer maxTokens;

    @JsonProperty("top_p")
    private Double topP = 1.0;


}