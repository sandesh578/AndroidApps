package com.example.miwokapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.lang.reflect.Member;
import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

        ArrayList<Word> member=new ArrayList<Word>();

        member.add(new Word("Mother","Maa",R.drawable.ic_launcher_background));
        member.add(new Word("Father","Pita",R.mipmap.ic_launcher_round));
        member.add(new Word("Brother","Dai",R.mipmap.ic_launcher_round));
        member.add(new Word("Sister","Bahini",R.mipmap.ic_launcher_round));
        member.add(new Word("GrandMother","HajurAma",R.mipmap.ic_launcher_round));
        member.add(new Word("GrandFather","HajurBuwa",R.mipmap.ic_launcher_round));
        member.add(new Word("Uncle","Sanobuwa",R.mipmap.ic_launcher_round));
        member.add(new Word("Aunt","Sanima",R.mipmap.ic_launcher_round));

        WordAdapter wa=new WordAdapter(this,member,R.color.category_family);

        ListView lv=(ListView)findViewById(R.id.list);

        lv.setAdapter(wa);
    }
}