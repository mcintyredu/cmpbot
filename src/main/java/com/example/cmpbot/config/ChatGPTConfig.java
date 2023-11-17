package com.example.cmpbot.config;

import org.springframework.stereotype.Component;

import lombok.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;

@Component
@ConfigurationProperties(prefix = "openai.request.properties")
@Data
public class ChatGPTConfig {

    public  String AUTHORIZATION = "";
    public  String BEARER = "Bearer ";
    public  String API_KEY = "";
    public  String MODEL = "text-davinci-003";
    public  Integer MAX_TOKEN = 300;
    public  Double TEMPERATURE = 0.0;
    public  Double TOP_P = 1.0;
    public  String MEDIATYPE = "grr";
    public  String URL = "https://api.openai.com/v1/completions";
}