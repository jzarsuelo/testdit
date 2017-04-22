package com.example.pao.testdit.util;

import com.example.pao.testdit.model.Topic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Pao on 21/4/17.
 */

public class TempStorageUtil {

    final static List<Topic> DB;
    final static Topic.SortedByHighestVote SORTED_BY_HIGHEST_VOTE;

    static {
        DB = new ArrayList<Topic>();
        SORTED_BY_HIGHEST_VOTE = new Topic.SortedByHighestVote();
    }

    public static boolean insert(Topic topic) {
        DB.add(topic);
        Collections.sort(DB, SORTED_BY_HIGHEST_VOTE);

        return true;
    }

    public static int getCount() {
        return DB.size();
    }

    public static List<Topic> getAll() {
        return DB;
    }

    public static Topic get(int position) {
        return DB.get(position);
    }

    public static void sortByHighestVote() {
        Collections.sort(DB, SORTED_BY_HIGHEST_VOTE);
    }
}
