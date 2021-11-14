package com.example.oceanenviromentimpact;

import static android.content.Context.MODE_PRIVATE;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class variable {
    static AppDataDBHelper dbHelper = MainActivity.dbhelperone;

    static int sizeofthetrashbag = 10;
    static int averagewastecount = 50;
    static int id = 0;
    static SQLiteDatabase db = dbHelper.getWritableDatabase();



    public static void getAverage(){
            Cursor res = db.rawQuery("select avg(WasteAmount) as t from WASTECOUNT", null);
            res.moveToFirst();
            int avg = res.getInt(res.getColumnIndex("t"));
            Log.i("ENam", "wastecount "+avg);
            averagewastecount = avg;


    }

}
