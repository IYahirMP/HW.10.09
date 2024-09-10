package com.solvd.laba.utils.views;

import com.solvd.laba.computer_repair_service.input.single_input.StringInput;
import com.solvd.laba.computer_repair_service.views.FeedbackView;
import com.solvd.laba.computer_repair_service.input.single_input.StringInput.TypeOfString;

import java.util.HashMap;

public final class AppendContentView extends FeedbackView {

    public AppendContentView(HashMap<String, String> inputs){
        super(inputs);
    }

    public AppendContentView(){
        super(new HashMap<>());
    }

    public void display(){
        System.out.println("Please, write the contents you want to write to the file.");
    }

    public HashMap<String, String> getInputs(){
        StringInput[] stringInputs = {
                new StringInput("content",   "Content", TypeOfString.none),
        };

        processInputs(stringInputs);

        return inputs;
    }

}
