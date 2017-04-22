package com.example.pao.testdit.mvp.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pao.testdit.R;
import com.example.pao.testdit.model.Topic;
import com.example.pao.testdit.util.TempStorageUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Pao on 22/4/17.
 */

public class TopicAdapter extends RecyclerView.Adapter {

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();

        LayoutInflater inflater = LayoutInflater.from(context);
        View layout = inflater.inflate(R.layout.item_topic, parent, false);

        TopicViewHolder viewHolder = new TopicViewHolder(layout);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof TopicViewHolder) {
            TopicViewHolder topicViewHolder = (TopicViewHolder) holder;
            topicViewHolder.bind(position);
        }

    }

    @Override
    public int getItemCount() {
        return TempStorageUtil.getAll().size();
    }

    class TopicViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_topic_name)
        TextView mTvTopicName;

        public TopicViewHolder(View itemView) {

            super(itemView);

            ButterKnife.bind(this, itemView);
        }

        public void bind(int position) {

            Topic topic = TempStorageUtil.get(position);

            mTvTopicName.setText( topic.getName() );
        }
    }
}