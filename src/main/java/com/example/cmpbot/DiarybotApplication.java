package com.example.cmpbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.theme.Theme;

@SpringBootApplication
@Theme("default")
public class DiarybotApplication implements AppShellConfigurator {

	public static void main(String[] args) {
		SpringApplication.run(DiarybotApplication.class, args);
	}

}
