package com.example.fateassist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Random;

public class PlayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        Button backButton = findViewById(R.id.backButton);
        Button rollButton = (Button) findViewById(R.id.rollButton);
        Spinner diceSpinner = findViewById(R.id.diceSpinner);
        TextView rolledTextView = findViewById(R.id.rolledTextView);

        Integer[] diceArray = {20, 12, 10, 8, 6, 4};
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_dropdown_item, diceArray);
        diceSpinner.setAdapter(adapter);

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spinner diceSpinner = findViewById(R.id.diceSpinner);
                TextView rolledTextView = findViewById(R.id.rolledTextView);
                Random rand = new Random();

                Integer currentValue = (Integer) diceSpinner.getSelectedItem();
                Integer finalRoll = rand.nextInt(currentValue) + 1;
                String finalRollString = (finalRoll).toString();
                rolledTextView.setText("You rolled a: " + finalRollString);
            }
        });
      }



}