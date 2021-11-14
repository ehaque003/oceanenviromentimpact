package com.example.oceanenviromentimpact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class wastetrackerpage extends AppCompatActivity {

    TextView choiceshower, improvementtextshower;
    Button yesbutton, nobutton, enterbutton, impactpagemover;
    EditText answer;
    boolean hasShowedImprovment = false;
    int amountoftrash = 0;
    int sendingint = 0;
    boolean hasExactNumber = false;
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
                hasExactNumber = true;
                yesbutton.setVisibility(View.INVISIBLE);
                nobutton.setVisibility(View.INVISIBLE);
                answer.setVisibility(View.VISIBLE);
                enterbutton.setVisibility(View.VISIBLE);
            }
        });

        nobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choiceshower.setText("Please type in the percentage on how full the trash bin looks like?");
                yesbutton.setVisibility(View.INVISIBLE);
                nobutton.setVisibility(View.INVISIBLE);
                answer.setVisibility(View.VISIBLE);
                enterbutton.setVisibility(View.VISIBLE);
                enterbutton.setHint("Percentage(%)");
            }
        });

        enterbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(hasExactNumber){
                    amountoftrash = Integer.parseInt(answer.getText().toString());
                    choiceshower.setVisibility(View.INVISIBLE);
                    answer.setVisibility(View.INVISIBLE);
                    improvmentspeechmaker();
                }
                else{
                    float percentage =(float)(Integer.parseInt(answer.getText().toString()))/100;
                    amountoftrash = (int)(variable.sizeofthetrashbag*percentage);
                    if(amountoftrash == 0){
                        amountoftrash = 1;
                    }
                    choiceshower.setVisibility(View.INVISIBLE);
                    answer.setVisibility(View.INVISIBLE);
                    improvmentspeechmaker();
                }
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
            hasShowedImprovment = true;
        }
        impactpagemover.setVisibility(View.VISIBLE);
        enterbutton.setVisibility(View.INVISIBLE);
        improvementtextshower.setVisibility(View.VISIBLE);
        improvementtextshower.setText(improvementspeaker);
        sendingint = improvementmarker;
        impactpagemover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                if(hasShowedImprovment){
                    intent = new Intent(wastetrackerpage.this, impactpage.class);
                    intent.putExtra("showImprovment", sendingint);
                }
                else{
                    intent = new Intent(wastetrackerpage.this, MainActivity.class);
                }
                startActivity(intent);
            }
        });
    }
}