package com.example.miwokapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    private int mColorResourceId;
    public WordAdapter(Activity context, ArrayList<Word> Word)
    {
        super(context,0,Word);
    }
    public WordAdapter(Activity context, ArrayList<Word> Word,int mColorResourceId)
    {
        super(context,0,Word);
        this.mColorResourceId=mColorResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View liv=convertView;
        if(liv==null)
        {
            liv= LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        Word currentWord=getItem(position);
        TextView miwokTextView=(TextView)liv.findViewById(R.id.miok);
        miwokTextView.setText(currentWord.getmMiwokTranslation());

        TextView english=(TextView)liv.findViewById(R.id.eng);
        english.setText(currentWord.getmDefaultTranslation());

        ImageView img=(ImageView)liv.findViewById(R.id.item_icon);

        if(currentWord.hasImage())
        {
            img.setImageResource(currentWord.getmImageResource());
            img.setVisibility(View.VISIBLE);
        }
        else
        {
            img.setVisibility(View.GONE);
        }
        View textContainer=liv.findViewById(R.id.text_container);

        int color= ContextCompat.getColor(getContext(),mColorResourceId);
        textContainer.setBackgroundColor(color);

        return liv;
    }

}
