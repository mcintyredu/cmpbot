package com.example.cmpbot.model.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class BotRequest implements Serializable {
    private String message;
}