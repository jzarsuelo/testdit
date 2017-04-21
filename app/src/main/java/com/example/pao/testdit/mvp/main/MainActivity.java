package com.example.pao.testdit.mvp.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.pao.testdit.R;

public class MainActivity extends AppCompatActivity
        implements MainContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
