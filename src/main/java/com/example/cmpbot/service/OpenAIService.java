package com.example.cmpbot.service;

import com.example.cmpbot.model.response.ChatGPTCompletion;

public interface OpenAIService {

    ChatGPTCompletion askQuestion(String message, String model);
}