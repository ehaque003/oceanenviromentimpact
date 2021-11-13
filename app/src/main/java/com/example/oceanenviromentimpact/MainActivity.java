package com.example.oceanenviromentimpact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button impactpage = findViewById(R.id.impactpagechanger);
        Button wastertrackerpage = findViewById(R.id.wastertrackerpage);
        impactpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, impactpage.class);
                intent.putExtra("showImprovment", false);
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