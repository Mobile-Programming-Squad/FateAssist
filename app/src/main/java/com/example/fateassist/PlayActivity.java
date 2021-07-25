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

        TextView nameTextView = findViewById(R.id.nameTextView);
        TextView descriptionTextView = findViewById(R.id.descriptionTextView);
        TextView aspectsTextView = findViewById(R.id.aaspectsTextView);
        TextView stuntsTextView = findViewById(R.id.stuntsTextView);
        TextView extraTextView = findViewById(R.id.extrasTextView);
        TextView c1TextView = findViewById(R.id.c1TextView);
        TextView c2TextView = findViewById(R.id.c2TextView);
        TextView c3TextView = findViewById(R.id.c3TextView);

        DBHelper dbHelper = new DBHelper();


        //get intent from MainActivity
        Bundle bundle = getIntent().getExtras();
        Integer  profileChoice;
        if (bundle != null) {
            profileChoice = bundle.getInt("profile");
            nameTextView.setText("Profile choice: " + profileChoice);
        }

        //pass in the name of the profile here
        String name = "CHAR_NAME";
        Bundle currentValues = DBHelper.GetCharacter(getApplicationContext(), name);

        //name
        String temp = currentValues.getString("CHAR_NAME");
        nameTextView.setText("Name: " + temp);

        //description
        temp = currentValues.getString("DESCRIPTION");
        descriptionTextView.setText("Description: " + temp);

        //Aspects
        temp = currentValues.getString("ASPECTS");
        aspectsTextView.setText("Aspects: " + temp);

        //stunts
        temp = currentValues.getString("STUNTS");
        stuntsTextView.setText("Stunts: " + temp);

        //Extras
        temp = currentValues.getString("EXTRAS");
        extraTextView.setText("Extras: " + temp);

        //Consequence 1
        temp = currentValues.getString("C2");
        c1TextView.setText("Consequence 1: " + temp);

        //Consequence 2
        temp = currentValues.getString("C4");
        c2TextView.setText("Consequence 2: " + temp);

        //Consequence 3
        temp = currentValues.getString("C6");
        c3TextView.setText("Consequence 3: " + temp);


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