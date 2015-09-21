package com.example.termi_000.gamepractice;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.CharArrayBuffer;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.CharArrayReader;

public class MainGameActivity extends Activity {

    RaceDataSource raceData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);
        raceData = new RaceDataSource(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void storeData(View view) {
        EditText dataText = (EditText) findViewById(R.id.editData);
        String inputData = dataText.getText().toString();
        DataStorage.setStoredData(inputData);

    }

    public void switchActivity(View view) {
        Intent switchActivity = new Intent(this, SecondActivity.class);
        switchActivity.putExtra("data", DataStorage.getStoredData());
        startActivity(switchActivity);
    }

    @Override
    protected void onResume() {
        super.onResume();
        raceData.open();
        createData();
        String[] projection = {DatabaseHelper.COLUMN_RACE, DatabaseHelper.COLUMN_STRENGTH};
        String sortOrder = DatabaseHelper.COLUMN_STRENGTH + " DESC";
        Cursor c = raceData.database.query("race_table", projection, null, null, null, null, null);
        c.moveToFirst();
        String strength = "race is" + c.getString(0) + " and strength is " + c.getString(1);
        TextView tvTest = (TextView) findViewById(R.id.tvSQL);
        tvTest.setText(strength);
    }

    @Override
    protected void onPause() {
        super.onPause();
        raceData.close();
    }

    private void createData(){
        Race race = new Race();
        race.setRace("Orc");
        race.setStrength("7");
        raceData.create(race);
    }
}
