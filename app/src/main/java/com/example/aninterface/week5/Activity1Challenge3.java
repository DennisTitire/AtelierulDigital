package com.example.aninterface.week5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.aninterface.R;

public class Activity1Challenge3 extends AppCompatActivity {

    public static final String DISPLAY_TEXT ="Display_text";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1_challenge3);

        Button button = findViewById(R.id.message_send);
        final EditText editText = findViewById(R.id.message_et);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Text = editText.getText().toString();
                Intent intent1 = new Intent(v.getContext(), Activity2Challenge3.class);
                intent1.putExtra(DISPLAY_TEXT, Text);
                startActivity(intent1);
            }
        });
    }
}

