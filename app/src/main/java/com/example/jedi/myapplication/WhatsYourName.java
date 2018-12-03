package com.example.jedi.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class WhatsYourName extends Activity {
    ImageView goback;
    ImageView submit;
    EditText name_input;
    String name;
    public static final String EXTRA_MESSAGE = "none";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whats_your_name);

        goback = (ImageView) findViewById(R.id.goBack);
        submit = (ImageView) findViewById(R.id.submit);
        name_input = (EditText) findViewById(R.id.name);

        name_input.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    next();
                }
                return false;
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
            }
        });



        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go_back(v);
            }
        });
    }
    public void next() {
        name = name_input.getText().toString();
        Intent intent = new Intent(WhatsYourName.this, ChooseActivity.class);
        intent.putExtra(EXTRA_MESSAGE, name);
        System.out.println(name);
        startActivity(intent);



    }
    public void go_back(View view) {super.finish();}

}
