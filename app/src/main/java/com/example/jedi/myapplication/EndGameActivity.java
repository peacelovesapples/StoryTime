package com.example.jedi.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class EndGameActivity extends Activity {

    ImageView homeBack;
    TextView homeText;
    ImageView replayBack;
    TextView replayText;
    ImageView creditsBack;
    TextView creditsText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);

        homeBack = findViewById(R.id.homeBack);
        homeText = findViewById(R.id.homeText);
        replayBack = findViewById(R.id.replayBack);
        replayText = findViewById(R.id.replayText);
        creditsBack = findViewById(R.id.creditsBack);
        creditsText = findViewById(R.id.creditsText);

        homeBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home();
            }
        });

        homeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home();
            }
        });

        replayBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replay();
            }
        });

        replayText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replay();
            }
        });

        creditsBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                credits();
            }
        });

        creditsText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                credits();
            }
        });

    }

    private void home() {
        Intent intent = new Intent(EndGameActivity.this, MainActivity.class);
        startActivity(intent);
    }

    private void replay() {
        Intent intent = getIntent();
        String fileName = intent.getStringExtra("fileName");

        intent = new Intent(EndGameActivity.this, GameChoiceActivity.class);
        intent.putExtra("fileName", fileName);
        startActivity(intent);
    }

    private void credits() {

    }
}