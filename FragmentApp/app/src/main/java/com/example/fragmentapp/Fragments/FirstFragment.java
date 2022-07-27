package com.example.fragmentapp.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fragmentapp.R;
import com.example.fragmentapp.SecondActivity;

public class FirstFragment extends Fragment {

    public FirstFragment()
    {

    }

    TextView textView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_first, container, false);

        textView=(TextView)view.findViewById(R.id.first);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), SecondActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}