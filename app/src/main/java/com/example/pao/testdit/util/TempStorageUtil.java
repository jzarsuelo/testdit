package com.example.pao.testdit.util;

import com.example.pao.testdit.model.Topic;

import java.util.TreeSet;

/**
 * Created by Pao on 21/4/17.
 */

public class TempStorageUtil {

    final static TreeSet<Topic> DB;

    static {
        DB = new TreeSet<Topic>(new Topic.SortedByHighestVote());
    }

    public static boolean insert(Topic topic) {

        DB.add(topic);

        return true;
    }
}
