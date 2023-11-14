package com.example.cmpbot.controller;
import com.example.cmpbot.model.request.BotRequest;
import com.example.cmpbot.model.response.ChatGPTResponse;
import com.example.cmpbot.service.BotService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bot")
public class BotController {

    private final BotService botService;

    public BotController(BotService s) {
        botService = s;
    }

    @PostMapping("/send")
    public ChatGPTResponse sendMessage(@RequestBody BotRequest botRequest) {
        return botService.askQuestion(botRequest);
    }
}