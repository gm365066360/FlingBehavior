package com.gaom.flingbehaviordemo;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


public abstract class CommentAdapter<T> extends RecyclerView.Adapter<CommentViewHolder> {

    public OnRecyclerViewListener onRecyclerViewListener;

    public void setOnRecyclerViewListener(OnRecyclerViewListener onRecyclerViewListener) {
        this.onRecyclerViewListener = onRecyclerViewListener;
    }

    public static interface OnRecyclerViewListener {
        void onItemClick(int position, Object o);

        boolean onItemLongClick(int position, Object o);
    }

    private List<T> mTList;
    private int layoutId;


    public CommentAdapter(List<T> TList, int layoutId) {
        mTList = TList;
        this.layoutId = layoutId;
    }

    public void setmTList(List<T> mTList) {
        this.mTList = mTList;
        notifyDataSetChanged();
    }
    public void addData(List<T> mTList) {
        this.mTList.addAll(mTList);
        notifyDataSetChanged();
    }

    @Override
    public CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(layoutId, null);

        return new CommentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CommentViewHolder holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    if (onRecyclerViewListener != null)
                        onRecyclerViewListener.onItemClick(position, mTList.get(position));
                    if (position < mTList.size())
                        onItemClick(position, mTList.get(position));

                } catch (Exception e) {

                }
            }
        });
        convert(holder, mTList.get(position));
    }

    public abstract void convert(CommentViewHolder holder, T t);

    public abstract void onItemClick(int position, Object o);

    @Override
    public int getItemCount() {
        try {
            return mTList.size();
        } catch (Exception e) {
            return 0;
        }
    }
}