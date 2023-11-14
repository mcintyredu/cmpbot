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
    public  String APIKEY = "";
    public  String MODEL = "text-davinci-003";
    public  Integer MAXTOKEN = 300;
    public  Double TEMPERATURE = 0.0;
    public  Double TOPP = 1.0;
    public  String MEDIATYPE = "grr";
    public  String URL = "https://api.openai.com/v1/completions";
}