package com.example.aninterface.week4;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.aninterface.R;

        public class RecyclerViewActivity extends AppCompatActivity {

            RecyclerView recyclerView;

            String[] s1;
            String[] s2;
            int[] images = {R.drawable.c_plus_plus, R.drawable.c_sharp, R.drawable.java, R.drawable.javascript, R.drawable.kotlin, R.drawable.python, R.drawable.ruby, R.drawable.swift, R.drawable.typescript, R.drawable.visual_studio};

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);

                setContentView(R.layout.activity_recycler_view);

                recyclerView = findViewById(R.id.recyclerView);

                s1 = getResources().getStringArray(R.array.programming_languages);
                s2 = getResources().getStringArray(R.array.description);

                MyAdapter myAdapter = new MyAdapter(this, s1, s2, images);
                recyclerView.setAdapter(myAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

    }
}

