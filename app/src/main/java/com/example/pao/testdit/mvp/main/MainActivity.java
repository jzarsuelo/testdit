package com.example.pao.testdit.mvp.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.pao.testdit.R;
import com.example.pao.testdit.mvp.form.FormActivity;
import com.example.pao.testdit.mvp.main.adapter.TopicAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity
        implements MainContract.View {

    public static final String LOG_TAG = MainActivity.class.getSimpleName();

    public static final int CREATE_TOPIC_REQUEST = 1;

    @BindView(R.id.rv_topics)
    RecyclerView mRvTopics;

    TopicAdapter mTopicAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRvTopics.setLayoutManager(layoutManager);
        mRvTopics.setHasFixedSize(false);

        mTopicAdapter = new TopicAdapter();
        mRvTopics.setAdapter(mTopicAdapter);
    }

    @OnClick(R.id.fab_to_form)
    void onClickFabToForm() {
        Intent i = new Intent(this, FormActivity.class);
        startActivityForResult(i, CREATE_TOPIC_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Refresh data only when topic is created successfully
        if (requestCode == CREATE_TOPIC_REQUEST  && resultCode  == RESULT_OK) {
            mTopicAdapter.notifyDataSetChanged();
        }
    }
}
