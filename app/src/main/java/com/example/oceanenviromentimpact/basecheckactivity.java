package com.example.oceanenviromentimpact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class basecheckactivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basecheckactivity);
        EditText input = findViewById(R.id.sizeofthetrashbag);
        Button done = findViewById(R.id.done);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = input.getText().toString();
                variable.sizeofthetrashbag = Integer.parseInt(temp);
                Intent intent = new Intent(basecheckactivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}