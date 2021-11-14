package com.example.oceanenviromentimpact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class basecheckactivity extends AppCompatActivity {

    static AppDataDBHelper dbhelperone = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basecheckactivity);
        EditText input = findViewById(R.id.sizeofthetrashbag);
        Button done = findViewById(R.id.done);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbhelperone = new AppDataDBHelper(getBaseContext());
                String temp = input.getText().toString();
                variable.sizeofthetrashbag = Integer.parseInt(temp);
                SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
                SharedPreferences.Editor myEdit = sharedPreferences.edit();
                myEdit.putBoolean("usedAppFirstTime", false);
                myEdit.putInt("sizeOfTrashBag", variable.sizeofthetrashbag);
                myEdit.putInt("id", 1);
                myEdit.commit();
                insertWasteAmount(5);
                variable.id = 1;
                insertWasteAmount(5);
                Intent intent = new Intent(basecheckactivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public static void insertWasteAmount(int wasteamount){
        SQLiteDatabase db = dbhelperone.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(AppDataRepo.WasteCountEntry.COLUMN_NAME_WASTEAMOUNT, wasteamount);
        contentValues.put(AppDataRepo.WasteCountEntry.COLUMN_NAME_ID, variable.id+1);
        db.insert(AppDataRepo.WasteCountEntry.TABLE_NAME, null, contentValues);
    }
}