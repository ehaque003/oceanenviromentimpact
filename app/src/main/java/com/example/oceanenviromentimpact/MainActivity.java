package com.example.oceanenviromentimpact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    static AppDataDBHelper dbhelperone = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbhelperone = new AppDataDBHelper(getBaseContext());
        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        boolean hasUsedAppOnceBefore = sh.getBoolean("usedAppFirstTime", true);
        if(hasUsedAppOnceBefore){
            Intent intent = new Intent(MainActivity.this, basecheckactivity.class);
            startActivity(intent);
        }
        else{
            setContentView(R.layout.activity_main);
            variable.sizeofthetrashbag = sh.getInt("sizeOfTrashBag", 10);
            Button impactpage = findViewById(R.id.impactpagechanger);
            Button wastertrackerpage = findViewById(R.id.wastertrackerpage);
            impactpage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, impactpage.class);
                    intent.putExtra("showImprovment", 0);
                    startActivity(intent);
                }
            });
            wastertrackerpage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, wastetrackerpage.class);
                    startActivity(intent);
                }
            });
        }

    }
}