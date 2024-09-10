package com.solvd.laba.utils.controllers;

import com.solvd.laba.utils.views.AppendContentView;
import com.solvd.laba.utils.views.FileInputView;
import com.solvd.laba.utils.views.MenuView;
import com.solvd.laba.utils.views.WordMatchesView;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;

public class MainController {
    private MenuView menu = new MenuView();
    private FileInputView menuView = new FileInputView();
    private WordMatchesView wordMatchView = new WordMatchesView();
    private AppendContentView appendContentView = new AppendContentView();
    private File file = null;

    public void displayMenu(){
        menu.display();
        HashMap<String,String> inputs = menu.getInputs();
        int menuOption = Integer.parseInt(inputs.get("menuOption"));

        switch (menuOption){
            case 1 -> switchFile();
            case 2 -> showFileContents();
            case 3 -> appendContents();
            case 4 -> countWordsInsensitive();
            case 5 -> calculateLetters();
            case 6 -> calculateMatches();
            case 7 -> exit();
        }

        System.out.println("\n\n\n\n\n\n\n\n");
        displayMenu();
    }

    public void switchFile(){
        System.out.println("You selected the option 1 - Select a file");
        System.out.println("-----------------------------------------------");
        String pathValue;

        menuView.display();
        pathValue = menuView.getInputs().get("filePath");
        pathValue = StringUtils.strip(pathValue, "\"");

        try{
            File file = FileUtils.getFile(pathValue);
            this.file = file;
        }catch(Exception e){
            e.printStackTrace();
        }

        System.out.println("Current file has changed to " + file.getAbsolutePath());
        System.out.println("-------------------------------------------------------");
    }

    public void showFileContents(){
        System.out.println("You selected the option 2 - Show file contents");
        System.out.println("-----------------------------------------------");

        try{
            String data = FileUtils.readFileToString(file, "UTF-8");
            System.out.println(data);
        }catch(Exception e){
            System.out.println("File contents could not be retrieved. Resetting...");
            displayMenu();
        }
        System.out.println("-----------------------------------------------");
    }

    public void appendContents(){
        System.out.println("You selected the option 3 - Append contents to file");
        System.out.println("---------------------------------------------------------------------------------");

        appendContentView.display();
        String content = appendContentView.getInputs().get("content");

        try(FileOutputStream ostream = FileUtils.openOutputStream(file, true)){
            ostream.write(content.getBytes());
            System.out.println("Contents have been written to the file.");
        }catch(Exception e){
            System.out.println("File contents could not be written. Resetting...");
            displayMenu();
        }

        System.out.println("---------------------------------------------------------------------------------");
    }

    public void countWordsInsensitive(){
        System.out.println("You selected the option 4 - Calculate number of words (case insensitive) in file");
        System.out.println("---------------------------------------------------------------------------------");


        try{
            String data = FileUtils.readFileToString(file, "UTF-8");
            String[] words = StringUtils.split(data);
            words = StringUtils.stripAll(words,",.;[]{}<>?/-_=+()*!@#$%^&*");

            System.out.println("The file " + file.getAbsolutePath() + " has " + words.length + " words");
        }catch(Exception e){
            System.out.println("File contents could not be read. Resetting...");
            displayMenu();
        }

        System.out.println("---------------------------------------------------------------------------------");
    }

    public void calculateLetters(){
        System.out.println("You selected the option 5 - Calculate number of letters in the text");
        System.out.println("---------------------------------------------------------------------------------");


        try{
            String data = FileUtils.readFileToString(file, "UTF-8");
            int count = 0;
            for(char c : data.toCharArray()){
                //Converted chars to Strings with the purpose of using StringUtils
                String tmp = String.valueOf(c);
                if(StringUtils.isAlpha(tmp)){
                    count++;
                }
            }
            System.out.println("The file " + file.getAbsolutePath() + " has " + count + " letters");
        }catch(Exception e){
            System.out.println("File contents could not be read. Resetting...");
            displayMenu();
        }

        System.out.println("---------------------------------------------------------------------------------");
    }

    public void calculateMatches(){
        System.out.println("You selected the option 6 - Calculate word matches");
        System.out.println("---------------------------------------------------------------------------------");

        wordMatchView.display();
        String matchWord = wordMatchView.getInputs().get("word");

        try{
            String data = FileUtils.readFileToString(file, "UTF-8");
            int matches = StringUtils.countMatches(data, matchWord);
            System.out.println("The file " + file.getAbsolutePath() + " has " + matches + " matches for word " + matchWord);
        }catch(Exception e){
            System.out.println("File contents could not be read. Resetting...");
            displayMenu();
        }

        System.out.println("---------------------------------------------------------------------------------");
    }

    public void exit(){
        System.out.println("Shutting off the program...");
        System.exit(0);
    }
}
