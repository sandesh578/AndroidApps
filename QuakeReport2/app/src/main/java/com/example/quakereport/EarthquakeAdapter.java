package com.example.quakereport;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> quake) {
        super(context, 0,quake);
    }

    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        View listView=convertView;
        if(listView==null)
        {
            listView= LayoutInflater.from(getContext()).inflate(R.layout.list_items,parent,false);
        }

        Earthquake quak=getItem(position);


        TextView tv=(TextView)listView.findViewById(R.id.magnitude);
        tv.setText(String.valueOf(quak.getMagnitude()));

        TextView tv1=(TextView)listView.findViewById(R.id.places);
        tv.setText(quak.getPlaces());

        TextView tv2=(TextView)listView.findViewById(R.id.time);
        tv2.setText(String.valueOf(quak.getTime()));

        return listView;
    }
}
