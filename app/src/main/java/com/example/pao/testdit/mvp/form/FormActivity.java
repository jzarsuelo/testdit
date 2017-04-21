package com.example.pao.testdit.mvp.form;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.pao.testdit.R;

public class FormActivity extends AppCompatActivity
            implements FormContract.View{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
    }

    @Override
    public void showSuccessMessage() {

    }

    @Override
    public void navigateToHome() {

    }

    @Override
    public void showFailedMessage() {

    }
}
