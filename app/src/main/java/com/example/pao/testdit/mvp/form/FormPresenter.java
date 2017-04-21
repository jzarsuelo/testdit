package com.example.pao.testdit.mvp.form;

import com.example.pao.testdit.model.Topic;
import com.example.pao.testdit.util.TempStorageUtil;

import static com.example.pao.testdit.mvp.form.FormContract.Presenter;
import static com.example.pao.testdit.mvp.form.FormContract.View;

/**
 * Created by Pao on 21/4/17.
 */

public class FormPresenter implements Presenter {

    public static final int MAX_CHAR = 255;

    View mView;

    public FormPresenter(View view) {
        mView = view;
    }

    @Override
    public void createTopic(String topicName) {
        if ( topicName == null || topicName.isEmpty() || topicName.length() > MAX_CHAR) {
            mView.showFailedMessage();
            return;
        }

        Topic topic = new Topic(topicName, 0);
        TempStorageUtil.insert(topic);

        mView.showSuccessMessage();
        mView.navigateToHome();
    }
}
