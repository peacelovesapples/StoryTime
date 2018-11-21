package com.example.jedi.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class GameChoiceActivity extends AppCompatActivity {

    ImageView pauseButton;
    TextView descriptionText;
    ImageView descriptionImage;
    TextView optionOneText;
    ImageView optionOneBack;
    TextView optionTwoText;
    ImageView optionTwoBack;

    public Story story;

    private StoryOption optionOne;
    private StoryOption optionTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_choice);

        pauseButton = findViewById(R.id.pause);
        descriptionText = findViewById(R.id.descriptionText);
        descriptionImage = findViewById(R.id.descriptionImage);
        optionOneText = findViewById(R.id.optionOneText);
        optionOneBack = findViewById(R.id.optionOneBack);
        optionTwoText = findViewById(R.id.optionTwoText);
        optionTwoBack = findViewById(R.id.optionTwoBack);

        Intent intent = getIntent();
        String fileName = intent.getStringExtra("fileName");
        story = new Story(fileName);
        updateViews();

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pause();
            }
        });

        optionOneText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedOption(optionOne);
            }
        });

        optionOneBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedOption(optionOne);
            }
        });

        optionTwoText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedOption(optionTwo);
            }
        });

        optionTwoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedOption(optionTwo);
            }
        });
    }

    public void updateViews() {
        if (story.isEnd()) {

        } else {
            optionOne = story.getOptionOne();
            optionOneText.setText(optionOne.text);
            optionTwo = story.getOptionTwo();
            optionTwoText.setText(optionTwo.text);
            descriptionText.setText(story.getDescriptionText());
            // TODO: should also update image
        }
    }

    private void pause() {
        Intent intent = new Intent(GameChoiceActivity.this, PauseActivity.class );
        startActivity(intent);
    }

    private void selectedOption(StoryOption option) {
        if (option.isCorrectChoice) {
            story.nextSequence();
            updateViews();
        }

        Intent intent = new Intent(GameChoiceActivity.this, GameExplanationActivity.class);
        intent.putExtra("fileName", story.fileName);
        intent.putExtra("description", option.explanation);
        intent.putExtra("isEndOfGame", story.isEnd());

        startActivity(intent);
    }
}
