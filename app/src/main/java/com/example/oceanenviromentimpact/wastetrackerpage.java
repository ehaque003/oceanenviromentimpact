package com.example.oceanenviromentimpact;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class wastetrackerpage extends AppCompatActivity {

    TextView choiceshower, improvementtextshower;
    Button yesbutton, nobutton, enterbutton, impactpagemover;
    EditText answer;
    int amountoftrash = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wastetrackerpage);
        choiceshower = findViewById(R.id.choicegiver);
        yesbutton = findViewById(R.id.yesbutton);
        nobutton = findViewById(R.id.nobutton);
        enterbutton = findViewById(R.id.enterbutton);
        answer = findViewById(R.id.amountoftrashmadethatentry);
        improvementtextshower = findViewById(R.id.improvmenttextshower);
        impactpagemover = findViewById(R.id.impactpagemover);

        yesbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choiceshower.setText("Please type in the exact amount of trash in pounds");
                yesbutton.setVisibility(View.INVISIBLE);
                nobutton.setVisibility(View.INVISIBLE);
                answer.setVisibility(View.VISIBLE);
                enterbutton.setVisibility(View.VISIBLE);
            }
        });
        enterbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                amountoftrash = Integer.parseInt(answer.getText().toString());
                choiceshower.setVisibility(View.INVISIBLE);
                answer.setVisibility(View.INVISIBLE);
                improvmentspeechmaker();
            }

        });

    }

    public void improvmentspeechmaker(){
        int improvementmarker = variable.averagewastecount-amountoftrash;
        String improvementspeaker = "";
        if(improvementmarker == 0){
            improvementspeaker = "You have done much so far, but keep going! The app believes in you!";
        }
        else if (improvementmarker < 0){
            improvementmarker = Math.abs(improvementmarker);
            improvementspeaker = "You have wasted " +improvementmarker+ " more pounds than usual. Try your best to keep up the average or better!";
        }
        else{
            improvementspeaker = "You have improved by " +improvementmarker+ " pounds of waste. Keep up with the great work!";
            impactpagemover.setVisibility(View.VISIBLE);
        }
        enterbutton.setVisibility(View.INVISIBLE);
        improvementtextshower.setVisibility(View.VISIBLE);
        improvementtextshower.setText(improvementspeaker);

    }
}