package com.example.cmpbot.views;

import java.util.ArrayList;
import java.util.List;

import com.example.cmpbot.model.response.ChatGPTCompletion;
import com.example.cmpbot.service.OpenAIService;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.grid.GridMultiSelectionModel.SelectAllCheckboxVisibility;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("") 
public class MainView extends VerticalLayout { 
    
  
  private final OpenAIService botService;

  VerticalLayout interactionsList = new VerticalLayout();  
  TextField taskField = new TextField(); 
  Button submitButton = new Button("Submit");
  Select<String> modelSelect = new Select<String>();
  

  public MainView(OpenAIService s) {

    botService = s;
    
    interactionsList.setWidthFull();
    modelSelect.setItems("gpt-4","gpt-3.5-turbo");
  

    submitButton.addClickListener(click -> handleSubmit());
    submitButton.addClickShortcut(Key.ENTER); 

    add( 
      new H1("OpenAI Model Testbench"),
      interactionsList,
      new HorizontalLayout(taskField, modelSelect, submitButton
      )
    );
  }

  public void handleSubmit() {
      ChatGPTCompletion response = botService.askQuestion(taskField.getValue(), modelSelect.getValue());
      Checkbox checkbox = new Checkbox(taskField.getValue());
      TextArea rf = new TextArea();
      TextField mf = new TextField();
      mf.setValue(modelSelect.getValue());
      rf.setValue(response.choices().get(0).getMessage().content());
      HorizontalLayout hl = new HorizontalLayout(checkbox, mf, rf);
      hl.setWidthFull();
      hl.setFlexGrow(1, rf);
      interactionsList.add(hl);
  }
}