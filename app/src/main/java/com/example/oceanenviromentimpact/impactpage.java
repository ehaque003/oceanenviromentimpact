package com.example.oceanenviromentimpact;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class impactpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_impactpage);
        EditText trashremoval = findViewById(R.id.poundsoftrashoutoftheocean);
        Button enter = findViewById(R.id.enter);
        TextView marinelifesavecount = findViewById(R.id.marinewildlifesavecount);
        TextView oceanareasavecount = findViewById(R.id.oceansavedsize);
        TextView humanpeoplesavecount = findViewById(R.id.humansavedcount);
    }
}