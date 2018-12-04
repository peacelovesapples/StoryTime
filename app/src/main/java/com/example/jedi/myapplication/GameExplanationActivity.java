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

import com.squareup.picasso.Picasso;

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
    String audioName;
    MediaPlayer mp;
    String userName;
    ImageView explain_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_explanation);
        explain_image = (ImageView) findViewById(R.id.imageView4);
        Picasso.get().load(R.drawable.explaining).into(explain_image);


        pauseButton = findViewById(R.id.pause);
        descriptionText = findViewById(R.id.descriptionText);
        descriptionImage = findViewById(R.id.descriptionImage);
        actionBack = findViewById(R.id.actionBack);
        actionText = findViewById(R.id.actionText);
        playAudioButton = findViewById(R.id.playAudio);

        isWatchMode = getIntent().getBooleanExtra("isWatchMode", false);
        isEndOfGame = getIntent().getBooleanExtra("isEndOfGame", false);
        isCorrectChoice = getIntent().getBooleanExtra("isCorrectChoice", false);
        audioName = getIntent().getStringExtra("optionAudio");
        fileName = getIntent().getStringExtra("fileName");
        userName = getIntent().getStringExtra("none");
        if (isWatchMode) {
            story = new Story(this, fileName, userName);
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
        if (audioName.equals("dentist1")) {
            mp = MediaPlayer.create(GameExplanationActivity.this, R.raw.dentist1);
        } else if (audioName.equals("dentist2")) {
            mp = MediaPlayer.create(GameExplanationActivity.this, R.raw.dentist2);
        } else if (audioName.equals("dentist3")) {
            mp = MediaPlayer.create(GameExplanationActivity.this, R.raw.dentist3);
        } else if (audioName.equals("dentist4")) {
            mp = MediaPlayer.create(GameExplanationActivity.this, R.raw.dentist4);
        } else if (audioName.equals("dentist5")) {
            mp = MediaPlayer.create(GameExplanationActivity.this, R.raw.dentist5);
        } else if (audioName.equals("dentist6")) {
            mp = MediaPlayer.create(GameExplanationActivity.this, R.raw.dentist6);
        } else if (audioName.equals("dentist7")) {
            mp = MediaPlayer.create(GameExplanationActivity.this, R.raw.dentist7);
        } else if (audioName.equals("dentist8")) {
            mp = MediaPlayer.create(GameExplanationActivity.this, R.raw.dentist8);
        } else if (audioName.equals("dentist9")) {
            mp = MediaPlayer.create(GameExplanationActivity.this, R.raw.dentist9);
        } else if (audioName.equals("dentist10")) {
            mp = MediaPlayer.create(GameExplanationActivity.this, R.raw.dentist10);
        } else if (audioName.equals("dentist11")) {
            mp = MediaPlayer.create(GameExplanationActivity.this, R.raw.dentist11);
        } else if (audioName.equals("dentist12")) {
            mp = MediaPlayer.create(GameExplanationActivity.this, R.raw.dentist12);
        } else if (audioName.equals("artclass1")) {
            mp = MediaPlayer.create(GameExplanationActivity.this, R.raw.artclass1);
        } else if (audioName.equals("artclass2")) {
            mp = MediaPlayer.create(GameExplanationActivity.this, R.raw.artclass2);
        } else if (audioName.equals("artclass3")) {
            mp = MediaPlayer.create(GameExplanationActivity.this, R.raw.artclass3);
        } else if (audioName.equals("artclass4")) {
            mp = MediaPlayer.create(GameExplanationActivity.this, R.raw.artclass4);
        } else if (audioName.equals("artclass5")) {
            mp = MediaPlayer.create(GameExplanationActivity.this, R.raw.artclass5);
        } else if (audioName.equals("artclass6")) {
            mp = MediaPlayer.create(GameExplanationActivity.this, R.raw.artclass6);
        } else if (audioName.equals("artclass7")) {
            mp = MediaPlayer.create(GameExplanationActivity.this, R.raw.artclass7);
        } else if (audioName.equals("artclass8")) {
            mp = MediaPlayer.create(GameExplanationActivity.this, R.raw.artclass8);
        } else if (audioName.equals("artclass9")) {
            mp = MediaPlayer.create(GameExplanationActivity.this, R.raw.artclass9);
        } else if (audioName.equals("artclass10")) {
            mp = MediaPlayer.create(GameExplanationActivity.this, R.raw.artclass10);
        } else if (audioName.equals("artclass11")) {
            mp = MediaPlayer.create(GameExplanationActivity.this, R.raw.artclass11);
        } else if (audioName.equals("artclass12")) {
            mp = MediaPlayer.create(GameExplanationActivity.this, R.raw.artclass12);
        } else if (audioName.equals("lunchtime1")) {
            mp = MediaPlayer.create(GameExplanationActivity.this, R.raw.lunchtime1);
        } else if (audioName.equals("lunchtime2")) {
            mp = MediaPlayer.create(GameExplanationActivity.this, R.raw.lunchtime2);
        } else if (audioName.equals("lunchtime3")) {
            mp = MediaPlayer.create(GameExplanationActivity.this, R.raw.lunchtime3);
        } else if (audioName.equals("lunchtime4")) {
            mp = MediaPlayer.create(GameExplanationActivity.this, R.raw.lunchtime4);
        } else if (audioName.equals("lunchtime5")) {
            mp = MediaPlayer.create(GameExplanationActivity.this, R.raw.lunchtime5);
        } else if (audioName.equals("lunchtime6")) {
            mp = MediaPlayer.create(GameExplanationActivity.this, R.raw.lunchtime6);
        } else if (audioName.equals("lunchtime7")) {
            mp = MediaPlayer.create(GameExplanationActivity.this, R.raw.lunchtime7);
        } else if (audioName.equals("lunchtime8")) {
            mp = MediaPlayer.create(GameExplanationActivity.this, R.raw.lunchtime8);
        } else if (audioName.equals("lunchtime9")) {
            mp = MediaPlayer.create(GameExplanationActivity.this, R.raw.lunchtime9);
        } else if (audioName.equals("lunchtime10")) {
            mp = MediaPlayer.create(GameExplanationActivity.this, R.raw.lunchtime10);
        } else if (audioName.equals("lunchtime11")) {
            mp = MediaPlayer.create(GameExplanationActivity.this, R.raw.lunchtime11);
        } else if (audioName.equals("lunchtime12")) {
            mp = MediaPlayer.create(GameExplanationActivity.this, R.raw.lunchtime12);
        } else if (audioName.equals("recess1")) {
            mp = MediaPlayer.create(GameExplanationActivity.this, R.raw.recess1);
        } else if (audioName.equals("recess2")) {
            mp = MediaPlayer.create(GameExplanationActivity.this, R.raw.recess2);
        } else if (audioName.equals("recess3")) {
            mp = MediaPlayer.create(GameExplanationActivity.this, R.raw.recess3);
        } else if (audioName.equals("recess4")) {
            mp = MediaPlayer.create(GameExplanationActivity.this, R.raw.recess4);
        } else if (audioName.equals("recess5")) {
            mp = MediaPlayer.create(GameExplanationActivity.this, R.raw.recess5);
        } else if (audioName.equals("recess6")) {
            mp = MediaPlayer.create(GameExplanationActivity.this, R.raw.recess6);
        } else if (audioName.equals("recess7")) {
            mp = MediaPlayer.create(GameExplanationActivity.this, R.raw.recess7);
        } else if (audioName.equals("recess8")) {
            mp = MediaPlayer.create(GameExplanationActivity.this, R.raw.recess8);
        } else if (audioName.equals("recess9")) {
            mp = MediaPlayer.create(GameExplanationActivity.this, R.raw.recess9);
        } else if (audioName.equals("recess10")) {
            mp = MediaPlayer.create(GameExplanationActivity.this, R.raw.recess10);
        } else if (audioName.equals("recess11")) {
            mp = MediaPlayer.create(GameExplanationActivity.this, R.raw.recess11);
        } else if (audioName.equals("recess12")) {
            mp = MediaPlayer.create(GameExplanationActivity.this, R.raw.recess12);
        } else {
            mp = MediaPlayer.create(GameExplanationActivity.this, R.raw.test);
        }
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
        if (mp != null) {
            mp.stop();
        }
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
            audioName = story.audioName;
            description = description.replace("What do you do?", "");
            description = description.replace("What do you say?", "");
            descriptionText.setText(description);
        } else {
            String answer = story.getCorrectAnswer().explanation;
            audioName = story.getCorrectAnswer().audioName;
            answer = answer.replace("Perfect! ", "");
            descriptionText.setText(answer);
        }
    }

    private void pause() {
        Intent intent = new Intent(GameExplanationActivity.this, PauseActivity.class );
        startActivity(intent);
    }

    private void actionForNormalMode() {
        if (mp != null) {
            mp.stop();
        }
        if (isEndOfGame && isCorrectChoice) {
            Intent intent = new Intent(GameExplanationActivity.this, EndGameActivity.class );
            intent.putExtra("fileName", fileName);
            startActivity(intent);
        } else {
            this.finish();
        }
    }
}
