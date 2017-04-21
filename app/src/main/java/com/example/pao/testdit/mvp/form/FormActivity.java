package com.example.pao.testdit.mvp.form;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.pao.testdit.R;

public class FormActivity extends AppCompatActivity
            implements FormContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
    }

    @Override
    public void showSuccessMessage() {
        Toast.makeText(this, getString(R.string.insert_topic_success), Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    public void navigateToHome() {
        finish();
    }

    @Override
    public void showFailedMessage() {
        Toast.makeText(this, getString(R.string.insert_topic_failed), Toast.LENGTH_SHORT)
                .show();
    }
}
