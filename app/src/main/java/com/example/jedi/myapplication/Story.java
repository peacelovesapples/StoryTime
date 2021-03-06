package com.example.jedi.myapplication;

import android.content.Context;
import android.media.Image;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Story implements Serializable {

    Scanner scanner;
    public String fileName;
    private String userName;
    public String descriptionImageName;
    public String audioName;

    String description;
    ArrayList<StoryOption> options;
    boolean endOfGameFlag = false;

    public Story(Context context, String fileName, String userName) {
        this.fileName = fileName;
        this.userName = userName;

        try {
            DataInputStream textFileStream = new DataInputStream(context.getAssets().open(fileName));
            scanner = new Scanner(textFileStream);
        } catch (IOException e) {
            scanner = null;
        }
        nextSequence();
    }

    public void nextSequence() {
        if (isEnd()) {
            return;
        }

        descriptionImageName = scanner.nextLine();
        description = scanner.nextLine();
        if (description.contains("_name_") && userName != null) {
            description = description.replace("_name_", userName);
        }
        audioName = scanner.nextLine();
        options = new ArrayList<StoryOption>(3);
        options.add(new StoryOption(true, scanner.nextLine(), scanner.nextLine(), scanner.nextLine()));
        options.add(new StoryOption(false, scanner.nextLine(), scanner.nextLine(), scanner.nextLine()));
        options.add(new StoryOption(false, scanner.nextLine(), scanner.nextLine(), scanner.nextLine()));

        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }

        Collections.shuffle(options);
    }

    public StoryOption getCorrectAnswer() {
        for (StoryOption option : options) {
            if (option.isCorrectChoice) {
                return option;
            }
        }
        return null;
    }

    public boolean isEnd() {
        if (!scanner.hasNextLine()) {
            boolean retVal = endOfGameFlag;
            endOfGameFlag = true;
            return retVal;
        }
        return false;
    }

    public String getDescriptionText() {
        return description;
    }

//    public Image getDescriptionImage() {
//        return new Image();
//    }

    public StoryOption getOptionOne() {
        return options.get(0);
    }

    public StoryOption getOptionTwo() {
        return options.get(1);
    }

    public StoryOption getOptionThree() {
        return options.get(2);
    }
}
