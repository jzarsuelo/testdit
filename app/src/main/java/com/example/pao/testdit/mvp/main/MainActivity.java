package com.example.pao.testdit.mvp.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.pao.testdit.R;
import com.example.pao.testdit.mvp.form.FormActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity
        implements MainContract.View {

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
        startActivity(i);
    }

    
}
