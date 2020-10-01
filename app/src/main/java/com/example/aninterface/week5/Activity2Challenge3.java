package com.example.aninterface.week5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.aninterface.R;

import static com.example.aninterface.week5.Activity1Challenge3.DISPLAY_TEXT;

public class Activity2Challenge3 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_challenge3);

        TextView textView = findViewById(R.id.message_tv);
        Button button = findViewById(R.id.message_send);
        final EditText editText = findViewById(R.id.message_ed2);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Text = editText.getText().toString();
                Intent intent1 = new Intent(v.getContext(), Activity2Challenge3.class);
                intent1.putExtra(DISPLAY_TEXT, Text);
                startActivity(intent1);
            }
        });

        String text1 ="Notfing to recive";
        Intent intent1 = getIntent();
        if (intent1 != null) {
            String textul = intent1.getStringExtra(DISPLAY_TEXT);
            if ( textul != null) {
                text1 = textul;
            }
        }
        textView.setText(text1);
    }
}
