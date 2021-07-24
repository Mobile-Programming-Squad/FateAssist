package com.example.fateassist;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    // buttons that you can click on to add a new character or view/change character profiles
    ImageButton character1Button;
    ImageButton character2Button;
    ImageButton character3Button;
    ImageButton character4Button;
    ImageButton character5Button;
    ImageButton character6Button;

    // button to start/continue gameplay on any profile
    Button playButton;
    // button for the rules pdf display
    Button rulesButton;

    // text under buttons that will change to the character's name once a character has been added
    TextView character1Label;
    TextView character2Label;
    TextView character3Label;
    TextView character4Label;
    TextView character5Label;
    TextView character6Label;

    //adapters for database
    Cursor playerCursor;
    CursorAdapter playerCursorAdapter;

    // booleans for ImageButtons
    // if false will take you to create new character activity
    // if true will take you to update character activity
    static boolean character1 = false;
    static boolean character2 = false;
    static boolean character3 = false;
    static boolean character4 = false;
    static boolean character5 = false;
    static boolean character6 = false;
    String profile = "";

    // shared preferences
    SharedPreferences profile1;
    SharedPreferences profile2;
    SharedPreferences profile3;
    SharedPreferences profile4;
    SharedPreferences profile5;
    SharedPreferences profile6;

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

    //This gets called at the end of OnCreate with a parameter to pick images
    //When callback happens, it creates a sample character in the database with that image stored,
    //then immediately retrieves the image and displays it on an image component
    ActivityResultLauncher<String> SampleGetContent = registerForActivityResult(new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri uri) {
                    // Handle the returned Uri
                    Uri selectedImage = uri;
                    Bitmap bitmap = null;
                    try {
                        bitmap = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), selectedImage);
                        ImageView img = findViewById(R.id.sampleImageView);

                        byte[] imgBytes = DBHelper.getBytes(bitmap);

                        Bundle charData = new Bundle();

                        charData.putString("CHAR_NAME",   "CHAR_NAME");
                        charData.putString("DESCRIPTION", "DESCRIPTION");
                        charData.putString("ASPECTS",     "ASPECTS");
                        charData.putString("STUNTS",      "STUNTS");
                        charData.putString("EXTRAS",      "EXTRAS");
                        charData.putString("C2",          "C2");
                        charData.putString("C4",          "C4");
                        charData.putString("C6",          "C6");
                        charData.putString("AV1",         "AV1");
                        charData.putString("AV2",         "AV2");
                        charData.putString("AV3",         "AV3");
                        charData.putString("AV4",         "AV4");
                        charData.putString("AV5",         "AV5");
                        charData.putString("FA1",         "FA1");
                        charData.putString("FA2",         "FA2");
                        charData.putString("FA3",         "FA3");
                        charData.putString("FA4",         "FA4");
                        charData.putString("FA5",         "FA5");
                        charData.putString("GO1",         "GO1");
                        charData.putString("GO2",         "GO2");
                        charData.putString("GO3",         "GO3");
                        charData.putString("GO4",         "GO4");
                        charData.putString("GO5",         "GO5");
                        charData.putString("GR1",         "GR1");
                        charData.putString("GR2",         "GR2");
                        charData.putString("GR3",         "GR3");
                        charData.putString("GR4",         "GR4");
                        charData.putString("GR5",         "GR5");
                        charData.putString("SU1",         "SU1");
                        charData.putString("SU2",         "SU2");
                        charData.putString("SU3",         "SU3");
                        charData.putString("SU4",         "SU4");
                        charData.putString("SU5",         "SU5");
                        charData.putInt("REFRESH",        123);
                        charData.putInt("FP",             123);
                        charData.putBoolean("PS1",        false);
                        charData.putBoolean("PS2",        false);
                        charData.putBoolean("PS3",        false);
                        charData.putBoolean("PS4",        false);
                        charData.putBoolean("MS1",        false);
                        charData.putBoolean("MS2",        false);
                        charData.putBoolean("MS3",        false);
                        charData.putBoolean("MS4",        false);
                        charData.putByteArray("IMG",      imgBytes);

                        DBHelper newHelper = new DBHelper();

                        newHelper.AddCharacter(getApplicationContext(), charData);

                        Bundle newBundle = newHelper.GetCharacter(getApplicationContext(), "CHAR_NAME");
                        byte[] newBytes = newBundle.getByteArray("IMG");

                        Bitmap newbitmap = DBHelper.getImage(newBytes);

                        img.setImageBitmap(newbitmap);
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }
            }
    );



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        character1Button = (ImageButton) findViewById(R.id.character1Button);
        character2Button = (ImageButton) findViewById(R.id.character2Button);
        character3Button = (ImageButton) findViewById(R.id.character3Button);
        character4Button = (ImageButton) findViewById(R.id.character4Button);
        character5Button = (ImageButton) findViewById(R.id.character5Button);
        character6Button = (ImageButton) findViewById(R.id.character6Button);

        playButton = (Button) findViewById(R.id.playButton);
        rulesButton = (Button) findViewById(R.id.rulesButton);

        character1Label = (TextView) findViewById(R.id.character1Label);
        character2Label = (TextView) findViewById(R.id.character2Label);
        character3Label = (TextView) findViewById(R.id.character3Label);
        character4Label = (TextView) findViewById(R.id.character4Label);
        character5Label = (TextView) findViewById(R.id.character5Label);
        character6Label = (TextView) findViewById(R.id.character6Label);

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


        character1Button.setOnClickListener(imageListener);
        character2Button.setOnClickListener(imageListener);
        character3Button.setOnClickListener(imageListener);
        character4Button.setOnClickListener(imageListener);
        character5Button.setOnClickListener(imageListener);
        character6Button.setOnClickListener(imageListener);

        // NOT YET IMPLEMENTED
        playButton.setOnClickListener(playListener);

        // IMPLEMENTED WITH URL INSTEAD OF DOCUMENT
        rulesButton.setOnClickListener(rulesListener);

        //SampleGetContent.launch("image/*");

        //uncomment these lines to add some sample data
        //DBHelper myHelper = new DBHelper();
        //myHelper.AddTestCharacters(getApplicationContext());
        }



    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        character1 = profile1.getBoolean("profile1", false);
        character2 = profile2.getBoolean("profile2", false);
        character3 = profile3.getBoolean("profile3", false);
        character4 = profile4.getBoolean("profile4", false);
        character5 = profile5.getBoolean("profile5", false);
        character6 = profile6.getBoolean("profile6", false);
    }

    View.OnClickListener imageListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent;
            if (v == character1Button) {
                if (character1 == false) {
                    intent = new Intent(MainActivity.this, AddCharacter.class);
                    intent.putExtra("profile", 1);
                    startActivity(intent);
                }
                else {
                    intent = new Intent(MainActivity.this, UpdateCharacter.class);
                    intent.putExtra("profile", 1);
                    startActivity(intent);
                }
            }
            if (v == character2Button){
                if (character2 == false){
                    intent = new Intent(MainActivity.this, AddCharacter.class);
                    intent.putExtra("profile", 2);
                    startActivity(intent);
                }
                else {
                    intent = new Intent(MainActivity.this, UpdateCharacter.class);
                    intent.putExtra("profile", 2);
                    startActivity(intent);
                }
            }
            if (v == character3Button){
                if (character3 == false){
                    intent = new Intent(MainActivity.this, AddCharacter.class);
                    intent.putExtra("profile", 3);
                    startActivity(intent);
                }
                else {
                    intent = new Intent(MainActivity.this, UpdateCharacter.class);
                    intent.putExtra("profile", 3);
                    startActivity(intent);
                }
            }
            if (v == character4Button){
                if (character4 == false){
                    intent = new Intent(MainActivity.this, AddCharacter.class);
                    intent.putExtra("profile", 4);
                    startActivity(intent);
                }
                else {
                    intent = new Intent(MainActivity.this, UpdateCharacter.class);
                    intent.putExtra("profile", 4);
                    startActivity(intent);
                }
            }
            if (v == character5Button){
                if (character5 == false){
                    intent = new Intent(MainActivity.this, AddCharacter.class);
                    intent.putExtra("profile", 5);
                    startActivity(intent);
                }
                else {
                    intent = new Intent(MainActivity.this, UpdateCharacter.class);
                    intent.putExtra("profile", 5);
                    startActivity(intent);
                }
            }
            if (v == character6Button){
                if (character6 == false){
                    intent = new Intent(MainActivity.this, AddCharacter.class);
                    intent.putExtra("profile", 6);
                    startActivity(intent);
                }
                else {
                    intent = new Intent(MainActivity.this, UpdateCharacter.class);
                    intent.putExtra("profile", 6);
                    startActivity(intent);
                }
            }

        }
    };

    //IMPLEMENTED 7/20
    View.OnClickListener playListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent playIntent = new Intent(MainActivity.this, PlayActivity.class);
            startActivity(playIntent);
        }
    };

    // IMPLEMENTED WITH URL INSTEAD OF DOCUMENT
    View.OnClickListener rulesListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // allows user to go to rules website until we can get a document interface
            Uri uri = Uri.parse("https://fate-srd.com/fate-core");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
    };
}