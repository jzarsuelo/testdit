package com.example.pao.testdit.mvp.main.adapter;

import com.example.pao.testdit.model.Topic;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static com.example.pao.testdit.mvp.main.adapter.TopicAdapterContract.View;
import static org.mockito.Mockito.verify;

/**
 * Created by Pao on 22/4/17.
 */

public class TopicAdapterTest {

    @Rule
    public MockitoRule mMockitoRule = MockitoJUnit.rule();

    @Mock
    View mockView;

    @Mock
    Topic mockTopic;

    TopicAdapterPresenter mPresenter;

    @Before
    public void setup() throws NoSuchMethodException, IllegalAccessException {
        mPresenter = new TopicAdapterPresenter(mockView);
    }

    @Test
    public void increaseVoteTest() {
        mPresenter.increaseVote(mockTopic);

        verify(mockTopic).increaseVote();
        verify(mockView).refresh();
    }

    @Test
    public void decreaseVoteTest() {
        mPresenter.decreaseVote(mockTopic);

        verify(mockTopic).decreaseVote();
        verify(mockView).refresh();
    }
}
