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
    static String character1 = null;
    static String character2 = null;
    static String character3 = null;
    static String character4 = null;
    static String character5 = null;
    static String character6 = null;

    Button backButton;
    Button confirmButton;
    String[] skills;
    ArrayList<String> skillList = new ArrayList<>();
    List<String> bundleNames = new ArrayList<>();
    ArrayAdapter<String> spinAdapter;
    Bundle charData;
    DBHelper helper;
    int profileNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_skills);
        charData = new Bundle();
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

        superb1.setText("");
        superb2.setText("");
        superb3.setText("");
        superb4.setText("");
        superb5.setText("");
        great1.setText("");
        great2.setText("");
        great3.setText("");
        great4.setText("");
        great5.setText("");
        good1.setText("");
        good2.setText("");
        good3.setText("");
        good4.setText("");
        good5.setText("");
        fair1.setText("");
        fair2.setText("");
        fair3.setText("");
        fair4.setText("");
        fair5.setText("");
        avg1.setText("");
        avg2.setText("");
        avg3.setText("");
        avg4.setText("");
        avg5.setText("");


        profiles = getSharedPreferences(MainActivity.PREFS_NAME, 0);
        character1 = profiles.getString("profile1", null);
        character2 = profiles.getString("profile2", null);
        character3 = profiles.getString("profile3", null);
        character4 = profiles.getString("profile4", null);
        character5 = profiles.getString("profile5", null);
        character6 = profiles.getString("profile6", null);

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
                        skillList.add(item);
                        bundleNames.add("SU1");
                        superb1.setText(item);
                        superbText = 2;
                        break;
                    case 2:
                        skillList.add(item);
                        bundleNames.add("SU2");
                        superb2.setText(item);
                        superbText = 3;
                        break;
                    case 3:
                        skillList.add(item);
                        bundleNames.add("SU3");
                        superb3.setText(item);
                        superbText = 4;
                        break;
                    case 4:
                        skillList.add(item);
                        bundleNames.add("SU4");
                        superb4.setText(item);
                        superbText = 5;
                        break;
                    case 5:
                        skillList.add(item);
                        bundleNames.add("SU5");
                        superb5.setText(item);
                        superbText = 1;
                        break;
                }
            }
            else
                superbSpinner.setPrompt("Select skills");
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
                        skillList.add(item);
                        bundleNames.add("GR1");
                        great1.setText(item);
                        greatText = 2;
                        break;
                    case 2:
                        skillList.add(item);
                        bundleNames.add("GR2");
                        great2.setText(item);
                        greatText = 3;
                        break;
                    case 3:
                        skillList.add(item);
                        bundleNames.add("GR3");
                        great3.setText(item);
                        greatText = 4;
                        break;
                    case 4:
                        skillList.add(item);
                        bundleNames.add("GR4");
                        great4.setText(item);
                        greatText = 5;
                        break;
                    case 5:
                        skillList.add(item);
                        bundleNames.add("GR5");
                        great5.setText(item);
                        greatText = 1;
                        break;
                }
            }
            else
                greatSpinner.setPrompt("Select skills");
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
                        skillList.add(item);
                        bundleNames.add("GO1");
                        good1.setText(item);
                        goodText = 2;
                        break;
                    case 2:
                        skillList.add(item);
                        bundleNames.add("GO2");
                        good2.setText(item);
                        goodText = 3;
                        break;
                    case 3:
                        skillList.add(item);
                        bundleNames.add("GO3");
                        good3.setText(item);
                        goodText = 4;
                        break;
                    case 4:
                        skillList.add(item);
                        bundleNames.add("GO4");
                        good4.setText(item);
                        goodText = 5;
                        break;
                    case 5:
                        skillList.add(item);
                        bundleNames.add("GO5");
                        good5.setText(item);
                        goodText = 1;
                        break;
                }
            }
            else
                goodSpinner.setPrompt("Select skills");
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
                        skillList.add(item);
                        bundleNames.add("FA1");
                        fair1.setText(item);
                        fairText = 2;
                        break;
                    case 2:
                        skillList.add(item);
                        bundleNames.add("FA2");
                        fair2.setText(item);
                        fairText = 3;
                        break;
                    case 3:
                        skillList.add(item);
                        bundleNames.add("FA3");
                        fair3.setText(item);
                        fairText = 4;
                        break;
                    case 4:
                        skillList.add(item);
                        bundleNames.add("FA4");
                        fair4.setText(item);
                        fairText = 5;
                        break;
                    case 5:
                        skillList.add(item);
                        bundleNames.add("FA5");
                        fair5.setText(item);
                        fairText = 1;
                        break;
                }
            }
            else
                fairSpinner.setPrompt("Select skills");
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
                        skillList.add(item);
                        bundleNames.add("AV1");
                        avg1.setText(item);
                        avgText = 2;
                        break;
                    case 2:
                        skillList.add(item);
                        bundleNames.add("AV2");
                        avg2.setText(item);
                        avgText = 3;
                        break;
                    case 3:
                        skillList.add(item);
                        bundleNames.add("AV3");
                        avg3.setText(item);
                        avgText = 4;
                        break;
                    case 4:
                        skillList.add(item);
                        bundleNames.add("AV4");
                        avg4.setText(item);
                        avgText = 5;
                        break;
                    case 5:
                        skillList.add(item);
                        bundleNames.add("AV5");
                        avg5.setText(item);
                        avgText = 1;
                        break;
                }
            }
            else
                avgSpinner.setPrompt("Select skills");
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
            helper = new DBHelper();
            if (skillList.size() > 0){
                for (int i = 0; i < skillList.size(); i++){
                    charData.putString(bundleNames.get(i), skillList.get(i));
                }
                helper.AddCharacter(getApplicationContext(), charData);
                Log.i("DB", name + " was added");
                Toast.makeText(AddSkills.this, name + " has been added", Toast.LENGTH_LONG).show();
                SharedPreferences.Editor editor = profiles.edit();
                switch (profileNum) {
                    case 1:
                        editor.putString("profile1", name);
                        break; 
                    case 2:
                        editor.putString("profile2", name);
                        break; 
                    case 3:
                        editor.putString("profile3", name);
                        break;
                    case 4:
                        editor.putString("profile4", name);
                        break;
                    case 5:
                        editor.putString("profile5", name);
                        break;
                    case 6:
                        editor.putString("profile6", name);
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

    View.OnClickListener textBoxListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            
        }
    };
}