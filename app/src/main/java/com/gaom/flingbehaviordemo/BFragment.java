package com.gaom.flingbehaviordemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class BFragment extends Fragment  {


    private String id;
    private String s;

    public static BFragment newInstance(String id, String s) {
        BFragment f = new BFragment();
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

        View view= inflater.inflate( R.layout.fragment_b, container, false);

        Button btn = (Button)view.findViewById( R.id.fragment1_btn);
        btn.setText(id+","+s);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "点击了第一个fragment的BTN", Toast.LENGTH_SHORT).show();
            }
        });


        return view;

    }




}
