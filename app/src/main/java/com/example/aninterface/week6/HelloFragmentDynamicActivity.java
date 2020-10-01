package com.example.aninterface.week6;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.aninterface.R;

public class HelloFragmentDynamicActivity extends AppCompatActivity implements TheListener{

    public static final String EXTRA_KEY_INT = "extra_key_int";
    public static final String EXTRA_KEY_STRING = "extra_key_string";
    private Object helloFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_hello_fragment_dynamic);

        HelloFragment helloFragment = new HelloFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(EXTRA_KEY_INT, 101);
        bundle.putString(EXTRA_KEY_STRING, "Dalmatieni");
        helloFragment.setArguments(bundle);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_placeholder, helloFragment, "Hellofragment");
        fragmentTransaction.commit();
    }

    public void showFragment(View view) {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag("HelloFragment");
        if (fragment instanceof HelloFragment) {
            ((HelloFragment) fragment).showCurrentFragmentName();

        }
    }

    @Override
    public void doSomeWork(String text) {
        Toast.makeText(this, "Recived from fragment:\n" + text , Toast.LENGTH_LONG).show();
    }
}
