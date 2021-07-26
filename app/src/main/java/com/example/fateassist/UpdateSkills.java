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

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class UpdateSkills extends AppCompatActivity {

    private static final String PREFS_NAME = "profileNames";
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
        profileNum = intent.getIntExtra("profile", 1); // change to name


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


        //populating values from database into list
        List<String> skillsInDatabase = new ArrayList<>();
        //get intent from MainActivity
        Bundle bundle = getIntent().getExtras();
        Integer  profileChoice;
        if (bundle != null) {
            profileChoice = bundle.getInt("profile"); //pass in name instead
            // nameTextView.setText("Profile choice: " + profileChoice);
        }

        //pass in the name of the profile here
        String name = "name";
        Bundle currentValues = DBHelper.GetCharacter(getApplicationContext(), name);

        SharedPreferences profiles = getSharedPreferences(PREFS_NAME, 0);
        name = profiles.getString("profile1",null);

       // TextView usTV = findViewById(R.id.updateSkillsTextView);
        //AV1
        String temp = currentValues.getString("AV1");
        if(temp!=null)
        skillsInDatabase.add(temp);
        //AV2
        temp = currentValues.getString("AV2");
        skillsInDatabase.add(temp);
        //AV3
        temp = currentValues.getString("AV3");
        skillsInDatabase.add(temp);
        //AV4
        temp = currentValues.getString("AV4");
        skillsInDatabase.add(temp);
        //AV5
        temp = currentValues.getString("AV5");
        skillsInDatabase.add(temp);

        //FA1
        temp = currentValues.getString("FA1");
        skillsInDatabase.add(temp);
        //FA2
        temp = currentValues.getString("FA2");
        skillsInDatabase.add(temp);
        //FA3
        temp = currentValues.getString("FA3");
        skillsInDatabase.add(temp);
        //FA4
        temp = currentValues.getString("FA4");
        skillsInDatabase.add(temp);
        //FA5
        temp = currentValues.getString("FA5");
        skillsInDatabase.add(temp);

        //GO1
        temp = currentValues.getString("GO1");
        skillsInDatabase.add(temp);
        //GO2
        temp = currentValues.getString("GO2");
        skillsInDatabase.add(temp);
        //GO3
        temp = currentValues.getString("GO3");
        skillsInDatabase.add(temp);
        //GO4
        temp = currentValues.getString("GO4");
        skillsInDatabase.add(temp);
        //GO5
        temp = currentValues.getString("GO5");
        skillsInDatabase.add(temp);

        //GR1
        temp = currentValues.getString("GR1");
        skillsInDatabase.add(temp);
        //GR2
        temp = currentValues.getString("GR2");
        skillsInDatabase.add(temp);
        //GR3
        temp = currentValues.getString("GR3");
        skillsInDatabase.add(temp);
        //GR4
        temp = currentValues.getString("GR4");
        skillsInDatabase.add(temp);
        //GR5
        temp = currentValues.getString("GR5");
        skillsInDatabase.add(temp);

        //SU1
        temp = currentValues.getString("SU1");
        skillsInDatabase.add(temp);
        //SU2
        temp = currentValues.getString("SU2");
        skillsInDatabase.add(temp);
        //SU3
        temp = currentValues.getString("SU3");
        skillsInDatabase.add(temp);
        //SU4
        temp = currentValues.getString("SU4");
        skillsInDatabase.add(temp);
        //SU5
        temp = currentValues.getString("SU5");
        skillsInDatabase.add(temp);







        spinner = (Spinner) findViewById(R.id.spinner);
        skillListView = (ListView) findViewById(R.id.skillList);
        backButton = (Button) findViewById(R.id.backbutton);
        confirmUpdateButton = (Button) findViewById(R.id.confirmUpdateButton);
        skills = getResources().getStringArray(R.array.skills);


        spinAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, skills);
        spinAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(spinAdapter);
        listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, skillsInDatabase); //populates the list
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
                intent.putExtra("bundle", charData);
                intent.putExtra("profile", profileNum);
                startActivity(intent);
            }
            else{
                Toast.makeText(getApplicationContext(), "Add a skill to your character", Toast.LENGTH_LONG).show();
            }
        }
    };
}