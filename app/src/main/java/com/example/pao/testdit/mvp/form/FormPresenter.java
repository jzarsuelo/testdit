package com.example.pao.testdit.mvp.form;

import static com.example.pao.testdit.mvp.form.FormContract.*;

/**
 * Created by Pao on 21/4/17.
 */

public class FormPresenter implements Presenter {

    View mView;

    public FormPresenter(View view) {
        mView = view;
    }
}
