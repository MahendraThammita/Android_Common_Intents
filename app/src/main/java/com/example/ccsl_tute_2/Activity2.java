package com.example.ccsl_tute_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    private Button btn;
    private TextView oneValName , uniVal , yearVal , batchVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        oneValName = findViewById(R.id.recievedVal);
        btn = findViewById(R.id.button2);
        uniVal = findViewById(R.id.recievedVal5);
        yearVal = findViewById(R.id.recievedVal6);
        batchVal = findViewById(R.id.recievedVal7);


        Intent oneValGetIntent = getIntent();
        String nameOne = oneValGetIntent.getStringExtra("NAME");
        oneValName.setText(nameOne);


        //getting Multiple values from an Intent

        Intent getMultiIntent = getIntent();
        Bundle recievedBunndle = getMultiIntent.getExtras();

        uniVal.setText(recievedBunndle.getString("UNI"));
        yearVal.setText(String.valueOf(recievedBunndle.getInt("YEAR")));
        batchVal.setText(String.valueOf(recievedBunndle.getDouble("BATCH" , 0)));




        final Intent toBack = new Intent(getApplicationContext() , MainActivity.class);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(toBack);
            }
        });


    }
}