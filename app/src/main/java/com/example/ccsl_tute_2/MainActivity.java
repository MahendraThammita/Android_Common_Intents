package com.example.ccsl_tute_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static String Tag = "Hello ";
    public int score = 0;

    private Button btn , changer , sendOneValbtn , sendMultiBtn;
    private TextView textfield;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(Tag , "onCreate");

        sendOneValbtn = findViewById(R.id.sendOneValBtn);
        sendMultiBtn = findViewById(R.id.sendMultiValBtn);

        String name = "Mahendra Thammita";
        int age = 24;
        final Intent sendOneVal = new Intent(this , Activity2.class);
        sendOneVal.putExtra("NAME" , name);

        //Sending multiple values With Intent

        String University = "SLIIT";
        int year = 2;
        double batch = 7.1;

        Bundle bundlrFotSend = new Bundle();
        bundlrFotSend.putString("UNI" , University);
        bundlrFotSend.putInt("YEAR" , year);
        bundlrFotSend.putDouble("BATCH" , batch);

        final Intent sendMultipleIntent = new Intent(this , Activity2.class);
        sendMultipleIntent.putExtras(bundlrFotSend);

        sendMultiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(sendMultipleIntent);
            }
        });




        sendOneValbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(sendOneVal);
            }
        });


        btn = findViewById(R.id.button1);
        final Intent tonext = new Intent(getApplicationContext() , Activity2.class);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(tonext);
            }
        });

        changer = findViewById(R.id.textChanger);
        textfield = findViewById(R.id.changingText);

        changer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textfield.setText("Hello Mahendra");
            }
        });

        try {
            if(savedInstanceState != null){
                int temp = savedInstanceState.getInt("intScore");

                if (temp == 0){
                    Log.i(Tag , "saved Instance State : Null");
                }
                else
                    Log.i(Tag , "saved Instance State : Not Null");
                    Log.i(Tag , String.valueOf(temp));

            }
        } catch (NullPointerException ex){
            Log.i(Tag ,"Null pointer Exception Occoured");
        }


    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(Tag , "OnResume");
        score++;
        Log.i(Tag , "Score = : " + score);
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i(Tag , "onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(Tag , "onPause");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {

        Log.i(Tag , "onSaveInstanceState");
        outState.putInt("intScore" , score + 10 );


        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(Tag , "onRestart");
    }



    @Override
    protected void onStop() {
        super.onStop();
        Log.i(Tag , "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(Tag , "onDestroy");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(Tag , "onRestoreInstanceState");
        int temp = savedInstanceState.getInt("intScore");
        Log.i("saved state" , String.valueOf(temp));
    }

    public void toAct2(View view) {
        Intent methodIntent = new Intent(this , Activity2.class);
        startActivity(methodIntent);
    }

    public void toImpli(View view){
        Intent in = new Intent(this , ImplicitActivity.class);
        startActivity(in);
    }

}