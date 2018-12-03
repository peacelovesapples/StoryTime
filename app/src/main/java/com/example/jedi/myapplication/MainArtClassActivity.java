package com.example.jedi.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainArtClassActivity extends AppCompatActivity {
    ImageView goback;
    ImageView play;
    ImageView watch;

    private String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_art_class);
        goback = (ImageView) findViewById(R.id.goBack);
        play = findViewById(R.id.play);
        watch = findViewById(R.id.watch);

        userName = getIntent().getStringExtra("none");

        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go_back(v);
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play();
            }
        });
        watch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                watch();
            }
        });
    }
    public void go_back(View view) {super.finish();}
    public void play() {
        Intent intent = new Intent(MainArtClassActivity.this, GameChoiceActivity.class );
        intent.putExtra("fileName", "artclass.txt");
        intent.putExtra("none", userName);
        startActivity(intent);
    }

    public void watch() {
        Intent intent = new Intent(MainArtClassActivity.this, GameExplanationActivity.class );
        intent.putExtra("fileName", "artclass.txt");
        intent.putExtra("isWatchMode", true);
        intent.putExtra("none", userName);
        startActivity(intent);
    }
}
