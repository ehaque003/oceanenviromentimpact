package com.example.oceanenviromentimpact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class impactpage extends AppCompatActivity {
    int poundsoftrashinputted = 0;
    TextView marinelifesavecount, oceanareasavecount, humanpeoplesavecount, textview, textview2, textView3, infoshower;
    EditText trashremoval;
    Button enter, gobacktohomepage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_impactpage);
        trashremoval = findViewById(R.id.poundsoftrashoutoftheocean);
        enter = findViewById(R.id.enter);
        marinelifesavecount = findViewById(R.id.marinewildlifesavecount);
        oceanareasavecount = findViewById(R.id.oceansavedsize);
        humanpeoplesavecount = findViewById(R.id.humansavedcount);
        textview = findViewById(R.id.textView3);
        textview2 = findViewById(R.id.textView5);
        textView3 = findViewById(R.id.textView7);
        gobacktohomepage = findViewById(R.id.gobacktohomepage);
        infoshower = findViewById(R.id.infoshower);
        Intent intent = getIntent();
        int improvement = intent.getIntExtra("showImprovment", 0);
        if(improvement == 0){
            enter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showandhide();
                    poundsoftrashinputted = Integer.parseInt(trashremoval.getEditableText().toString());
                    showimpact();
                }
            });
        }
        else{
            showandhide();
            poundsoftrashinputted = improvement;
            showimpact();
        }
    }

    public void showimpact(){
        infoshower.setText("Impact of "+poundsoftrashinputted+" pounds of waste out of the ocean: ");
        int marinelifeint = Math.round(poundsoftrashinputted/176);
        marinelifesavecount.setText(String.valueOf(marinelifeint));
        int oceansaveint = Math.round(poundsoftrashinputted);
        int humansaveint =(int)(poundsoftrashinputted*.5);
        oceanareasavecount.setText(String.valueOf(oceansaveint));
        humanpeoplesavecount.setText(String.valueOf(humansaveint));
        gobacktohomepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(impactpage.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void showandhide(){
        trashremoval.setVisibility(View.INVISIBLE);
        enter.setVisibility(View.INVISIBLE);
        marinelifesavecount.setVisibility(View.VISIBLE);
        oceanareasavecount.setVisibility(View.VISIBLE);
        humanpeoplesavecount.setVisibility(View.VISIBLE);
        textview.setVisibility(View.VISIBLE);
        textview2.setVisibility(View.VISIBLE);
        textView3.setVisibility(View.VISIBLE);
        gobacktohomepage.setVisibility(View.VISIBLE);
        infoshower.setVisibility(View.VISIBLE);
    }
}