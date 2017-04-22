package com.example.pao.testdit.mvp.main.adapter;

import com.example.pao.testdit.model.Topic;

/**
 * Created by Pao on 22/4/17.
 */

public interface TopicAdapterContract {

    interface View {

        void refresh();
    }

    interface Presenter {

        void increaseVote(Topic topic);

        void decreaseVote(Topic topic);
    }

}
