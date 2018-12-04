package com.example.jedi.myapplication;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Handler;

import com.squareup.picasso.Picasso;

public class GameChoiceActivity extends AppCompatActivity {

    ImageView pauseButton;
    TextView descriptionText;
    ImageView descriptionImage;
    TextView optionOneText;
    ImageView optionOneBack;
    TextView optionTwoText;
    ImageView optionTwoBack;
    TextView optionThreeText;
    ImageView optionThreeBack;
    ImageView playSoundButton;
    ImageView des_image;

    public Story story;
    MediaPlayer mp;

    private StoryOption optionOne;
    private StoryOption optionTwo;
    private StoryOption optionThree;
    private String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_choice);

//        des_image = (ImageView) findViewById(R.id.descriptionImage);
 //       Picasso.get().load(R.drawable.receptionistwaving).into(des_image);

        pauseButton = findViewById(R.id.pause);
        descriptionText = findViewById(R.id.descriptionText);
        descriptionImage = findViewById(R.id.descriptionImage);
        optionOneText = findViewById(R.id.optionOneText);
        optionOneBack = findViewById(R.id.optionOneBack);
        optionTwoText = findViewById(R.id.optionTwoText);
        optionTwoBack = findViewById(R.id.optionTwoBack);
        optionThreeText = findViewById(R.id.optionThreeText);
        optionThreeBack = findViewById(R.id.optionThreeBack);
        playSoundButton = findViewById(R.id.playSoundButton);

        Intent intent = getIntent();
        String fileName = intent.getStringExtra("fileName");
        userName = intent.getStringExtra("none");
        story = new Story(this, fileName, userName);
        updateViews();

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pause();
            }
        });

        optionOneText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedOption(optionOne);
            }
        });

        optionOneBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedOption(optionOne);
            }
        });

        optionTwoText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedOption(optionTwo);
            }
        });

        optionTwoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedOption(optionTwo);
            }
        });

        optionThreeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedOption(optionThree);
            }
        });

        optionThreeBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedOption(optionThree);
            }
        });

        playSoundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio();
            }
        });
    }

    public void updateViews() {
        optionOne = story.getOptionOne();
        optionOneText.setText(optionOne.text);
        optionTwo = story.getOptionTwo();
        optionTwoText.setText(optionTwo.text);
        optionThree = story.getOptionThree();
        optionThreeText.setText(optionThree.text);
        descriptionText.setText(story.getDescriptionText());
        int drawableResourceId = this.getResources().getIdentifier(story.descriptionImageName, "drawable", this.getPackageName());
        Picasso.get().load(drawableResourceId).into(descriptionImage);
        //descriptionImage.setImageResource(drawableResourceId);
    }

    private void playAudio() {
        if (story.audioName.equals("dentist1")) {
            mp = MediaPlayer.create(GameChoiceActivity.this, R.raw.dentist1);
        } else if (story.audioName.equals("dentist2")) {
            mp = MediaPlayer.create(GameChoiceActivity.this, R.raw.dentist2);
        } else if (story.audioName.equals("dentist3")) {
            mp = MediaPlayer.create(GameChoiceActivity.this, R.raw.dentist3);
        } else if (story.audioName.equals("dentist4")) {
            mp = MediaPlayer.create(GameChoiceActivity.this, R.raw.dentist4);
        } else if (story.audioName.equals("dentist5")) {
            mp = MediaPlayer.create(GameChoiceActivity.this, R.raw.dentist5);
        } else if (story.audioName.equals("dentist6")) {
            mp = MediaPlayer.create(GameChoiceActivity.this, R.raw.dentist6);
        } else if (story.audioName.equals("dentist7")) {
            mp = MediaPlayer.create(GameChoiceActivity.this, R.raw.dentist7);
        } else if (story.audioName.equals("dentist8")) {
            mp = MediaPlayer.create(GameChoiceActivity.this, R.raw.dentist8);
        } else if (story.audioName.equals("dentist9")) {
            mp = MediaPlayer.create(GameChoiceActivity.this, R.raw.dentist9);
        } else if (story.audioName.equals("dentist10")) {
            mp = MediaPlayer.create(GameChoiceActivity.this, R.raw.dentist10);
        } else if (story.audioName.equals("dentist11")) {
            mp = MediaPlayer.create(GameChoiceActivity.this, R.raw.dentist11);
        } else if (story.audioName.equals("dentist12")) {
            mp = MediaPlayer.create(GameChoiceActivity.this, R.raw.dentist12);
        } else if (story.audioName.equals("artclass1")) {
            mp = MediaPlayer.create(GameChoiceActivity.this, R.raw.artclass1);
        } else if (story.audioName.equals("artclass2")) {
            mp = MediaPlayer.create(GameChoiceActivity.this, R.raw.artclass2);
        } else if (story.audioName.equals("artclass3")) {
            mp = MediaPlayer.create(GameChoiceActivity.this, R.raw.artclass3);
        } else if (story.audioName.equals("artclass4")) {
            mp = MediaPlayer.create(GameChoiceActivity.this, R.raw.artclass4);
        } else if (story.audioName.equals("artclass5")) {
            mp = MediaPlayer.create(GameChoiceActivity.this, R.raw.artclass5);
        } else if (story.audioName.equals("artclass6")) {
            mp = MediaPlayer.create(GameChoiceActivity.this, R.raw.artclass6);
        } else if (story.audioName.equals("artclass7")) {
            mp = MediaPlayer.create(GameChoiceActivity.this, R.raw.artclass7);
        } else if (story.audioName.equals("artclass8")) {
            mp = MediaPlayer.create(GameChoiceActivity.this, R.raw.artclass8);
        } else if (story.audioName.equals("artclass9")) {
            mp = MediaPlayer.create(GameChoiceActivity.this, R.raw.artclass9);
        } else if (story.audioName.equals("artclass10")) {
            mp = MediaPlayer.create(GameChoiceActivity.this, R.raw.artclass10);
        } else if (story.audioName.equals("artclass11")) {
            mp = MediaPlayer.create(GameChoiceActivity.this, R.raw.artclass11);
        } else if (story.audioName.equals("artclass12")) {
            mp = MediaPlayer.create(GameChoiceActivity.this, R.raw.artclass12);
        } else if (story.audioName.equals("lunchtime1")) {
            mp = MediaPlayer.create(GameChoiceActivity.this, R.raw.lunchtime1);
        } else if (story.audioName.equals("lunchtime2")) {
            mp = MediaPlayer.create(GameChoiceActivity.this, R.raw.lunchtime2);
        } else if (story.audioName.equals("lunchtime3")) {
            mp = MediaPlayer.create(GameChoiceActivity.this, R.raw.lunchtime3);
        } else if (story.audioName.equals("lunchtime4")) {
            mp = MediaPlayer.create(GameChoiceActivity.this, R.raw.lunchtime4);
        } else if (story.audioName.equals("lunchtime5")) {
            mp = MediaPlayer.create(GameChoiceActivity.this, R.raw.lunchtime5);
        } else if (story.audioName.equals("lunchtime6")) {
            mp = MediaPlayer.create(GameChoiceActivity.this, R.raw.lunchtime6);
        } else if (story.audioName.equals("lunchtime7")) {
            mp = MediaPlayer.create(GameChoiceActivity.this, R.raw.lunchtime7);
        } else if (story.audioName.equals("lunchtime8")) {
            mp = MediaPlayer.create(GameChoiceActivity.this, R.raw.lunchtime8);
        } else if (story.audioName.equals("lunchtime9")) {
            mp = MediaPlayer.create(GameChoiceActivity.this, R.raw.lunchtime9);
        } else if (story.audioName.equals("lunchtime10")) {
            mp = MediaPlayer.create(GameChoiceActivity.this, R.raw.lunchtime10);
        } else if (story.audioName.equals("lunchtime11")) {
            mp = MediaPlayer.create(GameChoiceActivity.this, R.raw.lunchtime11);
        } else if (story.audioName.equals("lunchtime12")) {
            mp = MediaPlayer.create(GameChoiceActivity.this, R.raw.lunchtime12);
        } else if (story.audioName.equals("recess1")) {
            mp = MediaPlayer.create(GameChoiceActivity.this, R.raw.recess1);
        } else if (story.audioName.equals("recess2")) {
            mp = MediaPlayer.create(GameChoiceActivity.this, R.raw.recess2);
        } else if (story.audioName.equals("recess3")) {
            mp = MediaPlayer.create(GameChoiceActivity.this, R.raw.recess3);
        } else if (story.audioName.equals("recess4")) {
            mp = MediaPlayer.create(GameChoiceActivity.this, R.raw.recess4);
        } else if (story.audioName.equals("recess5")) {
            mp = MediaPlayer.create(GameChoiceActivity.this, R.raw.recess5);
        } else if (story.audioName.equals("recess6")) {
            mp = MediaPlayer.create(GameChoiceActivity.this, R.raw.recess6);
        } else if (story.audioName.equals("recess7")) {
            mp = MediaPlayer.create(GameChoiceActivity.this, R.raw.recess7);
        } else if (story.audioName.equals("recess8")) {
            mp = MediaPlayer.create(GameChoiceActivity.this, R.raw.recess8);
        } else if (story.audioName.equals("recess9")) {
            mp = MediaPlayer.create(GameChoiceActivity.this, R.raw.recess9);
        } else if (story.audioName.equals("recess10")) {
            mp = MediaPlayer.create(GameChoiceActivity.this, R.raw.recess10);
        } else if (story.audioName.equals("recess11")) {
            mp = MediaPlayer.create(GameChoiceActivity.this, R.raw.recess11);
        } else if (story.audioName.equals("recess12")) {
            mp = MediaPlayer.create(GameChoiceActivity.this, R.raw.recess12);
        } else {
            mp = MediaPlayer.create(GameChoiceActivity.this, R.raw.test);
        }
        int duration = mp.getDuration();
        playSoundButton.setVisibility(View.GONE);
        mp.start();

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                playSoundButton.setVisibility(View.VISIBLE);
            }
        }, duration);

    }

    private void pause() {
        Intent intent = new Intent(GameChoiceActivity.this, PauseActivity.class );
        startActivity(intent);
    }

    private void selectedOption(StoryOption option) {
        if (mp != null) {
            mp.stop();
        }
        if (option.isCorrectChoice) {
            story.nextSequence();
            updateViews();
        }

        Intent intent = new Intent(GameChoiceActivity.this, GameExplanationActivity.class);
        intent.putExtra("fileName", story.fileName);
        intent.putExtra("description", option.explanation);
        intent.putExtra("isEndOfGame", story.isEnd());
        intent.putExtra("isCorrectChoice", option.isCorrectChoice);
        intent.putExtra("optionAudio", option.audioName);

        startActivity(intent);
    }
}
