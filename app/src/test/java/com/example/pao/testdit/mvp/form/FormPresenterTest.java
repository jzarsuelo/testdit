package com.example.pao.testdit.mvp.form;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.nio.CharBuffer;

import static com.example.pao.testdit.mvp.form.FormContract.View;
import static org.mockito.Mockito.verify;

/**
 * Created by Pao on 21/4/17.
 */

public class FormPresenterTest {
    @Rule
    public MockitoRule mMockitoRule = MockitoJUnit.rule();

    @Mock
    View mockView;

    FormPresenter mPresenter;

    @Before
    public void setup() throws NoSuchMethodException, IllegalAccessException {
        mPresenter = new FormPresenter(mockView);
    }

    @Test
    public void createTopicValidTest() {
        String topicName = generateString(10);

        mPresenter.createTopic(topicName);

        verify(mockView).showSuccessMessage();
        verify(mockView).navigateToHome();
    }

    @Test
    public void createTopicExceed255CharacterTest() {
        String topicName = generateString(300);

        mPresenter.createTopic(topicName);

        verify(mockView).showFailedMessage();
    }

    @Test
    public void createTopicEmptyStringTest() {
        String topicName = "";

        mPresenter.createTopic(topicName);

        verify(mockView).showFailedMessage();
    }

    private String generateString(int numberOfCharacters) {
        return CharBuffer.allocate( numberOfCharacters ).toString().replace( '\0', 'a' );
    }


}
