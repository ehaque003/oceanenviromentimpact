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
    static SQLiteDatabase db = dbHelper.getWritableDatabase();



    public static void getAverage(){
            Cursor res = db.rawQuery("select avg(WasteAmount) as t from WASTECOUNT", null);
            res.moveToFirst();
            int avg = res.getInt(res.getColumnIndex("t"));
            Log.i("ENam", "wastecount "+avg);
            averagewastecount = avg;
    }

    public static int sum(){
        Cursor res = db.rawQuery("select sum(WasteAmount) as t from WASTECOUNT", null);
        Cursor res2 = db.rawQuery("select max(_id) as s from WASTECOUNT", null);
        res.moveToFirst();
        res2.moveToFirst();
        int sum = res.getInt(res.getColumnIndex("t"));
        int amount = res2.getInt(res2.getColumnIndex("s"));
        Log.i("sum", ""+sum);
        Log.i("amount", ""+amount);
        int improvment = sum - (averagewastecount*amount);
        return improvment;
    }

}
