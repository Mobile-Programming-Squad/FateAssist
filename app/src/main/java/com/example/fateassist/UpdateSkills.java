package com.example.fateassist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class UpdateSkills extends AppCompatActivity {

    Spinner spinner;
    ListView skillListView;
    Button backButton;
    Button confirmUpdateButton;
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
        setContentView(R.layout.activity_update_skills);
        Intent intent = getIntent();
        charData = intent.getBundleExtra("addCharacterBundle");
        profileNum = intent.getIntExtra("profile", 1);

        //populating data


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
        confirmUpdateButton = (Button) findViewById(R.id.confirmUpdateButton);
        skills = getResources().getStringArray(R.array.skills);


        spinAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, skills);
        spinAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(spinAdapter);
        listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, skillList);
        skillListView.setAdapter(listAdapter);


        spinner.setOnItemSelectedListener(spinnerListener);
        backButton.setOnClickListener(backListener);
        confirmUpdateButton.setOnClickListener(confirmUpdateListener);
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
            Intent intent = new Intent(getApplicationContext(), UpdateCharacter.class);
            intent.putExtra("addCharacterBundle", charData);
            startActivity(intent);
        }
    };

    View.OnClickListener confirmUpdateListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String name = charData.get("CHAR_NAME").toString();
            if (skillList.size() > 0){
                for (int i = 0; i < skillList.size(); i++){
                    charData.putString(bundleNames.get(i), skillList.get(i));
                }

               // helper.EditCharacter(getApplicationContext(), charData);
                Log.i("DB", name + " was edited");
                Toast.makeText(getApplicationContext(), name + " has been edited(but not really yet)", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
              //  intent.putExtra("bundle", charData);
                //intent.putExtra("profile", profileNum);
                startActivity(intent);
            }
            else{
                Toast.makeText(getApplicationContext(), "Add a skill to your character", Toast.LENGTH_LONG).show();
            }
        }
    };
}