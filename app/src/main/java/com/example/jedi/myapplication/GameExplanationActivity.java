package com.example.jedi.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Environment;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

public class GameExplanationActivity extends AppCompatActivity {
    ImageView pauseButton;
    ImageView descriptionImage;
    TextView descriptionText;
    ImageView actionBack;
    TextView actionText;
    ImageView playAudioButton;

    boolean isWatchMode; // if this is on, we only ever update this page.
    boolean isDescription;
    Story story;

    boolean isEndOfGame;
    boolean isCorrectChoice;
    String fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_explanation);

        pauseButton = findViewById(R.id.pause);
        descriptionText = findViewById(R.id.descriptionText);
        descriptionImage = findViewById(R.id.descriptionImage);
        actionBack = findViewById(R.id.actionBack);
        actionText = findViewById(R.id.actionText);
        playAudioButton = findViewById(R.id.playAudio);

        isWatchMode = getIntent().getBooleanExtra("isWatchMode", false);
        isEndOfGame = getIntent().getBooleanExtra("isEndOfGame", false);
        isCorrectChoice = getIntent().getBooleanExtra("isCorrectChoice", false);
        fileName = getIntent().getStringExtra("fileName");
        if (isWatchMode) {
            story = new Story(this, fileName);
            isDescription = true;
            String description = story.getDescriptionText();
            description = description.replace("What do you do?", "");
            description = description.replace("What do you say?", "");
            descriptionText.setText(description);
        } else {
            descriptionText.setText(getIntent().getStringExtra("description"));
        }

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pause();
            }
        });

        actionBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isWatchMode) {
                    actionForWatchMode();
                } else {
                    actionForNormalMode();
                }
            }
        });

        actionText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isWatchMode) {
                    actionForWatchMode();
                } else {
                    actionForNormalMode();
                }
            }
        });

        playAudioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio();
            }
        });

       // kid.setIm
        File sdCardDirectory = Environment.getExternalStorageDirectory();
        File new_image = new File(sdCardDirectory, "selected.png");
        if (new_image.exists()) {
            ImageView kid = findViewById(R.id.imageView4);
            kid.setImageBitmap(BitmapFactory.decodeFile(new_image.getAbsolutePath()));

        }
    }

    private void playAudio() {
        MediaPlayer mp = MediaPlayer.create(GameExplanationActivity.this, R.raw.test);
        int duration = mp.getDuration();
        playAudioButton.setVisibility(View.GONE);
        mp.start();

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                playAudioButton.setVisibility(View.VISIBLE);
            }
        }, duration);
    }

    private void load_pic() {

    }

    private void actionForWatchMode() {
        if (!isDescription) {
            story.nextSequence();
        }
        if (story.isEnd() && !isDescription) {
            Intent intent = new Intent(GameExplanationActivity.this, EndGameActivity.class );
            intent.putExtra("fileName", fileName);
            startActivity(intent);
            return;
        }

        isDescription = !isDescription;

        if (isDescription) {
            String description = story.getDescriptionText();
            description = description.replace("What do you do?", "");
            description = description.replace("What do you say?", "");
            descriptionText.setText(description);
        } else {
            String answer = story.getCorrectAnswer().explanation;
            answer = answer.replace("Perfect! ", "");
            descriptionText.setText(answer);
        }
    }

    private void pause() {
        Intent intent = new Intent(GameExplanationActivity.this, PauseActivity.class );
        startActivity(intent);
    }

    private void actionForNormalMode() {
        if (isEndOfGame && isCorrectChoice) {
            Intent intent = new Intent(GameExplanationActivity.this, EndGameActivity.class );
            intent.putExtra("fileName", fileName);
            startActivity(intent);
        } else {
            this.finish();
        }
    }
}
