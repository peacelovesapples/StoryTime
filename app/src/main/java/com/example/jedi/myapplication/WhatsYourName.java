package com.example.jedi.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class WhatsYourName extends AppCompatActivity {
    ImageView goback;
    ImageView submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whats_your_name);

        goback = (ImageView) findViewById(R.id.goBack);
        submit = (ImageView) findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WhatsYourName.this, ChooseActivity.class);
                startActivity(intent);
            }
        });

        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go_back(v);
            }
        });
    }
    public void go_back(View view) {super.finish();}
}
