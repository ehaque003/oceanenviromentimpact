package com.example.oceanenviromentimpact;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class impactpage extends AppCompatActivity {
    int poundsoftrashinputted = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_impactpage);
        EditText trashremoval = findViewById(R.id.poundsoftrashoutoftheocean);
        Button enter = findViewById(R.id.enter);
        TextView marinelifesavecount = findViewById(R.id.marinewildlifesavecount);
        TextView oceanareasavecount = findViewById(R.id.oceansavedsize);
        TextView humanpeoplesavecount = findViewById(R.id.humansavedcount);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poundsoftrashinputted = Integer.getInteger(trashremoval.getEditableText().toString());
            }
        });
        int marinelifeint = Math.round(poundsoftrashinputted/176);
        marinelifesavecount.setText(marinelifeint);
        int oceansaveint = Math.round(poundsoftrashinputted);
        int humansaveint =(int)(poundsoftrashinputted*.5);
        oceanareasavecount.setText(oceansaveint);
        humanpeoplesavecount.setText(humansaveint);

    }
}