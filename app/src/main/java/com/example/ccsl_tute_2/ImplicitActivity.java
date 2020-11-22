package com.example.ccsl_tute_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static java.net.Proxy.Type.HTTP;

public class ImplicitActivity extends AppCompatActivity {

    Button emailBtn , browserOpen , msgBtn , btnMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit);

        emailBtn = findViewById(R.id.startEmaitBtn);
        browserOpen = findViewById(R.id.browserBtn);
        msgBtn = findViewById(R.id.txtBtn);
        btnMusic = findViewById(R.id.musicBtn);

        final Intent startEmailIntent = new Intent(Intent.ACTION_SEND);

        startEmailIntent.setData(Uri.parse("mailto:"));

        startEmailIntent.putExtra(Intent.EXTRA_EMAIL , new  String[] {"parackrama@gmail.com"});
        startEmailIntent.putExtra(Intent.EXTRA_SUBJECT , "Sample Subject");
        startEmailIntent.putExtra(Intent.EXTRA_TEXT , "Mahendra Parackrama Thammita");

        startEmailIntent.setType("message/rfc822");

        emailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(startEmailIntent);
            }
        });

        //Open Web browser Intent

        Uri uri = Uri.parse("https://developer.android.com/guide/components/intents-common#Browser");
        final Intent webIntent = new Intent(Intent.ACTION_VIEW , uri);
        //webIntent.setData(Uri.parse("https://developer.android.com/guide/components/intents-common#Browser"));
        //webIntent.setType("text/plain");

        final Intent chooserWeb = Intent.createChooser(webIntent , "Select One");

        browserOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(chooserWeb);
            }
        });

        //Open text message
        Intent txtIntent = new Intent(Intent.ACTION_SENDTO);
        txtIntent.setData(Uri.parse("smsto:0716292892"));
        txtIntent.putExtra("sms_body", "My name is Mahendra");
        //txtIntent.setType(HTTP.PLAIN_TEXT_TYPE);
        final Intent choosetTxt = Intent.createChooser(txtIntent , "Select One");

        msgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(choosetTxt);
            }
        });

        //Open Music
        Intent musicIntent = new Intent(Intent.ACTION_VIEW);
        musicIntent.setData(Uri.parse("file:"));
        musicIntent.setType("audio/*");
        final Intent musicChooser = Intent.createChooser(musicIntent , "Select One");

        btnMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(musicChooser);
            }
        });






    }
}