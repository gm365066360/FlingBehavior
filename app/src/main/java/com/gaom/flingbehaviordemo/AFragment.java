package com.gaom.flingbehaviordemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;


public class AFragment extends Fragment {
    private CommentAdapter<String> commentAdapter;


    private String id;
    private String s;

    public static AFragment newInstance(String id, String s) {
        AFragment f = new AFragment();
        Bundle args = new Bundle();
        args.putString("id", id);
        args.putString("s", s);
        f.setArguments(args);
        return f;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        id = getArguments().getString("id");
        s = getArguments().getString("s");

        View view = inflater.inflate(R.layout.fragment_a, container, false);

        RecyclerView otherRecyclerView = (RecyclerView) view.findViewById(R.id.fragment_home_grid);
        LinearLayoutManager mgr = new LinearLayoutManager(getActivity());
        otherRecyclerView.setLayoutManager(mgr);
        otherRecyclerView.setItemAnimator(new DefaultItemAnimator());


        otherRecyclerView.setAdapter(commentAdapter = new CommentAdapter<String>(
                new ArrayList<String>(), R.layout.fragment_home_head) {
            @Override
            public void convert(CommentViewHolder holder, String o) {

            }

            @Override
            public void onItemClick(int position, Object o) {

            }

        });


        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            strings.add("123");
        }
        commentAdapter.setmTList(strings);
        return view;

    }


}
