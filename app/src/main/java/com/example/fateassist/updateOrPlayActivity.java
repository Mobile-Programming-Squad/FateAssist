package com.example.fateassist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class updateOrPlayActivity extends AppCompatActivity {

    int profileNum =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_or_play);

        Button playButton = findViewById(R.id.playButton);
        Button updateButton = findViewById(R.id.updateButton);

        //get intent from MainActivity
        playButton.setOnClickListener(playListener);
        updateButton.setOnClickListener(updateListener);

        //getting
        Intent intent = getIntent();
        profileNum = intent.getIntExtra("profile", 1);


    }

    View.OnClickListener playListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            //sending
            Intent intent = new Intent(updateOrPlayActivity.this, PlayActivity.class);
            intent.putExtra("profile", profileNum);

            startActivity(intent);

        }
    };

    View.OnClickListener updateListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //sending
            Intent intent = new Intent(updateOrPlayActivity.this, UpdateCharacter.class);
            intent.putExtra("profile", profileNum);

            startActivity(intent);
        }
    };
}