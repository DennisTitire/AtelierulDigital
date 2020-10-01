package com.example.aninterface.week5;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.aninterface.R;

public class Activity1Challenge2 extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "Activity1Challange2";
    public static final String TEXT_TO_DISPLAY = "text_to_display";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1_challenge2);

        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);

        Log.d(TAG, "onCreate() called with: savedInstanceState = [" + savedInstanceState + "]");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart() called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
           case R.id.btn1:
            goNext1((TextView) v);
            break;
           case R.id.btn2:
            goNext2((TextView) v);
            break;
           case R.id.btn3:
            goNext3((TextView) v);
            break;
        }
    }

    private void goNext1(TextView button) {
        String text = button.getText().toString();
        GoToActivity2Challange2(text);
    }

    private void goNext2(TextView button) {
        String text = button.getText().toString();
        GoToActivity2Challange2(text);

    }

    private void goNext3(TextView button) {
        String text = button.getText().toString();
        GoToActivity2Challange2(text);

    }

    private void GoToActivity2Challange2(String text) {
        Intent intent = new Intent(this, Activity2Challenge2.class);
        intent.putExtra(TEXT_TO_DISPLAY, text);
        startActivity(intent);
    }
}
