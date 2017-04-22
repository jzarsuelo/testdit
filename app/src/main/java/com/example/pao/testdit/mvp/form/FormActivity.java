package com.example.pao.testdit.mvp.form;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pao.testdit.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FormActivity extends AppCompatActivity
            implements FormContract.View {

    private FormContract.Presenter mPresenter;

    @BindView(R.id.topic_name_et)
    EditText mTopicNameEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        ButterKnife.bind(this);

        mPresenter = new FormPresenter(this);

        setTitle(getString(R.string.create_topic));
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void showSuccessMessage() {
        Toast.makeText(this, getString(R.string.insert_topic_success), Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    public void navigateToHome() {
        setResult(RESULT_OK, getIntent());
        finish();
    }

    @Override
    public void showFailedMessage() {
        Toast.makeText(this, getString(R.string.insert_topic_failed), Toast.LENGTH_SHORT)
                .show();
    }

    @OnClick(R.id.create_button)
    public void onCreateTopic() {
        String topicName = mTopicNameEdit.getText().toString();

        mPresenter.createTopic(topicName);
    }
}
