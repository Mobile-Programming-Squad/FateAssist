package com.example.fateassist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Random;

import static com.example.fateassist.MainActivity.PREFS_NAME;

public class PlayActivity extends AppCompatActivity {
    String name = "";

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

        TextView S1 = findViewById(R.id.S1);
        TextView S2 = findViewById(R.id.S2);
        TextView S3 = findViewById(R.id.S3);
        TextView S4 = findViewById(R.id.S4);
        TextView S5 = findViewById(R.id.S5);
        TextView GR1 = findViewById(R.id.GR1);
        TextView GR2 = findViewById(R.id.GR2);
        TextView GR3 = findViewById(R.id.GR3);
        TextView GR4 = findViewById(R.id.GR4);
        TextView GR5 = findViewById(R.id.GR5);
        TextView GO1 = findViewById(R.id.GO1);
        TextView GO2 = findViewById(R.id.GO2);
        TextView GO3 = findViewById(R.id.GO3);
        TextView GO4 = findViewById(R.id.GO4);
        TextView GO5 = findViewById(R.id.GO5);
        TextView F1 = findViewById(R.id.F1);
        TextView F2 = findViewById(R.id.F2);
        TextView F3 = findViewById(R.id.F3);
        TextView F4 = findViewById(R.id.F4);
        TextView F5 = findViewById(R.id.F5);
        TextView A1 = findViewById(R.id.A1);
        TextView A2 = findViewById(R.id.A2);
        TextView A3 = findViewById(R.id.A3);
        TextView A4 = findViewById(R.id.A4);
        TextView A5 = findViewById(R.id.A5);
        TextView fatePointsBox = findViewById(R.id.fatePointsBox);



        //pass in the name of the profile here;
        SharedPreferences profiles = getSharedPreferences(PREFS_NAME, 0);


        Intent intent = getIntent();
        int profileNum = intent.getIntExtra("profile", 1);
        switch (profileNum){
            case 1:
                name = profiles.getString("profile1",null);
                break;
            case 2:
                name = profiles.getString("profile2",null);
                break;
            case 3:
                name = profiles.getString("profile3",null);
                break;
            case 4:
                name = profiles.getString("profile4",null);
                break;
            case 5:
                name = profiles.getString("profile5",null);
                break;
            case 6:
                name = profiles.getString("profile6",null);
                break;
        }

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


        //Skills//
        //superb
        temp = currentValues.getString("SU1");
        if(temp != null)
            S1.setText(temp);

        temp = currentValues.getString("SU2");
        if(temp != null)
            S2.setText(temp);

        temp = currentValues.getString("SU3");
        if(temp != null)
            S3.setText(temp);

        temp = currentValues.getString("SU4");
        if(temp != null)
            S4.setText(temp);

        temp = currentValues.getString("SU5");
        if(temp != null)
            S5.setText(temp);

        //Great
        temp = currentValues.getString("GR1");
        if(temp != null)
            GR1.setText(temp);

        temp = currentValues.getString("GR2");
        if(temp != null)
            GR2.setText(temp);

        temp = currentValues.getString("GR3");
        if(temp != null)
            GR3.setText(temp);

        temp = currentValues.getString("GR4");
        if(temp != null)
            GR4.setText(temp);

        temp = currentValues.getString("GR5");
        if(temp != null)
            GR5.setText(temp);

        //Good
        temp = currentValues.getString("GO1");
        if(temp != null)
            GO1.setText(temp);

        temp = currentValues.getString("GO2");
        if(temp != null)
            GO2.setText(temp);

        temp = currentValues.getString("GO3");
        if(temp != null)
            GO3.setText(temp);

        temp = currentValues.getString("GO4");
        if(temp != null)
            GO4.setText(temp);

        temp = currentValues.getString("GO5");
        if(temp != null)
            GO5.setText(temp);

        //Fair
        temp = currentValues.getString("FA1");
        if(temp != null)
            F1.setText(temp);

        temp = currentValues.getString("FA2");
        if(temp != null)
            F2.setText(temp);

        temp = currentValues.getString("FA3");
        if(temp != null)
            F3.setText(temp);

        temp = currentValues.getString("FA4");
        if(temp != null)
            F4.setText(temp);

        temp = currentValues.getString("FA5");
        if(temp != null)
            F5.setText(temp);

        //Average
        temp = currentValues.getString("AV1");
        if(temp != null)
            A1.setText(temp);

        temp = currentValues.getString("AV2");
        if(temp != null)
            A2.setText(temp);

        temp = currentValues.getString("AV3");
        if(temp != null)
            A3.setText(temp);

        temp = currentValues.getString("AV4");
        if(temp != null)
            A4.setText(temp);

        temp = currentValues.getString("AV5");
        if(temp != null)
            A5.setText(temp);

        //Fate points
        temp = currentValues.getString("FP");
        //if(temp != null)
            fatePointsBox.setText(temp);





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