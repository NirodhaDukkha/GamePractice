package com.example.termi_000.gamepractice;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by termi_000 on 9/8/2015.
 */
public class RaceOpenDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "race.db";
    public static final int DATABASE_VERSION = 1;

    public static final String COLUMN_TITLE = "race_table";
    public static final String COLUMN_RACE = "RACE";
    public static final String COLUMN_STRENGTH = "STRENGTH";
    public static final String COLUMN_DEXTERITY = "DEXTERITY";
    public static final String COLUMN_CONSTITUTION = "CONSTITUTION";
    public static final String COLUMN_INTELLIGENCE = "INTELLIGENCE";
    public static final String COLUMN_WISDOM = "WISDOM";
    public static final String COLUMN_CHARISMA = "CHARISMA";
    public static final String COLUMN_SIZE = "SIZE";
    public static final String TABLE_CREATE =
            "CREATE TABLE " + COLUMN_TITLE + " (" +
                    COLUMN_RACE + " TEXT, " +
                    COLUMN_STRENGTH + " INTEGER, " +
                    COLUMN_DEXTERITY + " INTEGER, " +
                    COLUMN_CONSTITUTION + " INTEGER, " +
                    COLUMN_INTELLIGENCE + " INTEGER, " +
                    COLUMN_WISDOM + " INTEGER, " +
                    COLUMN_CHARISMA + " INTEGER, " +
                    COLUMN_SIZE + " TEXT " +
                    ")";


    public RaceOpenDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + COLUMN_TITLE);
        onCreate(db);
    }


}
