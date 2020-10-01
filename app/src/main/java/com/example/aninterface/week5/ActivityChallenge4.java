package com.example.aninterface.week5;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.aninterface.R;

public class ActivityChallenge4 extends AppCompatActivity {

    private static final int REQUEST_CALL = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge4);

        final EditText et_url = findViewById(R.id.url_et);
        Button button_url = findViewById(R.id.url_btn);

        final EditText et_location = findViewById(R.id.location_et);
        Button button_location = findViewById(R.id.location_btn);

        final EditText et_share = findViewById(R.id.share_et);
        Button button_share = findViewById(R.id.share_btn);

        final EditText et_call = findViewById(R.id.call_et);
        Button button_call = findViewById(R.id.call_btn);

        button_url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = et_url.getText().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });

        button_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String location = et_location.getText().toString();
                Uri gmmIntentUri = Uri.parse("geo:45.455492,28.023079");
                Intent intent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            }
        });

        button_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String share = et_share.getText().toString();
                Intent sendintent = new Intent();
                sendintent.setAction(Intent.ACTION_SEND);
                sendintent.putExtra(Intent.EXTRA_TEXT, share);
                sendintent.setType("text/plain");
                Intent shareintent = Intent.createChooser(sendintent, null);
                startActivity(shareintent);
            }
        });

        button_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numar = et_call.getText().toString();
                String dial = "tel:" + numar;
                if (ActivityCompat.checkSelfPermission(ActivityChallenge4.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(ActivityChallenge4.this, new String[] {Manifest.permission.CALL_PHONE}, REQUEST_CALL);
                } else {
                    startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
                }
            }
        });

    }
}
