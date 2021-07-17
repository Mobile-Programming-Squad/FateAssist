package com.example.fateassist;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

public class MyContentProvider extends ContentProvider {
    public final static String DBNAME = "charData";
    public static final Uri CONTENT_URI = Uri.parse("content://com.example.fateassist.provider");
    private static final String SQL_CREATE_MAIN =
            "CREATE TABLE Chars ( " +
                    "_ID INTEGER PRIMARY KEY, " +
                    "CHAR_NAME TEXT, " +
                    "DESCRIPTION TEXT, " +
                    "ASPECTS TEXT, " +
                    "STUNTS TEXT, " +
                    "EXTRAS TEXT, " +
                    "C2 TEXT, " +
                    "C4 TEXT, " +
                    "C6 TEXT, " +
                    "AV1 TEXT, " +
                    "AV2 TEXT, " +
                    "AV3 TEXT, " +
                    "AV4 TEXT, " +
                    "AV5 TEXT, " +
                    "FA1 TEXT, " +
                    "FA2 TEXT, " +
                    "FA3 TEXT, " +
                    "FA4 TEXT, " +
                    "FA5 TEXT, " +
                    "GO1 TEXT, " +
                    "GO2 TEXT, " +
                    "GO3 TEXT, " +
                    "GO4 TEXT, " +
                    "GO5 TEXT, " +
                    "GR1 TEXT, " +
                    "GR2 TEXT, " +
                    "GR3 TEXT, " +
                    "GR4 TEXT, " +
                    "GR5 TEXT, " +
                    "SU1 TEXT, " +
                    "SU2 TEXT, " +
                    "SU3 TEXT, " +
                    "SU4 TEXT, " +
                    "SU5 TEXT, " +
                    "REFRESH INT, " +
                    "FP INT, " +
                    "IMG BLOB, " +
                    "PS1 BOOL, " +
                    "PS2 BOOL, " +
                    "PS3 BOOL, " +
                    "PS4 BOOL, " +
                    "MS1 BOOL, " +
                    "MS2 BOOL, " +
                    "MS3 BOOL, " +
                    "MS4 BOOL )";

    protected static final class MainDatabaseHelper extends SQLiteOpenHelper {
        MainDatabaseHelper(Context context) {
            super(context, DBNAME, null, 1);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SQL_CREATE_MAIN);
        }
        @Override
        public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        }
    }

    MainDatabaseHelper mOpenHelper;

    public void charData() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return mOpenHelper.getWritableDatabase().
                delete("Chars", selection, selectionArgs);
    }

    //we shouldn't need this
    @Override
    public String getType(Uri uri) {
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        long id = mOpenHelper.getWritableDatabase().insert("Chars", null, values);
        return Uri.withAppendedPath(CONTENT_URI, "" + id);
    }


    @Override
    public boolean onCreate() {
        mOpenHelper = new MainDatabaseHelper(getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        return mOpenHelper.getWritableDatabase().query("Chars", projection, selection, selectionArgs, null, null, sortOrder);
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        return mOpenHelper.getWritableDatabase().update("Chars", values, selection, selectionArgs);
    }
}