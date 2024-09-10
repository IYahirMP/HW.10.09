package com.solvd.laba.utils.views;

import com.solvd.laba.computer_repair_service.input.single_input.StringInput;
import com.solvd.laba.computer_repair_service.views.FeedbackView;
import com.solvd.laba.computer_repair_service.input.single_input.StringInput.TypeOfString;

import java.util.HashMap;

public final class MenuView extends FeedbackView {

    public MenuView(HashMap<String, String> inputs){
        super(inputs);
    }

    public MenuView(){
        super(new HashMap<>());
    }

    public void display(){
        System.out.println("Welcome!");
        System.out.println("Please, input the path to a file.");
    }

    public HashMap<String, String> getInputs(){
        StringInput[] stringInputs = {
                new StringInput("filePath",   "File path", TypeOfString.filePath),
        };

        processInputs(stringInputs);

        return inputs;
    }

}
