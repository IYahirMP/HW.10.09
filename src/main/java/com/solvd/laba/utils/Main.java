package com.solvd.laba.utils;

import java.io.File;
import com.solvd.laba.utils.views.MenuView;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.io.FileUtils;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        String pathValue;

        MenuView menuView = new MenuView();
        menuView.display();
        pathValue = menuView.getInputs().get("filePath");
        pathValue = StringUtils.strip(pathValue, "\"");

        try{
            File file = FileUtils.getFile(pathValue);
            String data = FileUtils.readFileToString(file, "UTF-8");
            String[] words = StringUtils.split(data);
            words = StringUtils.stripAll(words,",.;[]{}<>?/-_=+()*!@#$%^&*");

            int i = 1;
            for(String word : words){
                System.out.println("Word no. " + i++ + ": " + word);
            };
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
