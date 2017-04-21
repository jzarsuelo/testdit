package com.example.pao.testdit.mvp.form;

/**
 * Created by Pao on 21/4/17.
 */

public interface FormContract {

    interface View {

        void showSuccessMessage();

        void navigateToHome();

        void showFailedMessage();
    }

    interface Presenter {

        void createTopic(String topicName);
    }
}
