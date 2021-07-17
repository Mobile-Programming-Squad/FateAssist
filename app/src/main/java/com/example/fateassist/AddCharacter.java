package com.example.fateassist;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

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
    Button cancelButton;
    Button nextButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_character);
        Intent intent = getIntent();

        // STILL NEED TO ENABLE THE PROFILE PICTURE TO BE UPLOADED AND TRANSFERRED TO THE
        // MAIN ACTIVITY TO UPDATE THE AVATAR
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

        cancelButton.setOnClickListener(cancelListener);
        nextButton.setOnClickListener(nextListener);

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


            if (name.isEmpty()){
                valid = false;
                nameLabel.setTextColor(Color.RED);
                Toast.makeText(AddCharacter.this, "Must include a character name", Toast.LENGTH_SHORT).show();
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

            if (valid){
                // IF VALID, THE DATABASE VALUES GATHERED HERE WILL BE SENT TO THE ADDSKILLS CLASS
                // AND THE REST OF THE DATABASE VALUES WILL BE OBTAINED THERE
                Bundle charData = new Bundle();
                charData.putString("CHAR_NAME", name);
                charData.putString("DESCRIPTION", description);
                charData.putString("ASPECTS", aspects);
                charData.putString("STUNTS", stunts);
                charData.putString("EXTRAS", extras);
                charData.putString("C2", C2);
                charData.putString("C4", C4);
                charData.putString("C6", C6);
                switch(profile){
                    case 1:
                        charData.putInt("profile", 1);
                        break;
                    case 2:
                        charData.putInt("profile", 2);
                        break;
                    case 3:
                        charData.putInt("profile", 3);
                        break;
                    case 4:
                        charData.putInt("profile", 4);
                        break;
                    case 5:
                        charData.putInt("profile", 5);
                        break;
                    case 6:
                        charData.putInt("profile", 6);
                        break;
                };
                Intent intent = new Intent(AddCharacter.this, AddSkills.class);
                intent.putExtra("addCharacterBundle", charData);
                startActivity(intent);

            }

        };
    };
}