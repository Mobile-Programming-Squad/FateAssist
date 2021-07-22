package com.example.fateassist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Random;

public class PlayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        Button backButton = findViewById(R.id.backButton);//might not use since android already has one built in
        Button rollButton = (Button) findViewById(R.id.rollButton);
        Spinner diceSpinner = findViewById(R.id.diceSpinner);
        TextView rolledTextView = findViewById(R.id.rolledTextView);
        CheckBox psBox1 = findViewById(R.id.physicalStressBox1);
        CheckBox psBox2 = findViewById(R.id.physicalStressBox2);
        CheckBox psBox3 = findViewById(R.id.physicalStressBox2);
        CheckBox psBox4 = findViewById(R.id.physicalStressBox4);
        CheckBox msBox1 = findViewById(R.id.mentalStressBox1);
        CheckBox msBox2 = findViewById(R.id.mentalStressBox2);
        CheckBox msBox3 = findViewById(R.id.mentalStressBox3);
        CheckBox msBox4 = findViewById(R.id.mentalStressBox4);


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