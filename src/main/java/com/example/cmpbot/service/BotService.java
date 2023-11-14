package com.example.cmpbot.service;

import com.example.cmpbot.model.request.BotRequest;
import com.example.cmpbot.model.response.ChatGPTResponse;

public interface BotService {

    ChatGPTResponse askQuestion(BotRequest botRequest);
}