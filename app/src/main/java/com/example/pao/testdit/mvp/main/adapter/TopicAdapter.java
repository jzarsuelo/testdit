package com.example.pao.testdit.mvp.main.adapter;

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
import butterknife.OnClick;

/**
 * Created by Pao on 22/4/17.
 */

public class TopicAdapter extends RecyclerView.Adapter
            implements TopicAdapterContract.View {

    private final TopicAdapterPresenter mPresenter;

    public TopicAdapter() {
        mPresenter = new TopicAdapterPresenter(this);
    }

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

    @Override
    public void refresh() {
        TempStorageUtil.sortByHighestVote();
        notifyDataSetChanged();
    }

    class TopicViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_topic_name)
        TextView mTvTopicName;

        @BindView(R.id.tv_vote_count)
        TextView mTvVoteCount;

        public TopicViewHolder(View itemView) {

            super(itemView);

            ButterKnife.bind(this, itemView);
        }

        public void bind(int position) {

            Topic topic = TempStorageUtil.get(position);

            mTvTopicName.setText( topic.getName() );
            mTvVoteCount.setText( String.valueOf(topic.getVote()) );
        }

        @OnClick(R.id.iv_up)
        void onClickUpVote() {

            Topic topic = getAdapterPositionTopic();
            mPresenter.increaseVote(topic);
        }

        @OnClick(R.id.iv_down)
        void onClickDownVote() {

            Topic topic = getAdapterPositionTopic();
            mPresenter.decreaseVote(topic);
        }

        private Topic getAdapterPositionTopic() {
            int position = getAdapterPosition();
            Topic topic = TempStorageUtil.get(position);

            return topic;
        }
    }
}
