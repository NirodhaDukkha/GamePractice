package com.example.termi_000.gamepractice;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by termi_000 on 9/10/2015.
 */
public class RaceDataSource {

    SQLiteOpenHelper dbhelper;
    SQLiteDatabase database;

    public RaceDataSource(Context context){
        dbhelper = new DatabaseHelper(context);
    }

    void open(){
        database = dbhelper.getWritableDatabase();

    }

    void close(){
        dbhelper.close();
    }

    public Race create(Race race){
        ContentValues values = new ContentValues();
//        values.put(DatabaseHelper.COLUMN_RACE, race.getRace());
        values.put(DatabaseHelper.COLUMN_RACE, race.getRace());
        values.put(DatabaseHelper.COLUMN_STRENGTH, race.getStrength());
        values.put(DatabaseHelper.COLUMN_DEXTERITY, race.getDexterity());
        values.put(DatabaseHelper.COLUMN_CONSTITUTION, race.getConstitution());
        values.put(DatabaseHelper.COLUMN_INTELLIGENCE, race.getIntelligence());
        values.put(DatabaseHelper.COLUMN_WISDOM, race.getWisdom());
        values.put(DatabaseHelper.COLUMN_CHARISMA, race.getCharisma());
        values.put(DatabaseHelper.COLUMN_SIZE, race.getSize());

        long insertId = database.insert(DatabaseHelper.COLUMN_TITLE, null, values);
//        race.setId(insertId);
        return race;

    }
}
