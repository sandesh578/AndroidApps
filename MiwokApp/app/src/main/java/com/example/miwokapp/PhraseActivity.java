package com.example.miwokapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhraseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrase);

        ArrayList<Word> members=new ArrayList<Word>();

        members.add(new Word("Where are you going?","kata jadai ho?"));
        members.add(new Word("What are you doing?","K gardai ho?"));
        members.add(new Word("Hello dear?","K xa priya?"));
        members.add(new Word("Yes,I am coming.","Ma audai xu."));
        members.add(new Word("Let's go","Jau hida"));
        members.add(new Word("I'm feeling good.","Mahlai ramro lagiraxa"));
        members.add(new Word("Come here","Yeta aau"));
        members.add(new Word("Yor are awasome","Timi ramro xau."));

        WordAdapter wa=new WordAdapter(this,members,R.color.category_phrases);

        ListView lv=(ListView)findViewById(R.id.list);

        lv.setAdapter(wa);
    }
}