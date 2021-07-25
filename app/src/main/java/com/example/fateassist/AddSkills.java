package com.example.fateassist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AddSkills extends AppCompatActivity {
    Spinner superbSpinner;
    TextView superb1;
    TextView superb2;
    TextView superb3;
    TextView superb4;
    TextView superb5;
    Spinner greatSpinner;
    TextView great1;
    TextView great2;
    TextView great3;
    TextView great4;
    TextView great5;
    Spinner goodSpinner;
    TextView good1;
    TextView good2;
    TextView good3;
    TextView good4;
    TextView good5;
    Spinner fairSpinner;
    TextView fair1;
    TextView fair2;
    TextView fair3;
    TextView fair4;
    TextView fair5;
    Spinner avgSpinner;
    TextView avg1;
    TextView avg2;
    TextView avg3;
    TextView avg4;
    TextView avg5;

    static int superbText = 1;
    static int greatText = 1;
    static int goodText = 1;
    static int fairText = 1;
    static int avgText = 1;

    SharedPreferences profiles;
    SharedPreferences profile2;
    SharedPreferences profile3;
    SharedPreferences profile4;
    SharedPreferences profile5;
    SharedPreferences profile6;
    static boolean character1 = false;
    static boolean character2 = false;
    static boolean character3 = false;
    static boolean character4 = false;
    static boolean character5 = false;
    static boolean character6 = false;

    Button backButton;
    Button confirmButton;
    String[] skills;
    ArrayList<String> skillList = new ArrayList<>();
    List<String> bundleNames = new ArrayList<>();
    ArrayAdapter<String> spinAdapter;
    ArrayAdapter<String> listAdapter;
    Bundle charData;
    DBHelper helper;
    int profileNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_skills);
        Intent intent = getIntent();
        charData = intent.getBundleExtra("addCharacterBundle");
        profileNum = intent.getIntExtra("profile", 1);

        superbSpinner = (Spinner) findViewById(R.id.superbSpinner);
        superb1 = (TextView) findViewById(R.id.superb1);
        superb2 = (TextView) findViewById(R.id.superb2);
        superb3 = (TextView) findViewById(R.id.superb3);
        superb4 = (TextView) findViewById(R.id.superb4);
        superb5 = (TextView) findViewById(R.id.superb5);
        greatSpinner = (Spinner) findViewById(R.id.greatSpinner);
        great1 = (TextView) findViewById(R.id.great1);
        great2 = (TextView) findViewById(R.id.great2);
        great3 = (TextView) findViewById(R.id.great3);
        great4 = (TextView) findViewById(R.id.great4);
        great5 = (TextView) findViewById(R.id.great5);
        goodSpinner = (Spinner) findViewById(R.id.goodSpinner);
        good1 = (TextView) findViewById(R.id.good1);
        good2 = (TextView) findViewById(R.id.good2);
        good3 = (TextView) findViewById(R.id.good3);
        good4 = (TextView) findViewById(R.id.good4);
        good5 = (TextView) findViewById(R.id.good5);
        fairSpinner = (Spinner) findViewById(R.id.fairSpinner);
        fair1 = (TextView) findViewById(R.id.fair1);
        fair2 = (TextView) findViewById(R.id.fair2);
        fair3 = (TextView) findViewById(R.id.fair3);
        fair4 = (TextView) findViewById(R.id.fair4);
        fair5 = (TextView) findViewById(R.id.fair5);
        avgSpinner = (Spinner) findViewById(R.id.avgSpinner);
        avg1 = (TextView) findViewById(R.id.avg1);
        avg2 = (TextView) findViewById(R.id.avg2);
        avg3 = (TextView) findViewById(R.id.avg3);
        avg4 = (TextView) findViewById(R.id.avg4);
        avg5 = (TextView) findViewById(R.id.avg5);
        backButton = (Button) findViewById(R.id.backbutton);
        confirmButton = (Button) findViewById(R.id.confirmButton);

        profiles = getSharedPreferences(MainActivity.PREFS_NAME, 0);
        character1 = profiles.getBoolean("profile1", false);
        character2 = profiles.getBoolean("profile2", false);
        character3 = profiles.getBoolean("profile3", false);
        character4 = profiles.getBoolean("profile4", false);
        character5 = profiles.getBoolean("profile5", false);
        character6 = profiles.getBoolean("profile6", false);

        skills = getResources().getStringArray(R.array.skills);


        spinAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, skills);
        spinAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        superbSpinner.setAdapter(spinAdapter);
        greatSpinner.setAdapter(spinAdapter);
        goodSpinner.setAdapter(spinAdapter);
        fairSpinner.setAdapter(spinAdapter);
        avgSpinner.setAdapter(spinAdapter);

        superbSpinner.setOnItemSelectedListener(superbListener);
        greatSpinner.setOnItemSelectedListener(greatListener);
        goodSpinner.setOnItemSelectedListener(goodListener);
        fairSpinner.setOnItemSelectedListener(fairListener);
        avgSpinner.setOnItemSelectedListener(avgListener);
        backButton.setOnClickListener(backListener);
        confirmButton.setOnClickListener(confirmListener);
    }
    Spinner.OnItemSelectedListener superbListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String item = parent.getItemAtPosition(position).toString();
            if (position != 0) {
                switch (superbText) {
                    case 1:
                        charData.putString("su1", item);
                        superb1.setText(item);
                        superbText = 2;
                        break;
                    case 2:
                        charData.putString("su2", item);
                        superb2.setText(item);
                        superbText = 3;
                        break;
                    case 3:
                        charData.putString("su3", item);
                        superb3.setText(item);
                        superbText = 4;
                        break;
                    case 4:
                        charData.putString("su4", item);
                        superb4.setText(item);
                        superbText = 5;
                        break;
                    case 5:
                        charData.putString("su5", item);
                        superb5.setText(item);
                        superbText = 1;
                        break;
                }
            }

        }
        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    Spinner.OnItemSelectedListener greatListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String item = parent.getItemAtPosition(position).toString();
            if (position != 0) {
                switch (greatText) {
                    case 1:
                        charData.putString("gr1", item);
                        great1.setText(item);
                        greatText = 2;
                        break;
                    case 2:
                        charData.putString("gr2", item);
                        great2.setText(item);
                        greatText = 3;
                        break;
                    case 3:
                        charData.putString("gr3", item);
                        great3.setText(item);
                        greatText = 4;
                        break;
                    case 4:
                        charData.putString("gr4", item);
                        great4.setText(item);
                        greatText = 5;
                        break;
                    case 5:
                        charData.putString("gr4", item);
                        great5.setText(item);
                        greatText = 1;
                        break;
                }
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    Spinner.OnItemSelectedListener goodListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String item = parent.getItemAtPosition(position).toString();
            if (position != 0) {
                switch (goodText) {
                    case 1:
                        charData.putString("go1", item);
                        good1.setText(item);
                        goodText = 2;
                        break;
                    case 2:
                        charData.putString("go2", item);
                        good2.setText(item);
                        goodText = 3;
                        break;
                    case 3:
                        charData.putString("go3", item);
                        good3.setText(item);
                        goodText = 4;
                        break;
                    case 4:
                        charData.putString("go4", item);
                        good4.setText(item);
                        goodText = 5;
                        break;
                    case 5:
                        charData.putString("go5", item);
                        good5.setText(item);
                        goodText = 1;
                        break;
                }
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    Spinner.OnItemSelectedListener fairListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String item = parent.getItemAtPosition(position).toString();
            if (position != 0) {
                switch (fairText) {
                    case 1:
                        charData.putString("fa1", item);
                        fair1.setText(item);
                        fairText = 2;
                        break;
                    case 2:
                        charData.putString("fa2", item);
                        fair2.setText(item);
                        fairText = 3;
                        break;
                    case 3:
                        charData.putString("fa3", item);
                        fair3.setText(item);
                        fairText = 4;
                        break;
                    case 4:
                        charData.putString("fa4", item);
                        fair4.setText(item);
                        fairText = 5;
                        break;
                    case 5:
                        charData.putString("fa5", item);
                        fair5.setText(item);
                        fairText = 1;
                        break;
                }
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    Spinner.OnItemSelectedListener avgListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String item = parent.getItemAtPosition(position).toString();
            if (position != 0) {
                switch (avgText) {
                    case 1:
                        charData.putString("av1", item);
                        avg1.setText(item);
                        avgText = 2;
                        break;
                    case 2:
                        charData.putString("av2", item);
                        avg2.setText(item);
                        avgText = 3;
                        break;
                    case 3:
                        charData.putString("av3", item);
                        avg3.setText(item);
                        avgText = 4;
                        break;
                    case 4:
                        charData.putString("av4", item);
                        avg4.setText(item);
                        avgText = 5;
                        break;
                    case 5:
                        charData.putString("av5", item);
                        avg5.setText(item);
                        avgText = 1;
                        break;
                }
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };




    View.OnClickListener backListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(AddSkills.this, AddCharacter.class);
            intent.putExtra("addCharacterBundle", charData);
            startActivity(intent);
        }
    };
    
    View.OnClickListener confirmListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String name = charData.get("CHAR_NAME").toString();
                helper.AddCharacter(getApplicationContext(), charData);
                Log.i("DB", name + " was added");
                Toast.makeText(AddSkills.this, name + " has been added", Toast.LENGTH_LONG).show();

                if (superbText != 1 || greatText != 1 || goodText != 1 || fairText != 1 || avgText != 1) {
                    SharedPreferences.Editor editor = profiles.edit();
                    switch (profileNum) {
                        case 1:
                            editor.putBoolean("profile1", true);
                            break;
                        case 2:
                            editor.putBoolean("profile2", true);
                            break;
                        case 3:
                            editor.putBoolean("profile3", true);
                            break;
                        case 4:
                            editor.putBoolean("profile4", true);
                            break;
                        case 5:
                            editor.putBoolean("profile5", true);
                            break;
                        case 6:
                            editor.putBoolean("profile6", true);
                            break;
                    }
                    editor.commit();

                    Intent intent = new Intent(AddSkills.this, MainActivity.class);
                    intent.putExtra("bundle", charData);
                    intent.putExtra("profile", profileNum);
                    startActivity(intent);
                }
            else{
                Toast.makeText(AddSkills.this, "Add a skill to your character", Toast.LENGTH_LONG).show();
            }
        }
    };
}