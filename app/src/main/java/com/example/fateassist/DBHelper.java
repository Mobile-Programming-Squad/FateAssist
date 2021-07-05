package com.example.fateassist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;

//class for managing the database through nicer commands
//!TBD
public class DBHelper {

    //NOTE: I know a lot of the code here could've been done with loops and it would've been easier
        //I chose not to because I am dumb, and now I don't want to refactor
        //-elias

    /*
    Template for creating a charData bundle,
    just fill in the lowercase terms with the corresponding data

    For EditCharacter, DELETE any lines for data that you aren't editing

    Bundle charData = new Bundle();
    charData.putString("NAME", name);
    charData.putString("DESCRIPTION", description);
    charData.putString("ASPECTS", aspects);
    charData.putString("STUNTS", stunts);
    charData.putString("EXTRAS", extras);
    charData.putString("C2", c2);
    charData.putString("C4", c4);
    charData.putString("C6", c6);
    charData.putString("AV1", av1);
    charData.putString("AV2", av2);
    charData.putString("AV3", av3);
    charData.putString("AV4", av4);
    charData.putString("AV5", av5);
    charData.putString("FA1", fa1);
    charData.putString("FA2", fa2);
    charData.putString("FA3", fa3);
    charData.putString("FA4", fa4);
    charData.putString("FA5", fa5);
    charData.putString("GO1", go1);
    charData.putString("GO2", go2);
    charData.putString("GO3", go3);
    charData.putString("GO4", go4);
    charData.putString("GO5", go5);
    charData.putString("GR1", gr1);
    charData.putString("GR2", gr2);
    charData.putString("GR3", gr3);
    charData.putString("GR4", gr4);
    charData.putString("GR5", gr5);
    charData.putString("SU1", su1);
    charData.putString("SU2", su2);
    charData.putString("SU3", su3);
    charData.putString("SU4", su4);
    charData.putString("SU5", su5);
    charData.putInt("REFRESH", refresh);
    charData.putInt("FP", fp);
    charData.putString("PS1", ps1);
    charData.putString("PS2", ps2);
    charData.putString("PS3", ps3);
    charData.putString("PS4", ps4);
    charData.putString("MS1", ms1);
    charData.putString("MS2", ms2);
    charData.putString("MS3", ms3);
    charData.putString("MS4", ms4);
     */

    /*
    Template for getting data back from the GetCharacter returned bundle
    (make sure you call the bundle charData)

    String name = charData.getString("NAME");
    String description = charData.getString("DESCRIPTION");
    String aspects = charData.getString("ASPECTS");
    String stunts = charData.getString("STUNTS");
    String extras = charData.getString("EXTRAS");
    String c2 = charData.getString("C2");
    String c4 = charData.getString("C4");
    String c6 = charData.getString("C6");
    String av1 = charData.getString("AV1");
    String av2 = charData.getString("AV2");
    String av3 = charData.getString("AV3");
    String av4 = charData.getString("AV4");
    String av5 = charData.getString("AV5");
    String fa1 = charData.getString("FA1");
    String fa2 = charData.getString("FA2");
    String fa3 = charData.getString("FA3");
    String fa4 = charData.getString("FA4");
    String fa5 = charData.getString("FA5");
    String go1 = charData.getString("GO1");
    String go2 = charData.getString("GO2");
    String go3 = charData.getString("GO3");
    String go4 = charData.getString("GO4");
    String go5 = charData.getString("GO5");
    String gr1 = charData.getString("GR1");
    String gr2 = charData.getString("GR2");
    String gr3 = charData.getString("GR3");
    String gr4 = charData.getString("GR4");
    String gr5 = charData.getString("GR5");
    String su1 = charData.getString("SU1");
    String su2 = charData.getString("SU2");
    String su3 = charData.getString("SU3");
    String su4 = charData.getString("SU4");
    String su5 = charData.getString("SU5");
    int refresh = charData.getInt("REFRESH");
    int fp = charData.getInt("FP");
    Boolean ps1 = charData.getBoolean("PS1");
    Boolean ps2 = charData.getBoolean("PS2");
    Boolean ps3 = charData.getBoolean("PS3");
    Boolean ps4 = charData.getBoolean("PS4");
    Boolean ms1 = charData.getBoolean("MS1");
    Boolean ms2 = charData.getBoolean("MS2");
    Boolean ms3 = charData.getBoolean("MS3");
    Boolean ms4 = charData.getBoolean("MS4");
     */

    //adds bundle to database
    //MUST include every attribute
    public void AddCharacter(Context context, Bundle charData){
        String name = charData.getString("NAME");
        String description = charData.getString("DESCRIPTION");
        String aspects = charData.getString("ASPECTS");
        String stunts = charData.getString("STUNTS");
        String extras = charData.getString("EXTRAS");
        String c2 = charData.getString("C2");
        String c4 = charData.getString("C4");
        String c6 = charData.getString("C6");
        String av1 = charData.getString("AV1");
        String av2 = charData.getString("AV2");
        String av3 = charData.getString("AV3");
        String av4 = charData.getString("AV4");
        String av5 = charData.getString("AV5");
        String fa1 = charData.getString("FA1");
        String fa2 = charData.getString("FA2");
        String fa3 = charData.getString("FA3");
        String fa4 = charData.getString("FA4");
        String fa5 = charData.getString("FA5");
        String go1 = charData.getString("GO1");
        String go2 = charData.getString("GO2");
        String go3 = charData.getString("GO3");
        String go4 = charData.getString("GO4");
        String go5 = charData.getString("GO5");
        String gr1 = charData.getString("GR1");
        String gr2 = charData.getString("GR2");
        String gr3 = charData.getString("GR3");
        String gr4 = charData.getString("GR4");
        String gr5 = charData.getString("GR5");
        String su1 = charData.getString("SU1");
        String su2 = charData.getString("SU2");
        String su3 = charData.getString("SU3");
        String su4 = charData.getString("SU4");
        String su5 = charData.getString("SU5");
        int refresh = charData.getInt("REFRESH");
        int fp = charData.getInt("FP");
        Boolean ps1 = charData.getBoolean("PS1");
        Boolean ps2 = charData.getBoolean("PS2");
        Boolean ps3 = charData.getBoolean("PS3");
        Boolean ps4 = charData.getBoolean("PS4");
        Boolean ms1 = charData.getBoolean("MS1");
        Boolean ms2 = charData.getBoolean("MS2");
        Boolean ms3 = charData.getBoolean("MS3");
        Boolean ms4 = charData.getBoolean("MS4");

        ContentValues newValues = new ContentValues();
        newValues.put("NAME", name);
        newValues.put("DESCRIPTION", description);
        newValues.put("ASPECTS", aspects);
        newValues.put("STUNTS", stunts);
        newValues.put("EXTRAS", extras);
        newValues.put("C2", c2);
        newValues.put("C4", c4);
        newValues.put("C6", c6);
        newValues.put("AV1", av1);
        newValues.put("AV2", av2);
        newValues.put("AV3", av3);
        newValues.put("AV4", av4);
        newValues.put("AV5", av5);
        newValues.put("FA1", fa1);
        newValues.put("FA2", fa2);
        newValues.put("FA3", fa3);
        newValues.put("FA4", fa4);
        newValues.put("FA5", fa5);
        newValues.put("GO1", go1);
        newValues.put("GO2", go2);
        newValues.put("GO3", go3);
        newValues.put("GO4", go4);
        newValues.put("GO5", go5);
        newValues.put("GR1", gr1);
        newValues.put("GR2", gr2);
        newValues.put("GR3", gr3);
        newValues.put("GR4", gr4);
        newValues.put("GR5", gr5);
        newValues.put("SU1", su1);
        newValues.put("SU2", su2);
        newValues.put("SU3", su3);
        newValues.put("SU4", su4);
        newValues.put("SU5", su5);
        newValues.put("REFRESH", refresh);
        newValues.put("FP", fp);
        newValues.put("PS1", ps1);
        newValues.put("PS2", ps2);
        newValues.put("PS3", ps3);
        newValues.put("PS4", ps4);
        newValues.put("MS1", ms1);
        newValues.put("MS2", ms2);
        newValues.put("MS3", ms3);
        newValues.put("MS4", ms4);

        context.getContentResolver().insert(MyContentProvider.CONTENT_URI, newValues);
    }

    //removes row from database corresponding to the character name
    public void RemoveCharacter(Context context, String charName){
        context.getContentResolver().delete(MyContentProvider.CONTENT_URI, "NAME = " + charName, null);
    }

    //returns true if character name is not in the database, returns false if it is
    //never add a character to the database if the name is unavailable
    public Boolean ValidateCharacterName(Context context, String charName){
        boolean matches = false;
        String[] proj = new String[]{"NAME"};
        Cursor mCursor = context.getContentResolver().query(
                MyContentProvider.CONTENT_URI, proj,
                null,
                null,
                null
        );

        mCursor.moveToFirst();
        while(!mCursor.isAfterLast()) {
            if(charName.equals(mCursor.getString(mCursor.getColumnIndex("ConfirmationCode")))){
                matches = true;
            }
            mCursor.moveToNext();
        }
        return matches;
    }

    //returns bundle with all info of character matching the charName
    public Bundle GetCharacter(Context context, String charName){
        Bundle currentValues = new Bundle();

        Cursor mCursor = context.getContentResolver().query(
                MyContentProvider.CONTENT_URI,
                null,
                "NAME ==" + charName,
                null,
                null
        );
        mCursor.moveToFirst();

        currentValues.putString("NAME", mCursor.getString(mCursor.getColumnIndex("NAME")));
        currentValues.putString("DESCRIPTION", mCursor.getString(mCursor.getColumnIndex("DESCRIPTION")));
        currentValues.putString("ASPECTS", mCursor.getString(mCursor.getColumnIndex("ASPECTS")));
        currentValues.putString("STUNTS", mCursor.getString(mCursor.getColumnIndex("STUNTS")));
        currentValues.putString("EXTRAS", mCursor.getString(mCursor.getColumnIndex("EXTRAS")));
        currentValues.putString("C2", mCursor.getString(mCursor.getColumnIndex("C2")));
        currentValues.putString("C4", mCursor.getString(mCursor.getColumnIndex("C4")));
        currentValues.putString("C6", mCursor.getString(mCursor.getColumnIndex("C6")));
        currentValues.putString("AV1", mCursor.getString(mCursor.getColumnIndex("AV1")));
        currentValues.putString("AV2", mCursor.getString(mCursor.getColumnIndex("AV2")));
        currentValues.putString("AV3", mCursor.getString(mCursor.getColumnIndex("AV3")));
        currentValues.putString("AV4", mCursor.getString(mCursor.getColumnIndex("AV4")));
        currentValues.putString("AV5", mCursor.getString(mCursor.getColumnIndex("AV5")));
        currentValues.putString("FA1", mCursor.getString(mCursor.getColumnIndex("FA1")));
        currentValues.putString("FA2", mCursor.getString(mCursor.getColumnIndex("FA2")));
        currentValues.putString("FA3", mCursor.getString(mCursor.getColumnIndex("FA3")));
        currentValues.putString("FA4", mCursor.getString(mCursor.getColumnIndex("FA4")));
        currentValues.putString("FA5", mCursor.getString(mCursor.getColumnIndex("FA5")));
        currentValues.putString("GO1", mCursor.getString(mCursor.getColumnIndex("GO1")));
        currentValues.putString("GO2", mCursor.getString(mCursor.getColumnIndex("GO2")));
        currentValues.putString("GO3", mCursor.getString(mCursor.getColumnIndex("GO3")));
        currentValues.putString("GO4", mCursor.getString(mCursor.getColumnIndex("GO4")));
        currentValues.putString("GO5", mCursor.getString(mCursor.getColumnIndex("GO5")));
        currentValues.putString("GR1", mCursor.getString(mCursor.getColumnIndex("GR1")));
        currentValues.putString("GR2", mCursor.getString(mCursor.getColumnIndex("GR2")));
        currentValues.putString("GR3", mCursor.getString(mCursor.getColumnIndex("GR3")));
        currentValues.putString("GR4", mCursor.getString(mCursor.getColumnIndex("GR4")));
        currentValues.putString("GR5", mCursor.getString(mCursor.getColumnIndex("GR5")));
        currentValues.putString("SU1", mCursor.getString(mCursor.getColumnIndex("SU1")));
        currentValues.putString("SU2", mCursor.getString(mCursor.getColumnIndex("SU2")));
        currentValues.putString("SU3", mCursor.getString(mCursor.getColumnIndex("SU3")));
        currentValues.putString("SU4", mCursor.getString(mCursor.getColumnIndex("SU4")));
        currentValues.putString("SU5", mCursor.getString(mCursor.getColumnIndex("SU5")));
        currentValues.putInt("REFRESH", mCursor.getInt(mCursor.getColumnIndex("REFRESH")));
        currentValues.putInt("FP", mCursor.getInt(mCursor.getColumnIndex("FP")));
        currentValues.putBoolean("PS1", mCursor.getInt(mCursor.getColumnIndex("PS1")) > 0);
        currentValues.putBoolean("PS2", mCursor.getInt(mCursor.getColumnIndex("PS2")) > 0);
        currentValues.putBoolean("PS3", mCursor.getInt(mCursor.getColumnIndex("PS3")) > 0);
        currentValues.putBoolean("PS4", mCursor.getInt(mCursor.getColumnIndex("PS4")) > 0);
        currentValues.putBoolean("MS1", mCursor.getInt(mCursor.getColumnIndex("MS1")) > 0);
        currentValues.putBoolean("MS2", mCursor.getInt(mCursor.getColumnIndex("MS2")) > 0);
        currentValues.putBoolean("MS3", mCursor.getInt(mCursor.getColumnIndex("MS3")) > 0);
        currentValues.putBoolean("MS4", mCursor.getInt(mCursor.getColumnIndex("MS4")) > 0);

        mCursor.close();
        return currentValues;
    }

    //MUST include charName in bundle, everything else optional
    public void EditCharacter(Context context, Bundle charData){


        String name = charData.getString("NAME");
        String description = charData.getString("DESCRIPTION");
        String aspects = charData.getString("ASPECTS");
        String stunts = charData.getString("STUNTS");
        String extras = charData.getString("EXTRAS");
        String c2 = charData.getString("C2");
        String c4 = charData.getString("C4");
        String c6 = charData.getString("C6");
        String av1 = charData.getString("AV1");
        String av2 = charData.getString("AV2");
        String av3 = charData.getString("AV3");
        String av4 = charData.getString("AV4");
        String av5 = charData.getString("AV5");
        String fa1 = charData.getString("FA1");
        String fa2 = charData.getString("FA2");
        String fa3 = charData.getString("FA3");
        String fa4 = charData.getString("FA4");
        String fa5 = charData.getString("FA5");
        String go1 = charData.getString("GO1");
        String go2 = charData.getString("GO2");
        String go3 = charData.getString("GO3");
        String go4 = charData.getString("GO4");
        String go5 = charData.getString("GO5");
        String gr1 = charData.getString("GR1");
        String gr2 = charData.getString("GR2");
        String gr3 = charData.getString("GR3");
        String gr4 = charData.getString("GR4");
        String gr5 = charData.getString("GR5");
        String su1 = charData.getString("SU1");
        String su2 = charData.getString("SU2");
        String su3 = charData.getString("SU3");
        String su4 = charData.getString("SU4");
        String su5 = charData.getString("SU5");
        int refresh = charData.getInt("REFRESH");
        int fp = charData.getInt("FP");

        ContentValues currentValues = new ContentValues();

        if(name != null){
            //get current values as a contentvalues, then update any that are null
            Cursor mCursor = context.getContentResolver().query(
                    MyContentProvider.CONTENT_URI,
                    null,
                    "NAME ==" + name,
                    null,
                    null
            );
            mCursor.moveToFirst();

            currentValues.put("NAME", mCursor.getString(mCursor.getColumnIndex("NAME")));
            currentValues.put("DESCRIPTION", mCursor.getString(mCursor.getColumnIndex("DESCRIPTION")));
            currentValues.put("ASPECTS", mCursor.getString(mCursor.getColumnIndex("ASPECTS")));
            currentValues.put("STUNTS", mCursor.getString(mCursor.getColumnIndex("STUNTS")));
            currentValues.put("EXTRAS", mCursor.getString(mCursor.getColumnIndex("EXTRAS")));
            currentValues.put("C2", mCursor.getString(mCursor.getColumnIndex("C2")));
            currentValues.put("C4", mCursor.getString(mCursor.getColumnIndex("C4")));
            currentValues.put("C6", mCursor.getString(mCursor.getColumnIndex("C6")));
            currentValues.put("AV1", mCursor.getString(mCursor.getColumnIndex("AV1")));
            currentValues.put("AV2", mCursor.getString(mCursor.getColumnIndex("AV2")));
            currentValues.put("AV3", mCursor.getString(mCursor.getColumnIndex("AV3")));
            currentValues.put("AV4", mCursor.getString(mCursor.getColumnIndex("AV4")));
            currentValues.put("AV5", mCursor.getString(mCursor.getColumnIndex("AV5")));
            currentValues.put("FA1", mCursor.getString(mCursor.getColumnIndex("FA1")));
            currentValues.put("FA2", mCursor.getString(mCursor.getColumnIndex("FA2")));
            currentValues.put("FA3", mCursor.getString(mCursor.getColumnIndex("FA3")));
            currentValues.put("FA4", mCursor.getString(mCursor.getColumnIndex("FA4")));
            currentValues.put("FA5", mCursor.getString(mCursor.getColumnIndex("FA5")));
            currentValues.put("GO1", mCursor.getString(mCursor.getColumnIndex("GO1")));
            currentValues.put("GO2", mCursor.getString(mCursor.getColumnIndex("GO2")));
            currentValues.put("GO3", mCursor.getString(mCursor.getColumnIndex("GO3")));
            currentValues.put("GO4", mCursor.getString(mCursor.getColumnIndex("GO4")));
            currentValues.put("GO5", mCursor.getString(mCursor.getColumnIndex("GO5")));
            currentValues.put("GR1", mCursor.getString(mCursor.getColumnIndex("GR1")));
            currentValues.put("GR2", mCursor.getString(mCursor.getColumnIndex("GR2")));
            currentValues.put("GR3", mCursor.getString(mCursor.getColumnIndex("GR3")));
            currentValues.put("GR4", mCursor.getString(mCursor.getColumnIndex("GR4")));
            currentValues.put("GR5", mCursor.getString(mCursor.getColumnIndex("GR5")));
            currentValues.put("SU1", mCursor.getString(mCursor.getColumnIndex("SU1")));
            currentValues.put("SU2", mCursor.getString(mCursor.getColumnIndex("SU2")));
            currentValues.put("SU3", mCursor.getString(mCursor.getColumnIndex("SU3")));
            currentValues.put("SU4", mCursor.getString(mCursor.getColumnIndex("SU4")));
            currentValues.put("SU5", mCursor.getString(mCursor.getColumnIndex("SU5")));
            currentValues.put("REFRESH", mCursor.getInt(mCursor.getColumnIndex("REFRESH")));
            currentValues.put("FP", mCursor.getInt(mCursor.getColumnIndex("FP")));
            currentValues.put("PS1", mCursor.getInt(mCursor.getColumnIndex("PS1")) > 0);
            currentValues.put("PS2", mCursor.getInt(mCursor.getColumnIndex("PS2")) > 0);
            currentValues.put("PS3", mCursor.getInt(mCursor.getColumnIndex("PS3")) > 0);
            currentValues.put("PS4", mCursor.getInt(mCursor.getColumnIndex("PS4")) > 0);
            currentValues.put("MS1", mCursor.getInt(mCursor.getColumnIndex("MS1")) > 0);
            currentValues.put("MS2", mCursor.getInt(mCursor.getColumnIndex("MS2")) > 0);
            currentValues.put("MS3", mCursor.getInt(mCursor.getColumnIndex("MS3")) > 0);
            currentValues.put("MS4", mCursor.getInt(mCursor.getColumnIndex("MS4")) > 0);

            mCursor.close();

            if(description != null){
                currentValues.put("DESCRIPTION", description);
            }
            if(aspects != null){
                currentValues.put("ASPECTS", aspects);
            }
            if(stunts != null){
                currentValues.put("STUNTS", stunts);
            }
            if(extras != null){
                currentValues.put("EXTRAS", extras);
            }
            if(c2 != null){
                currentValues.put("C2", c2);
            }
            if(c4 != null){
                currentValues.put("C4", c4);
            }
            if(c6 != null){
                currentValues.put("C6", c6);
            }
            if(av1 != null){
                currentValues.put("AV1", av1);
            }
            if(av2 != null){
                currentValues.put("AV2", av2);
            }
            if(av3 != null){
                currentValues.put("AV3", av3);
            }
            if(av4 != null){
                currentValues.put("AV4", av4);
            }
            if(av5 != null){
                currentValues.put("AV5", av5);
            }
            if(fa1 != null){
                currentValues.put("FA1", fa1);
            }
            if(fa2 != null){
                currentValues.put("FA2", fa2);
            }
            if(fa3 != null){
                currentValues.put("FA3", fa3);
            }
            if(fa4 != null){
                currentValues.put("FA4", fa4);
            }
            if(fa5 != null){
                currentValues.put("FA5", fa5);
            }
            if(go1 != null){
                currentValues.put("GO1", go1);
            }
            if(go2 != null){
                currentValues.put("GO2", go2);
            }
            if(go3 != null){
                currentValues.put("GO3", go3);
            }
            if(go4 != null){
                currentValues.put("GO4", go4);
            }
            if(go5 != null){
                currentValues.put("GO5", go5);
            }
            if(gr1 != null){
                currentValues.put("GR1", gr1);
            }
            if(gr2 != null){
                currentValues.put("GR2", gr2);
            }
            if(gr3 != null){
                currentValues.put("GR3", gr3);
            }
            if(gr4 != null){
                currentValues.put("GR4", gr4);
            }
            if(gr5 != null){
                currentValues.put("GR5", gr5);
            }
            if(su1 != null){
                currentValues.put("SU1", su1);
            }
            if(su2 != null){
                currentValues.put("SU2", su2);
            }
            if(su3 != null){
                currentValues.put("SU3", su3);
            }
            if(su4 != null){
                currentValues.put("SU4", su4);
            }
            if(su5 != null){
                currentValues.put("SU5", su5);
            }
            if(refresh != 0){
                currentValues.put("REFRESH", refresh);
            }
            if(fp != 0){
                currentValues.put("FP", fp);
            }
        }
        else{
            return;
        }

        context.getContentResolver().update(
                MyContentProvider.CONTENT_URI,
                currentValues,
                "NAME == " + name,
                null);
    }

    //self-explanatory, make sure to call ValidateCharacterName on newCharName before calling this
    public void EditCharacterName(Context context, String charName, String newCharName){
        ContentValues currentValues = new ContentValues();

        Cursor mCursor = context.getContentResolver().query(
                MyContentProvider.CONTENT_URI,
                null,
                "NAME ==" + charName,
                null,
                null
        );
        mCursor.moveToFirst();

        currentValues.put("NAME", newCharName);
        currentValues.put("DESCRIPTION", mCursor.getString(mCursor.getColumnIndex("DESCRIPTION")));
        currentValues.put("ASPECTS", mCursor.getString(mCursor.getColumnIndex("ASPECTS")));
        currentValues.put("STUNTS", mCursor.getString(mCursor.getColumnIndex("STUNTS")));
        currentValues.put("EXTRAS", mCursor.getString(mCursor.getColumnIndex("EXTRAS")));
        currentValues.put("C2", mCursor.getString(mCursor.getColumnIndex("C2")));
        currentValues.put("C4", mCursor.getString(mCursor.getColumnIndex("C4")));
        currentValues.put("C6", mCursor.getString(mCursor.getColumnIndex("C6")));
        currentValues.put("AV1", mCursor.getString(mCursor.getColumnIndex("AV1")));
        currentValues.put("AV2", mCursor.getString(mCursor.getColumnIndex("AV2")));
        currentValues.put("AV3", mCursor.getString(mCursor.getColumnIndex("AV3")));
        currentValues.put("AV4", mCursor.getString(mCursor.getColumnIndex("AV4")));
        currentValues.put("AV5", mCursor.getString(mCursor.getColumnIndex("AV5")));
        currentValues.put("FA1", mCursor.getString(mCursor.getColumnIndex("FA1")));
        currentValues.put("FA2", mCursor.getString(mCursor.getColumnIndex("FA2")));
        currentValues.put("FA3", mCursor.getString(mCursor.getColumnIndex("FA3")));
        currentValues.put("FA4", mCursor.getString(mCursor.getColumnIndex("FA4")));
        currentValues.put("FA5", mCursor.getString(mCursor.getColumnIndex("FA5")));
        currentValues.put("GO1", mCursor.getString(mCursor.getColumnIndex("GO1")));
        currentValues.put("GO2", mCursor.getString(mCursor.getColumnIndex("GO2")));
        currentValues.put("GO3", mCursor.getString(mCursor.getColumnIndex("GO3")));
        currentValues.put("GO4", mCursor.getString(mCursor.getColumnIndex("GO4")));
        currentValues.put("GO5", mCursor.getString(mCursor.getColumnIndex("GO5")));
        currentValues.put("GR1", mCursor.getString(mCursor.getColumnIndex("GR1")));
        currentValues.put("GR2", mCursor.getString(mCursor.getColumnIndex("GR2")));
        currentValues.put("GR3", mCursor.getString(mCursor.getColumnIndex("GR3")));
        currentValues.put("GR4", mCursor.getString(mCursor.getColumnIndex("GR4")));
        currentValues.put("GR5", mCursor.getString(mCursor.getColumnIndex("GR5")));
        currentValues.put("SU1", mCursor.getString(mCursor.getColumnIndex("SU1")));
        currentValues.put("SU2", mCursor.getString(mCursor.getColumnIndex("SU2")));
        currentValues.put("SU3", mCursor.getString(mCursor.getColumnIndex("SU3")));
        currentValues.put("SU4", mCursor.getString(mCursor.getColumnIndex("SU4")));
        currentValues.put("SU5", mCursor.getString(mCursor.getColumnIndex("SU5")));
        currentValues.put("REFRESH", mCursor.getInt(mCursor.getColumnIndex("REFRESH")));
        currentValues.put("FP", mCursor.getInt(mCursor.getColumnIndex("FP")));
        currentValues.put("PS1", mCursor.getInt(mCursor.getColumnIndex("PS1")) > 0);
        currentValues.put("PS2", mCursor.getInt(mCursor.getColumnIndex("PS2")) > 0);
        currentValues.put("PS3", mCursor.getInt(mCursor.getColumnIndex("PS3")) > 0);
        currentValues.put("PS4", mCursor.getInt(mCursor.getColumnIndex("PS4")) > 0);
        currentValues.put("MS1", mCursor.getInt(mCursor.getColumnIndex("MS1")) > 0);
        currentValues.put("MS2", mCursor.getInt(mCursor.getColumnIndex("MS2")) > 0);
        currentValues.put("MS3", mCursor.getInt(mCursor.getColumnIndex("MS3")) > 0);
        currentValues.put("MS4", mCursor.getInt(mCursor.getColumnIndex("MS4")) > 0);

        mCursor.close();

        context.getContentResolver().update(
                MyContentProvider.CONTENT_URI,
                currentValues,
                "NAME == " + charName,
                null);
    }

    //sets the character's fate points equal to their Refresh
    public void RefreshCharacter(Context context, String charName){
        ContentValues currentValues = new ContentValues();

        Cursor mCursor = context.getContentResolver().query(
                MyContentProvider.CONTENT_URI,
                null,
                "NAME ==" + charName,
                null,
                null
        );
        mCursor.moveToFirst();

        currentValues.put("NAME", mCursor.getString(mCursor.getColumnIndex("NAME")));
        currentValues.put("DESCRIPTION", mCursor.getString(mCursor.getColumnIndex("DESCRIPTION")));
        currentValues.put("ASPECTS", mCursor.getString(mCursor.getColumnIndex("ASPECTS")));
        currentValues.put("STUNTS", mCursor.getString(mCursor.getColumnIndex("STUNTS")));
        currentValues.put("EXTRAS", mCursor.getString(mCursor.getColumnIndex("EXTRAS")));
        currentValues.put("C2", mCursor.getString(mCursor.getColumnIndex("C2")));
        currentValues.put("C4", mCursor.getString(mCursor.getColumnIndex("C4")));
        currentValues.put("C6", mCursor.getString(mCursor.getColumnIndex("C6")));
        currentValues.put("AV1", mCursor.getString(mCursor.getColumnIndex("AV1")));
        currentValues.put("AV2", mCursor.getString(mCursor.getColumnIndex("AV2")));
        currentValues.put("AV3", mCursor.getString(mCursor.getColumnIndex("AV3")));
        currentValues.put("AV4", mCursor.getString(mCursor.getColumnIndex("AV4")));
        currentValues.put("AV5", mCursor.getString(mCursor.getColumnIndex("AV5")));
        currentValues.put("FA1", mCursor.getString(mCursor.getColumnIndex("FA1")));
        currentValues.put("FA2", mCursor.getString(mCursor.getColumnIndex("FA2")));
        currentValues.put("FA3", mCursor.getString(mCursor.getColumnIndex("FA3")));
        currentValues.put("FA4", mCursor.getString(mCursor.getColumnIndex("FA4")));
        currentValues.put("FA5", mCursor.getString(mCursor.getColumnIndex("FA5")));
        currentValues.put("GO1", mCursor.getString(mCursor.getColumnIndex("GO1")));
        currentValues.put("GO2", mCursor.getString(mCursor.getColumnIndex("GO2")));
        currentValues.put("GO3", mCursor.getString(mCursor.getColumnIndex("GO3")));
        currentValues.put("GO4", mCursor.getString(mCursor.getColumnIndex("GO4")));
        currentValues.put("GO5", mCursor.getString(mCursor.getColumnIndex("GO5")));
        currentValues.put("GR1", mCursor.getString(mCursor.getColumnIndex("GR1")));
        currentValues.put("GR2", mCursor.getString(mCursor.getColumnIndex("GR2")));
        currentValues.put("GR3", mCursor.getString(mCursor.getColumnIndex("GR3")));
        currentValues.put("GR4", mCursor.getString(mCursor.getColumnIndex("GR4")));
        currentValues.put("GR5", mCursor.getString(mCursor.getColumnIndex("GR5")));
        currentValues.put("SU1", mCursor.getString(mCursor.getColumnIndex("SU1")));
        currentValues.put("SU2", mCursor.getString(mCursor.getColumnIndex("SU2")));
        currentValues.put("SU3", mCursor.getString(mCursor.getColumnIndex("SU3")));
        currentValues.put("SU4", mCursor.getString(mCursor.getColumnIndex("SU4")));
        currentValues.put("SU5", mCursor.getString(mCursor.getColumnIndex("SU5")));
        currentValues.put("REFRESH", mCursor.getInt(mCursor.getColumnIndex("REFRESH")));
        //important line:
        currentValues.put("FP", mCursor.getInt(mCursor.getColumnIndex("REFRESH")));
        currentValues.put("PS1", mCursor.getInt(mCursor.getColumnIndex("PS1")) > 0);
        currentValues.put("PS2", mCursor.getInt(mCursor.getColumnIndex("PS2")) > 0);
        currentValues.put("PS3", mCursor.getInt(mCursor.getColumnIndex("PS3")) > 0);
        currentValues.put("PS4", mCursor.getInt(mCursor.getColumnIndex("PS4")) > 0);
        currentValues.put("MS1", mCursor.getInt(mCursor.getColumnIndex("MS1")) > 0);
        currentValues.put("MS2", mCursor.getInt(mCursor.getColumnIndex("MS2")) > 0);
        currentValues.put("MS3", mCursor.getInt(mCursor.getColumnIndex("MS3")) > 0);
        currentValues.put("MS4", mCursor.getInt(mCursor.getColumnIndex("MS4")) > 0);

        mCursor.close();

        context.getContentResolver().update(
                MyContentProvider.CONTENT_URI,
                currentValues,
                "NAME == " + charName,
                null);
    }

    public void UpdateCharacterStress(Context context, String charName, Bundle charData){
        Boolean ps1 = charData.getBoolean("PS1");
        Boolean ps2 = charData.getBoolean("PS2");
        Boolean ps3 = charData.getBoolean("PS3");
        Boolean ps4 = charData.getBoolean("PS4");
        Boolean ms1 = charData.getBoolean("MS1");
        Boolean ms2 = charData.getBoolean("MS2");
        Boolean ms3 = charData.getBoolean("MS3");
        Boolean ms4 = charData.getBoolean("MS4");

        ContentValues currentValues = new ContentValues();

        Cursor mCursor = context.getContentResolver().query(
                MyContentProvider.CONTENT_URI,
                null,
                "NAME ==" + charName,
                null,
                null
        );
        mCursor.moveToFirst();

        currentValues.put("NAME", mCursor.getString(mCursor.getColumnIndex("NAME")));
        currentValues.put("DESCRIPTION", mCursor.getString(mCursor.getColumnIndex("DESCRIPTION")));
        currentValues.put("ASPECTS", mCursor.getString(mCursor.getColumnIndex("ASPECTS")));
        currentValues.put("STUNTS", mCursor.getString(mCursor.getColumnIndex("STUNTS")));
        currentValues.put("EXTRAS", mCursor.getString(mCursor.getColumnIndex("EXTRAS")));
        currentValues.put("C2", mCursor.getString(mCursor.getColumnIndex("C2")));
        currentValues.put("C4", mCursor.getString(mCursor.getColumnIndex("C4")));
        currentValues.put("C6", mCursor.getString(mCursor.getColumnIndex("C6")));
        currentValues.put("AV1", mCursor.getString(mCursor.getColumnIndex("AV1")));
        currentValues.put("AV2", mCursor.getString(mCursor.getColumnIndex("AV2")));
        currentValues.put("AV3", mCursor.getString(mCursor.getColumnIndex("AV3")));
        currentValues.put("AV4", mCursor.getString(mCursor.getColumnIndex("AV4")));
        currentValues.put("AV5", mCursor.getString(mCursor.getColumnIndex("AV5")));
        currentValues.put("FA1", mCursor.getString(mCursor.getColumnIndex("FA1")));
        currentValues.put("FA2", mCursor.getString(mCursor.getColumnIndex("FA2")));
        currentValues.put("FA3", mCursor.getString(mCursor.getColumnIndex("FA3")));
        currentValues.put("FA4", mCursor.getString(mCursor.getColumnIndex("FA4")));
        currentValues.put("FA5", mCursor.getString(mCursor.getColumnIndex("FA5")));
        currentValues.put("GO1", mCursor.getString(mCursor.getColumnIndex("GO1")));
        currentValues.put("GO2", mCursor.getString(mCursor.getColumnIndex("GO2")));
        currentValues.put("GO3", mCursor.getString(mCursor.getColumnIndex("GO3")));
        currentValues.put("GO4", mCursor.getString(mCursor.getColumnIndex("GO4")));
        currentValues.put("GO5", mCursor.getString(mCursor.getColumnIndex("GO5")));
        currentValues.put("GR1", mCursor.getString(mCursor.getColumnIndex("GR1")));
        currentValues.put("GR2", mCursor.getString(mCursor.getColumnIndex("GR2")));
        currentValues.put("GR3", mCursor.getString(mCursor.getColumnIndex("GR3")));
        currentValues.put("GR4", mCursor.getString(mCursor.getColumnIndex("GR4")));
        currentValues.put("GR5", mCursor.getString(mCursor.getColumnIndex("GR5")));
        currentValues.put("SU1", mCursor.getString(mCursor.getColumnIndex("SU1")));
        currentValues.put("SU2", mCursor.getString(mCursor.getColumnIndex("SU2")));
        currentValues.put("SU3", mCursor.getString(mCursor.getColumnIndex("SU3")));
        currentValues.put("SU4", mCursor.getString(mCursor.getColumnIndex("SU4")));
        currentValues.put("SU5", mCursor.getString(mCursor.getColumnIndex("SU5")));
        currentValues.put("REFRESH", mCursor.getInt(mCursor.getColumnIndex("REFRESH")));
        currentValues.put("FP", mCursor.getInt(mCursor.getColumnIndex("FP")));
        currentValues.put("PS1", ps1);
        currentValues.put("PS2", ps2);
        currentValues.put("PS3", ps3);
        currentValues.put("PS4", ps4);
        currentValues.put("MS1", ms1);
        currentValues.put("MS2", ms2);
        currentValues.put("MS3", ms3);
        currentValues.put("MS4", ms4);

        mCursor.close();

        context.getContentResolver().update(
                MyContentProvider.CONTENT_URI,
                currentValues,
                "NAME == " + charName,
                null);
    }
}
