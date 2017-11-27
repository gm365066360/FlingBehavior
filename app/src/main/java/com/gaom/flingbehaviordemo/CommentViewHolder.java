package com.gaom.flingbehaviordemo;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


/**
 */
public class CommentViewHolder extends RecyclerView.ViewHolder {


    private final SparseArray<View> views;
    private View convertView;

    private Context mContext;

    public CommentViewHolder(View itemView) {
        super(itemView);
        views = new SparseArray<>();
        convertView = itemView;
        mContext = itemView.getContext();
    }

    public <T extends View> T getView(int viewId) {
        View view = views.get(viewId);
        if (view == null) {
            view = convertView.findViewById(viewId);
            views.put(viewId, view);
        }
        return (T) view;
    }

    public void setText(int resId, String text) {
        TextView view = getView(resId);
        view.setText(text);
    }


}