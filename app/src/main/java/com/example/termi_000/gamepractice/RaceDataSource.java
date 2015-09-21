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
        dbhelper = new RaceOpenDBHelper(context);
    }

    void open(){
        database = dbhelper.getWritableDatabase();

    }

    void close(){
        dbhelper.close();
    }

    public Race create(Race race){
        ContentValues values = new ContentValues();
//        values.put(RaceOpenDBHelper.COLUMN_RACE, race.getRace());
        values.put(RaceOpenDBHelper.COLUMN_RACE, race.getRace());
        values.put(RaceOpenDBHelper.COLUMN_STRENGTH, race.getStrength());
        values.put(RaceOpenDBHelper.COLUMN_DEXTERITY, race.getDexterity());
        values.put(RaceOpenDBHelper.COLUMN_CONSTITUTION, race.getConstitution());
        values.put(RaceOpenDBHelper.COLUMN_INTELLIGENCE, race.getIntelligence());
        values.put(RaceOpenDBHelper.COLUMN_WISDOM, race.getWisdom());
        values.put(RaceOpenDBHelper.COLUMN_CHARISMA, race.getCharisma());
        values.put(RaceOpenDBHelper.COLUMN_SIZE, race.getSize());

        long insertId = database.insert(RaceOpenDBHelper.COLUMN_TITLE, null, values);
//        race.setId(insertId);
        return race;

    }
}
