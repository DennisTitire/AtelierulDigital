package com.example.aninterface.login;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.aninterface.R;

@SuppressLint("Registered")

public class LoginActivity extends AppCompatActivity {

    private EditText edEmail;
    private EditText edPhone;
    private CheckBox tc;

    protected void onCreate(@Nullable Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);

            setContentView(R.layout.activity_login);

        edEmail = findViewById(R.id.et_email);
        edPhone = findViewById(R.id.et_password);
        tc = findViewById(R.id.cb_t_c);

        findViewById(R.id.b_submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tc.isChecked()) {
                    handleSubmit(edEmail.getText(), edPhone.getText());
                } else {
                    Toast.makeText(LoginActivity.this,
                            "You have to accept terms & conditions",
                            Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });
    }

    private void handleSubmit(CharSequence email, CharSequence phone) {
        boolean isError = false;
        if (email == null || email.length() == 0) {
            // email error
            edEmail.setError("Email can't be empty!");
            isError = true;
        }

        if (phone == null || phone.length() == 0) {
            // phone error
            edPhone.setError("Phone can't be empty!");
            isError = true;
        }

        if (!isError) {
            //submit data
            Toast.makeText(this, "Well done", Toast.LENGTH_SHORT).show();
            //clear imput data
            edEmail.setText("");
            edPhone.setText("");
        }
    }
}
