package com.example.miwokapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        ArrayList<Word> colour=new ArrayList<Word>();

        colour.add(new Word("Red","rato",R.mipmap.ic_launcher_round));
        colour.add(new Word("Blue","nilo",R.mipmap.ic_launcher_round));
        colour.add(new Word("Green","hariyo",R.mipmap.ic_launcher_round));
        colour.add(new Word("Yellow","pahelo",R.mipmap.ic_launcher_round));
        colour.add(new Word("Pink","gulabi",R.mipmap.ic_launcher_round));
        colour.add(new Word("Greyr","khairo",R.mipmap.ic_launcher_round));
        colour.add(new Word("White","seto",R.mipmap.ic_launcher_round));
        colour.add(new Word("Black","Kalo",R.mipmap.ic_launcher_round));

        WordAdapter wa=new WordAdapter(this,colour,R.color.category_colors);

        ListView lv=(ListView)findViewById(R.id.list);

        lv.setAdapter(wa);
    }
}