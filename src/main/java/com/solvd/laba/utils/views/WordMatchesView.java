package com.solvd.laba.utils.views;

import com.solvd.laba.computer_repair_service.input.single_input.StringInput;
import com.solvd.laba.computer_repair_service.views.FeedbackView;
import com.solvd.laba.computer_repair_service.input.single_input.StringInput.TypeOfString;

import java.util.HashMap;

public final class WordMatchesView extends FeedbackView {

    public WordMatchesView(HashMap<String, String> inputs){
        super(inputs);
    }

    public WordMatchesView(){
        super(new HashMap<>());
    }

    public void display(){
        System.out.println("Please, write the word you want to search.");
    }

    public HashMap<String, String> getInputs(){
        StringInput[] stringInputs = {
                new StringInput("word",   "Word", TypeOfString.word),
        };

        processInputs(stringInputs);

        return inputs;
    }

}
