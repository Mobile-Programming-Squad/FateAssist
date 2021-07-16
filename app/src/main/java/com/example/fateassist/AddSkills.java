package com.example.fateassist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class AddSkills extends AppCompatActivity {

    SharedPreferences profile1;
    SharedPreferences profile2;
    SharedPreferences profile3;
    SharedPreferences profile4;
    SharedPreferences profile5;
    SharedPreferences profile6;
    SharedPreferences.Editor editor;
    static boolean character1 = false;
    static boolean character2 = false;
    static boolean character3 = false;
    static boolean character4 = false;
    static boolean character5 = false;
    static boolean character6 = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_skills);
        Intent intent = getIntent();

        profile1 = getSharedPreferences("profiles", 0);
        profile2 = getSharedPreferences("profiles", 0);
        profile3 = getSharedPreferences("profiles", 0);
        profile4 = getSharedPreferences("profiles", 0);
        profile5 = getSharedPreferences("profiles", 0);
        profile6 = getSharedPreferences("profiles", 0);
        character1 = profile1.getBoolean("profile1", false);
        character2 = profile2.getBoolean("profile2", false);
        character3 = profile3.getBoolean("profile3", false);
        character4 = profile4.getBoolean("profile4", false);
        character5 = profile5.getBoolean("profile5", false);
        character6 = profile6.getBoolean("profile6", false);
    }
}