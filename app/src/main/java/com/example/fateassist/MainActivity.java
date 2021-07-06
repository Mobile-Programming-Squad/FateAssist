package com.example.fateassist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CursorAdapter;

public class MainActivity extends AppCompatActivity {

    // main activity buttons
    Button playButton;      // allows you to continue gameplay on any current characters
    Button characterButton; // allows you to modity/add characters to your account
    Button rulesButton;     // takes you to rules pdf

    //adapters for database
    Cursor playerCursor;
    CursorAdapter playerCursorAdapter;

    //This may or may not be useful to you, just know that these should be the options
    //for each skill box
    public enum SkillTypes{
        Athletics,
        Burglary,
        Contacts,
        Crafts,
        Deceive,
        Drive,
        Empathy,
        Fight,
        Investigate,
        Lore,
        Notice,
        Physique,
        Provoke,
        Rapport,
        Resources,
        Shoot,
        Stealth,
        Will,
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playButton = (Button) findViewById(R.id.playButton);
        characterButton = (Button) findViewById(R.id.characterButton);
        rulesButton = (Button) findViewById(R.id.rulesButton);

        characterButton.setOnClickListener(characterListener);
    }

    // onclick listener that takes you to character activity
    View.OnClickListener characterListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, charactersDisplay.class);
            startActivity(intent);
        }
    };
}