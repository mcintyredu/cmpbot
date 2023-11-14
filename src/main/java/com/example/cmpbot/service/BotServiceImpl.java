package com.example.cmpbot.service;


import com.example.cmpbot.config.ChatGPTConfig;
import com.example.cmpbot.model.request.BotRequest;
import com.example.cmpbot.model.request.ChatGPTRequest;
import com.example.cmpbot.model.response.ChatGPTResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BotServiceImpl implements BotService {

    private static RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private ChatGPTConfig config;

    //    Build headers
    public HttpEntity<ChatGPTRequest> buildHttpEntity(ChatGPTRequest chatRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(config.MEDIATYPE));
        headers.add(config.AUTHORIZATION, config.BEARER + config.APIKEY);
        return new HttpEntity<>(chatRequest, headers);
    }

    //    Generate response
    public ChatGPTResponse getResponse(HttpEntity<ChatGPTRequest> chatRequestHttpEntity) {
        ResponseEntity<ChatGPTResponse> responseEntity = restTemplate.postForEntity(
                config.URL,
                chatRequestHttpEntity,
                ChatGPTResponse.class);

        return responseEntity.getBody();
    }

    public ChatGPTResponse askQuestion(BotRequest botRequest) {
        return this.getResponse(
                this.buildHttpEntity(
                        new ChatGPTRequest(
                                config.MODEL,
                                botRequest.getMessage(),
                                config.TEMPERATURE,
                                config.MAXTOKEN,
                                config.TOPP)));
    }
}