package com.example.fateassist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    //This may or may not be useful to you, just know that these should be the options
    //for each skill box
    public enum SkillTypes{
        Athletics,
        Burglary,
        Contacts,
        Crafts,
        Deceive,
        Drive,
        Empathy,
        Fight,
        Investigate,
        Lore,
        Notice,
        Physique,
        Provoke,
        Rapport,
        Resources,
        Shoot,
        Stealth,
        Will,
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}