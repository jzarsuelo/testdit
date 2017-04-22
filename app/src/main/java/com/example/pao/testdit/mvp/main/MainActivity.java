package com.example.pao.testdit.mvp.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.pao.testdit.R;
import com.example.pao.testdit.mvp.form.FormActivity;
import com.example.pao.testdit.mvp.main.adapter.TopicAdapter;
import com.example.pao.testdit.util.TempStorageUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity
        implements MainContract.View {

    public static final String LOG_TAG = MainActivity.class.getSimpleName();

    public static final int CREATE_TOPIC_REQUEST = 1;

    @BindView(R.id.rv_topics)
    RecyclerView mRvTopics;

    @BindView(R.id.tv_empty_data)
    TextView mTvEmptyData;

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

        toggleRvTopicVisibility();
    }

    @OnClick(R.id.fab_to_form)
    void onClickFabToForm() {
        Intent i = new Intent(this, FormActivity.class);
        startActivityForResult(i, CREATE_TOPIC_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CREATE_TOPIC_REQUEST  && resultCode  == RESULT_OK) {
            toggleRvTopicVisibility();
        }
    }

    /**
     * Helper method to show {@link #mRvTopics}, if the data count is more than 0
     */
    private void toggleRvTopicVisibility() {
        if ( TempStorageUtil.getCount() == 0 ) {
            mRvTopics.setVisibility(View.INVISIBLE);
            mTvEmptyData.setVisibility(View.VISIBLE);
        } else {
            mRvTopics.setVisibility(View.VISIBLE);
            mTvEmptyData.setVisibility(View.INVISIBLE);
        }
    }
}
