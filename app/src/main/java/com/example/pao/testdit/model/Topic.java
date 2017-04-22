package com.example.pao.testdit.model;

import java.util.Comparator;

/**
 * Created by Pao on 21/4/17.
 */

public class Topic {

    private String mName;
    private long mVote;

    public Topic() {
    }

    public Topic(String name, long vote) {
        mName = name;
        mVote = vote;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public long getVote() {
        return mVote;
    }

    public void setVote(long vote) {
        mVote = vote;
    }

    public void increaseVote() {
        mVote++;
    }

    public void decreaseVote() {
        mVote--;
    }

    public static class SortedByHighestVote implements Comparator<Topic> {

        @Override
        public int compare(Topic o1, Topic o2) {
            if (o1.getVote() > o2.getVote()) {
                return -1;
            } else {
                return 1;
            }
        }
    }

}
