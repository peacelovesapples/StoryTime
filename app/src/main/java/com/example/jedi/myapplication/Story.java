package com.example.jedi.myapplication;

import android.media.Image;

import java.io.Serializable;

public class Story implements Serializable {

    public String fileName;
    private boolean isEnd = false; // delete this later.

    public Story(String fileName) {
        this.fileName = fileName;
    }

    public void reset() {
        // TODO: reset the scanner
    }

    public void nextSequence() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd; // check if we've parsed the end of the file.
    }

    public String getDescriptionText() {
        return "When you walk into the dentist, Kevin the receptionist waves at you.";
    }

//    public Image getDescriptionImage() {
//        return new Image();
//    }

    public StoryOption getOptionOne() {
        return new StoryOption(true, "Wave back", "Great job! It's polite to wave back!");
    }

    public StoryOption getOptionTwo() {
        return new StoryOption(false, "Walk away", "Some people might think it's rude if you walk away when they wave. Let's try it again!");
    }
}
