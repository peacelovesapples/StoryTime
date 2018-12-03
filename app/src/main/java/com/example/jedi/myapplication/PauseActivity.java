package com.example.jedi.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class PauseActivity extends AppCompatActivity {

    TextView resumeText;
    ImageView resumeBack;
    TextView helpText;
    ImageView helpBack;
    TextView quitText;
    ImageView quitBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pause);

        resumeText = findViewById(R.id.resumeText);
        resumeBack = findViewById(R.id.resumeBack);
        helpText = findViewById(R.id.helpText);
        helpBack = findViewById(R.id.helpBack);
        quitText = findViewById(R.id.quitText);
        quitBack = findViewById(R.id.quitBack);

        resumeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resume(v);
            }
        });

        resumeBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resume(v);
            }
        });

        helpText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                help(v);
            }
        });

        helpBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                help(v);
            }
        });

        quitText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quit(v);
            }
        });

        quitBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quit(v);
            }
        });
    }

    public void resume(View v) {
        this.finish();
    }

    public void help(View v) {

    }

    public void quit(View v) {
        Intent intent = new Intent(PauseActivity.this, MainActivity.class );
        startActivity(intent);
    }
}
