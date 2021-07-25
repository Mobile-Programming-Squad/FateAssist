package com.example.fateassist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;


public class UpdateCharacter extends AppCompatActivity {

    TextView profileLabel;
    ImageButton avatar;
    TextView nameLabel;
    EditText nameField;
    TextView descriptionLabel;
    EditText descriptionField;
    TextView aspectsLabel;
    EditText aspectsField;
    TextView stuntsLabel;
    EditText stuntsField;
    TextView extrasLabel;
    EditText extrasField;
    TextView consequenceLabel;
    EditText consequence1Field;
    EditText consequence2Field;
    EditText consequence3Field;
    Button cancelButton;
    Button nextUpdateButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_character);

/*
        //get intent from MainActivity
        Bundle bundle = getIntent().getExtras();
        Integer  profileChoice;
        if (bundle != null) {
            profileChoice = bundle.getInt("profile");
            nameTextView.setText("Profile choice: " + profileChoice);
        }
*/


       // profileLabel = (TextView) findViewById(R.id.profileLabel);
       // avatar = (ImageButton) findViewById(R.id.avatarPictureButton);
        //nameLabel = (TextView) findViewById(R.id.nameLabel);
        nameField = (EditText) findViewById(R.id.nameField);
        //descriptionLabel = (TextView) findViewById(R.id.descriptionLabel);
        descriptionField = (EditText) findViewById(R.id.descriptionField);
       // aspectsLabel = (TextView) findViewById(R.id.aspectsLabel);
        aspectsField = (EditText) findViewById(R.id.aspectsField);
      //  stuntsLabel = (TextView) findViewById(R.id.stuntLabel);
        stuntsField = (EditText) findViewById(R.id.stuntsField);
       // extrasLabel = (TextView) findViewById(R.id.extrasLabel);
        extrasField = (EditText) findViewById(R.id.extrasField);
        cancelButton = (Button) findViewById(R.id.cancelButton);
        nextUpdateButton = (Button) findViewById(R.id.nextUpdateButton);
       // consequenceLabel = (TextView) findViewById(R.id.consequencesLabel);
        consequence1Field = (EditText) findViewById(R.id.consequence1Field);
        consequence2Field = (EditText) findViewById(R.id.consequence2Field);
        consequence3Field = (EditText) findViewById(R.id.consequence3Field);

        cancelButton.setOnClickListener(cancelListener);
        nextUpdateButton.setOnClickListener(nextUpdateListener);
       // avatar.setOnClickListener(imageListener);



        //get intent from MainActivity
        Bundle bundle = getIntent().getExtras();
        Integer  profileChoice;
        if (bundle != null) {
            profileChoice = bundle.getInt("profile");
           // nameTextView.setText("Profile choice: " + profileChoice);
        }

        //pass in the name of the profile here
        String name = "CHAR_NAME";
        Bundle currentValues = DBHelper.GetCharacter(getApplicationContext(), name);

        //name
        String temp = currentValues.getString("CHAR_NAME");
        nameField.setText(temp);

        //description
        temp = currentValues.getString("DESCRIPTION");
        descriptionField.setText(temp);

        //Aspects
        temp = currentValues.getString("ASPECTS");
        aspectsField.setText(temp);

        //stunts
        temp = currentValues.getString("STUNTS");
        stuntsField.setText(temp);

        //Extras
        temp = currentValues.getString("EXTRAS");
        extrasField.setText(temp);

        //Consequence 1
        temp = currentValues.getString("C2");
        consequence1Field.setText(temp);

        //Consequence 2
        temp = currentValues.getString("C4");
        consequence2Field.setText(temp);

        //Consequence 3
        temp = currentValues.getString("C6");
        consequence3Field.setText(temp);

    }




    View.OnClickListener cancelListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
    };

    View.OnClickListener nextUpdateListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            String name = nameField.getText().toString();
            String description = descriptionField.getText().toString();
            String aspects = aspectsField.getText().toString();
            String stunts = stuntsField.getText().toString();
            String extras = extrasField.getText().toString();
            String C2 = consequence1Field.getText().toString();
            String C4 = consequence2Field.getText().toString();
            String C6 = consequence3Field.getText().toString();

            Bundle charData = new Bundle();
            charData.putString("CHAR_NAME", name);
            charData.putString("DESCRIPTION", description);
            charData.putString("ASPECTS", aspects);
            charData.putString("STUNTS", stunts);
            charData.putString("EXTRAS", extras);
            charData.putString("C2", C2);
            charData.putString("C4", C4);
            charData.putString("C6", C6);


            Intent updateIntent = new Intent(getApplicationContext(), UpdateSkills.class);
            int profile = updateIntent.getIntExtra("profile", 1); //Probably need to change this once name gets passed
            updateIntent.putExtra("addCharacterBundle", charData);
            updateIntent.putExtra("profile", profile);
            startActivity(updateIntent);
        }
    };


    /*    DBHelper helper;
        Bundle charData;
        Bitmap bitmap;
        byte[] imgBytes = new byte[]{};
        ActivityResultLauncher<String> GetImage = registerForActivityResult(new ActivityResultContracts.GetContent(),
                new ActivityResultCallback<Uri>() {
                    @Override
                    public void onActivityResult(Uri uri) {
                        // Handle the returned Uri
                        bitmap = null;
                        try {
                            bitmap = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), uri);
                            imgBytes = DBHelper.getBytes(bitmap);
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
        );
        */




    }