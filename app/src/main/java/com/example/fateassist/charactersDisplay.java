package com.example.fateassist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class charactersDisplay extends AppCompatActivity {
    // buttons that you can click on to add a new character or view/change character profiles
    ImageButton character1Button;
    ImageButton character2Button;
    ImageButton character3Button;
    ImageButton character4Button;
    ImageButton character5Button;
    ImageButton character6Button;

    // text under buttons that will change to the character's name once a character has been added
    TextView character1Label;
    TextView character2Label;
    TextView character3Label;
    TextView character4Label;
    TextView character5Label;
    TextView character6Label;

    // back button to go to MainActivity
    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_characters_display);
        character1Button = (ImageButton) findViewById(R.id.character1Button);
        character2Button = (ImageButton) findViewById(R.id.character2Button);
        character3Button = (ImageButton) findViewById(R.id.character3Button);
        character4Button = (ImageButton) findViewById(R.id.character4Button);
        character5Button = (ImageButton) findViewById(R.id.character5Button);
        character6Button = (ImageButton) findViewById(R.id.character6Button);

        character1Label = (TextView) findViewById(R.id.character1Label);
        character2Label = (TextView) findViewById(R.id.character2Label);
        character3Label = (TextView) findViewById(R.id.character3Label);
        character4Label = (TextView) findViewById(R.id.character4Label);
        character5Label = (TextView) findViewById(R.id.character5Label);
        character6Label = (TextView) findViewById(R.id.character6Label);

        backButton = (Button) findViewById(R.id.backButton);

        backButton.setOnClickListener(backListener);

    }

    View.OnClickListener backListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(charactersDisplay.this, MainActivity.class);
            startActivity(intent);
        }
    };
}