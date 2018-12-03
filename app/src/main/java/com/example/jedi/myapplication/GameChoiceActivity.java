package com.example.jedi.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Handler;

public class GameChoiceActivity extends AppCompatActivity {

    ImageView pauseButton;
    TextView descriptionText;
    ImageView descriptionImage;
    TextView optionOneText;
    ImageView optionOneBack;
    TextView optionTwoText;
    ImageView optionTwoBack;
    TextView optionThreeText;
    ImageView optionThreeBack;
    ImageView playSoundButton;

    public Story story;

    private StoryOption optionOne;
    private StoryOption optionTwo;
    private StoryOption optionThree;

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
        optionThreeText = findViewById(R.id.optionThreeText);
        optionThreeBack = findViewById(R.id.optionThreeBack);
        playSoundButton = findViewById(R.id.playSoundButton);

        Intent intent = getIntent();
        String fileName = intent.getStringExtra("fileName");
        story = new Story(this, fileName);
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

        optionThreeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedOption(optionThree);
            }
        });

        optionThreeBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedOption(optionThree);
            }
        });

        playSoundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio();
            }
        });
    }

    public void updateViews() {
        optionOne = story.getOptionOne();
        optionOneText.setText(optionOne.text);
        optionTwo = story.getOptionTwo();
        optionTwoText.setText(optionTwo.text);
        optionThree = story.getOptionThree();
        optionThreeText.setText(optionThree.text);
        descriptionText.setText(story.getDescriptionText());
        // TODO: should also update image
    }

    private void playAudio() {
        MediaPlayer mp = MediaPlayer.create(GameChoiceActivity.this, R.raw.test);
        int duration = mp.getDuration();
        playSoundButton.setVisibility(View.GONE);
        mp.start();

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                playSoundButton.setVisibility(View.VISIBLE);
            }
        }, duration);

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
        intent.putExtra("isCorrectChoice", option.isCorrectChoice);

        startActivity(intent);
    }
}
