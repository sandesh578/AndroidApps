package com.example.recipeapp;

import android.content.Context;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener {

    private AdapterView.OnItemClickListener mlistener;

    public interface  ItemClickListener {
        public void onItemClick(View view,int position);
        public void onLongItemClick(View view, int position);
    }

    GestureDetector mdetector;

    public RecyclerItemClickListener(Context context, final RecyclerView recyclerView, AdapterView.OnItemClickListener mlistener)
    {
         this.mlistener=mlistener;
        this.mdetector=new GestureDetector(context,new SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        }

    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv,MotionEvent e) {
        @Override
        public void onLongPress(MotionEvent e) {
            View childView=recyclerView.findChildViewUnder(e.getX(),e.getY());
            if (childView != null && mlistener != null && mdetector.onTouchEvent(e)){
                mlistener.onItemClick(childView, view.getChildAdapterPosition(childView));
                return true;
            }
            return false;
    }

    @Override
    public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
      @Override
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
  }
    }
