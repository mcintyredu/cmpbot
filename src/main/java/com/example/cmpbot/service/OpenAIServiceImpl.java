package com.example.cmpbot.service;


import com.example.cmpbot.config.ChatGPTConfig;
import com.example.cmpbot.model.request.BotRequest;
import com.example.cmpbot.model.request.OpenAIRequest;
import com.example.cmpbot.model.response.ChatGPTCompletion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenAIServiceImpl implements OpenAIService {

    private static RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private ChatGPTConfig config;

    //    Build headers
    public HttpEntity<OpenAIRequest> buildHttpEntity(OpenAIRequest chatRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(config.MEDIATYPE));
        headers.add(config.AUTHORIZATION, config.BEARER + config.API_KEY);
        return new HttpEntity<>(chatRequest, headers);
    }

    //    Generate response
    public ChatGPTCompletion getResponse(HttpEntity<OpenAIRequest> chatRequestHttpEntity) {
        ResponseEntity<ChatGPTCompletion> responseEntity = restTemplate.postForEntity(
                config.URL,
                chatRequestHttpEntity,
                ChatGPTCompletion.class);

        return responseEntity.getBody();
    }

    public ChatGPTCompletion askQuestion(String message, String model) {
        return this.getResponse(
                this.buildHttpEntity(
                        new OpenAIRequest(
                                model,
                                message,
                                config.TEMPERATURE,
                                config.MAX_TOKEN,
                                config.TOP_P)));
    }
}