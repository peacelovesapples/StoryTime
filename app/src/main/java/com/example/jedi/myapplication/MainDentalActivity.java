package com.example.jedi.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainDentalActivity extends Activity {
    ImageView goback;
    ImageView play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dental);
        goback = (ImageView) findViewById(R.id.go_back_dental);
        play = findViewById(R.id.play);

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
    }
    public void go_back(View view) {super.finish();}
    public void play() {
        Intent intent = new Intent(MainDentalActivity.this, GameChoiceActivity.class );
        intent.putExtra("fileName", "dentist.txt");
        startActivity(intent);
    }
}
