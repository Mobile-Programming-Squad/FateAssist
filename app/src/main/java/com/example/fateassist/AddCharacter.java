package com.example.fateassist;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class AddCharacter extends AppCompatActivity {
    int profile;
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
    TextView refreshLabel;
    EditText refreshField;
    Button cancelButton;
    Button nextButton;
    
    DBHelper helper;
    Bundle charData;
    Bitmap bitmap = null;
    byte[] imgBytes = new byte[]{};
    ActivityResultLauncher<String> GetImage = registerForActivityResult(new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri uri) {
                    // Handle the returned Uri
                    try {
                        bitmap = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), uri);
                        imgBytes = DBHelper.getBytes(bitmap);
                        avatar.setImageBitmap(bitmap);
                        charData.putByteArray("IMG", imgBytes);
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
        setContentView(R.layout.activity_add_character);
        Intent intent = getIntent();
        helper = new DBHelper();
        charData = new Bundle();
        profile = intent.getIntExtra("profile", 1);
        profileLabel = (TextView) findViewById(R.id.profileLabel);
        avatar = (ImageButton) findViewById(R.id.avatarPictureButton);
        nameLabel = (TextView) findViewById(R.id.nameLabel);
        nameField = (EditText) findViewById(R.id.nameField);
        descriptionLabel = (TextView) findViewById(R.id.descriptionLabel);
        descriptionField = (EditText) findViewById(R.id.descriptionField);
        aspectsLabel = (TextView) findViewById(R.id.aspectsLabel);
        aspectsField = (EditText) findViewById(R.id.aspectsField);
        stuntsLabel = (TextView) findViewById(R.id.stuntLabel);
        stuntsField = (EditText) findViewById(R.id.stuntsField);
        extrasLabel = (TextView) findViewById(R.id.extrasLabel);
        extrasField = (EditText) findViewById(R.id.extrasField);
        cancelButton = (Button) findViewById(R.id.cancelButton);
        nextButton = (Button) findViewById(R.id.nextButton);
        consequenceLabel = (TextView) findViewById(R.id.consequencesLabel);
        consequence1Field = (EditText) findViewById(R.id.consequence1Field);
        consequence2Field = (EditText) findViewById(R.id.consequence2Field);
        consequence3Field = (EditText) findViewById(R.id.consequence3Field);
        refreshLabel = (TextView) findViewById(R.id.refreshLabel);
        refreshField = (EditText) findViewById(R.id.refreshField);

        cancelButton.setOnClickListener(cancelListener);
        nextButton.setOnClickListener(nextListener);
        avatar.setOnClickListener(imageListener);
        
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        charData = new Bundle();
        charData = intent.getBundleExtra("charData");
        nameField.setText(charData.getCharSequence("CHAR_NAME"));
        descriptionField.setText(charData.getCharSequence("DESCRIPTION"));
        aspectsField.setText(charData.getCharSequence("ASPECTS"));
        stuntsField.setText(charData.getCharSequence("STUNTS"));
        extrasField.setText(charData.getCharSequence("EXTRAS"));
        consequence1Field.setText(charData.getCharSequence("C2"));
        consequence2Field.setText(charData.getCharSequence("C4"));
        consequence3Field.setText(charData.getCharSequence("C6"));
        refreshField.setText(charData.getInt("REFRESH"));

    }

    // NEED TO MAKE SURE THAT THE ACTIVITY WILL SET THE ACTIVITY MAIN CHARACTER PROFILE BOOLEAN
    // TO FALSE SO THAT IT WILL COME BACK TO THIS PAGE IF THE IMAGEBUTTON IS SELECTED AGAIN
    View.OnClickListener cancelListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            boolean success = false;
            Intent intent = new Intent(AddCharacter.this, MainActivity.class);
            startActivity(intent);
        }
    };

    View.OnClickListener nextListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            boolean valid = true;
            String name = nameField.getText().toString();
            String description = descriptionField.getText().toString();
            String aspects = aspectsField.getText().toString();
            String stunts = stuntsField.getText().toString();
            String extras = extrasField.getText().toString();
            String C2 = consequence1Field.getText().toString();
            String C4 = consequence2Field.getText().toString();
            String C6 = consequence3Field.getText().toString();
            String strRefresh = refreshField.getText().toString();
            int refresh = 0;
            boolean available = helper.ValidateCharacterName(getApplicationContext(), name);

            if (name.isEmpty()){
                valid = false;
                nameLabel.setTextColor(Color.RED);
                Toast.makeText(AddCharacter.this, "Must include a character name", Toast.LENGTH_SHORT).show();
            }
            if (!available){
                valid = false;
                nameLabel.setTextColor(Color.RED);
                Toast.makeText(AddCharacter.this, "Name is already in use", Toast.LENGTH_SHORT).show();
            }
            if (description.isEmpty()){
                valid = false;
                descriptionLabel.setTextColor(Color.RED);
                Toast.makeText(AddCharacter.this, "Must include a character description", Toast.LENGTH_SHORT).show();
            }
            if (aspects.isEmpty()){
                valid = false;
                aspectsLabel.setTextColor(Color.RED);
                Toast.makeText(AddCharacter.this, "Must include character aspects", Toast.LENGTH_SHORT).show();
            }
            if (stunts.isEmpty()){
                valid = false;
                stuntsLabel.setTextColor(Color.RED);
                Toast.makeText(AddCharacter.this, "Must include character stunts", Toast.LENGTH_SHORT).show();
            }
            if (extras.isEmpty()){
                valid = false;
                extrasLabel.setTextColor(Color.RED);
                Toast.makeText(AddCharacter.this, "Must include character extras", Toast.LENGTH_SHORT).show();
            }
            if (C2.isEmpty()){
                valid = false;
                consequenceLabel.setTextColor(Color.RED);
                Toast.makeText(AddCharacter.this, "Must include three character consequences", Toast.LENGTH_SHORT).show();
            }
            if (C4.isEmpty()){
                valid = false;
                consequenceLabel.setTextColor(Color.RED);
                Toast.makeText(AddCharacter.this, "Must include three character consequences", Toast.LENGTH_SHORT).show();
            }
            if (C6.isEmpty()){
                valid = false;
                consequenceLabel.setTextColor(Color.RED);
                Toast.makeText(AddCharacter.this, "Must include three character consequences", Toast.LENGTH_SHORT).show();
            }
            if (strRefresh.isEmpty()){
                valid = false;
                refreshLabel.setTextColor(Color.RED);
                Toast.makeText(AddCharacter.this, "Must include a refresh value", Toast.LENGTH_SHORT).show();
            }else{
                refresh = Integer.parseInt(strRefresh);
                if (refresh < 0){
                    valid = false;
                    refreshLabel.setTextColor(Color.RED);
                    Toast.makeText(AddCharacter.this, "Refresh value must be greater than 0", Toast.LENGTH_SHORT).show();
                }
            }


            if (valid){
                // IF VALID, THE DATABASE VALUES GATHERED HERE WILL BE SENT TO THE ADDSKILLS CLASS
                // AND THE REST OF THE DATABASE VALUES WILL BE OBTAINED THERE
                charData.putString("CHAR_NAME", name);
                charData.putString("DESCRIPTION", description);
                charData.putString("ASPECTS", aspects);
                charData.putString("STUNTS", stunts);
                charData.putString("EXTRAS", extras);
                charData.putString("C2", C2);
                charData.putString("C4", C4);
                charData.putString("C6", C6);
                charData.putInt("REFRESH", refresh);
                Intent intent = new Intent(AddCharacter.this, AddSkills.class);
                intent.putExtra("addCharacterBundle", charData);
                intent.putExtra("profile", profile);
                startActivity(intent);

            }

        }
    };

    View.OnClickListener imageListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            GetImage.launch("image/*");

        }
    };
    
}