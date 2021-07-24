package com.example.fateassist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class AddSkills extends AppCompatActivity {
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

    Spinner spinner;
    ListView skillListView;
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

        profiles = getSharedPreferences(MainActivity.PREFS_NAME, 0);
        character1 = profiles.getBoolean("profile1", false);
        character2 = profiles.getBoolean("profile2", false);
        character3 = profiles.getBoolean("profile3", false);
        character4 = profiles.getBoolean("profile4", false);
        character5 = profiles.getBoolean("profile5", false);
        character6 = profiles.getBoolean("profile6", false);

        helper = new DBHelper();
        bundleNames.add("av1");
        bundleNames.add("av2");
        bundleNames.add("av3");
        bundleNames.add("av4");
        bundleNames.add("av5");
        bundleNames.add("fa1");
        bundleNames.add("fa2");
        bundleNames.add("fa3");
        bundleNames.add("fa4");
        bundleNames.add("fa5");
        bundleNames.add("go1");
        bundleNames.add("go2");
        bundleNames.add("go3");
        bundleNames.add("go4");
        bundleNames.add("go5");
        bundleNames.add("gr1");
        bundleNames.add("gr2");
        bundleNames.add("gr3");
        bundleNames.add("gr4");
        bundleNames.add("gr5");
        bundleNames.add("su1");
        bundleNames.add("su2");
        bundleNames.add("su3");
        bundleNames.add("su4");
        bundleNames.add("su5");

        spinner = (Spinner) findViewById(R.id.spinner);
        skillListView = (ListView) findViewById(R.id.skillList);
        backButton = (Button) findViewById(R.id.backbutton);
        confirmButton = (Button) findViewById(R.id.confirmButton); 
        skills = getResources().getStringArray(R.array.skills);


        spinAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, skills);
        spinAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(spinAdapter);
        listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, skillList);
        skillListView.setAdapter(listAdapter);


        spinner.setOnItemSelectedListener(spinnerListener);
        backButton.setOnClickListener(backListener);
        confirmButton.setOnClickListener(confirmListener);
    }

    Spinner.OnItemSelectedListener spinnerListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            skillList.add(spinner.getItemAtPosition(position).toString());
            listAdapter.notifyDataSetChanged();

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
            if (skillList.size() > 0){
                for (int i = 0; i < skillList.size(); i++){
                    charData.putString(bundleNames.get(i), skillList.get(i));
                }

                helper.AddCharacter(getApplicationContext(), charData);
                Log.i("DB", name + " was added");
                Toast.makeText(AddSkills.this, name + " has been added", Toast.LENGTH_LONG).show();

                SharedPreferences.Editor editor = profiles.edit();
                switch (profileNum){
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