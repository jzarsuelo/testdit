package com.example.pao.testdit.mvp.main.adapter;

import static com.example.pao.testdit.mvp.main.adapter.TopicAdapterContract.*;

/**
 * Created by Pao on 22/4/17.
 */

public class TopicAdapterPresenter implements Presenter {

    View mView;

    public TopicAdapterPresenter(View view) {
        mView = view;
    }

}
