package com.example.jedi.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ChooseActivity extends Activity {
    ImageView goback;
    LinearLayout dental_choice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        goback = (ImageView) findViewById(R.id.go_back_choose);

        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go_back(v);
            }
        });
        dental_choice = (LinearLayout) findViewById(R.id.dental_choice);

        dental_choice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseActivity.this, MainDentalActivity.class );
                startActivity(intent);
            }
        });
    }
    public void go_back(View view) {super.finish();}
}
