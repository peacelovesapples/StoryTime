package com.example.jedi.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
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

        isEndOfGame = getIntent().getBooleanExtra("isEndOfGame", false);
        isCorrectChoice = getIntent().getBooleanExtra("isCorrectChoice", false);
        fileName = getIntent().getStringExtra("fileName");

        descriptionText.setText(getIntent().getStringExtra("description"));

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pause();
            }
        });

        actionBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action();
            }
        });

        actionText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action();
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
    private void load_pic() {

    }

    private void pause() {
        Intent intent = new Intent(GameExplanationActivity.this, PauseActivity.class );
        startActivity(intent);
    }

    private void action() {
        if (isEndOfGame && isCorrectChoice) {
            Intent intent = new Intent(GameExplanationActivity.this, EndGameActivity.class );
            intent.putExtra("fileName", fileName);
            startActivity(intent);
        } else {
            this.finish();
        }
    }
}