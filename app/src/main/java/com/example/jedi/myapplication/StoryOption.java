package com.example.jedi.myapplication;

public class StoryOption {
    public boolean isCorrectChoice;
    public String text;
    public String explanation;

    public StoryOption(boolean isCorrectChoice, String text, String explanation) {
        this.isCorrectChoice = isCorrectChoice;
        this.text = text;
        this.explanation = explanation;
    }
}
