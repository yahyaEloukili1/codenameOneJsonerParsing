/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.Task;
import com.mycompany.myapp.services.TaskService;

/**
 *
 * @author T440
 */
public class AddTaskForm extends Form {

    public AddTaskForm(Form prvious) {
        setTitle("Add a new task");
        setLayout(BoxLayout.y());
        TextField tfName = new TextField("","taskName");
        TextField tfStatus =  new TextField("","Status : 0 - 1");
        Button btnValider = new Button("Add task");
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if(tfName.getText().length() == 0 ||tfStatus.getText().length()==0){
                   
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                   
                 
                        
                   
                    
                }
                else{
                     
                    try{
                         
                    Task t = new Task(Integer.parseInt(tfStatus.getText()),tfName.getText());
                     
                   if(new TaskService().addTask(t)){
                       
                       Dialog.show("SUCCESS", "Connection accepted", new Command("OK"));
                   }else{
                       Dialog.show("ERROR", "Server error", new Command("OK"));
                   }
                    }catch(NumberFormatException e){
                         Dialog.show("Alert", "Status must be a number", new Command("OK"));
                    }
                }
               
                
            }
        });
        addAll(tfName,tfStatus,btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> prvious.showBack());
    }
        
}
