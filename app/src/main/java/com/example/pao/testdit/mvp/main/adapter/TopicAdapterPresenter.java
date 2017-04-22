package com.example.pao.testdit.mvp.main.adapter;

import com.example.pao.testdit.model.Topic;
import com.example.pao.testdit.util.TempStorageUtil;

import static com.example.pao.testdit.mvp.main.adapter.TopicAdapterContract.*;

/**
 * Created by Pao on 22/4/17.
 */

public class TopicAdapterPresenter implements Presenter {

    View mView;

    public TopicAdapterPresenter(View view) {
        mView = view;
    }

    @Override
    public void increaseVote(Topic topic) {
        topic.increaseVote();
        TempStorageUtil.sortByHighestVote();
        mView.refresh();
    }

    @Override
    public void decreaseVote(Topic topic) {
        topic.decreaseVote();
        TempStorageUtil.sortByHighestVote();
        mView.refresh();
    }
}
