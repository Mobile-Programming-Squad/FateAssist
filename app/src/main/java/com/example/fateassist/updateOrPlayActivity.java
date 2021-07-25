package com.example.fateassist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class updateOrPlayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_or_play);

        Button playButton = findViewById(R.id.playButton);
        Button updateButton = findViewById(R.id.updateButton);

        //get intent from MainActivity
        Bundle bundle = getIntent().getExtras();
        Integer  profileChoice;

        playButton.setOnClickListener(playListener);
        updateButton.setOnClickListener(updateListener);

    }

    View.OnClickListener playListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), PlayActivity.class);
            intent.putExtra("profile", 2); //change to name
            startActivity(intent);
        }
    };

    View.OnClickListener updateListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), UpdateCharacter.class);
            intent.putExtra("profile", 2); // change to name
            startActivity(intent);
        }
    };
}