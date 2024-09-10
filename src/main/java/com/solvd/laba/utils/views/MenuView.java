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
        System.out.println("Please, select one option:");
        System.out.println("1 - Select a file");
        System.out.println("2 - Show file contents");
        System.out.println("3 - Append contents to file");
        System.out.println("4 - Count number of words (case insensitive) in file");
        System.out.println("5 - Calculate number of letters in the text");
        System.out.println("6 - Calculate word matches");
        System.out.println("7 - Exit");
    }

    public HashMap<String, String> getInputs(){
        StringInput[] stringInputs = {
                new StringInput("menuOption",   "Option", TypeOfString.number),
        };

        processInputs(stringInputs);

        int val = Integer.parseInt(inputs.get("menuOption"));
        if (val < 1 || val > 7){
            System.out.println("Option is not valid, please try again.");
            getInputs();
        };
        return inputs;
    }

}
