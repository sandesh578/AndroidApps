package com.example.recipeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView)findViewById(R.id.recylerView);

        ArrayList<RecipeModel> list=new ArrayList<>();
        list.add(new RecipeModel(R.drawable.chicken,"Chicken"));
        list.add(new RecipeModel(R.drawable.item1,"Chicken roll"));
        list.add(new RecipeModel(R.drawable.item2,"Chicken"));
        list.add(new RecipeModel(R.drawable.item3,"Pizza"));
        list.add(new RecipeModel(R.drawable.item4,"Biryani"));
        list.add(new RecipeModel(R.drawable.item5,"Chicken"));
        list.add(new RecipeModel(R.drawable.item6,"Chicken tikka"));
        list.add(new RecipeModel(R.drawable.item7,"Chicken"));

        RecipeAdapter adapter=new RecipeAdapter(list,this);

        recyclerView.setAdapter(adapter);

        //LinearLayoutManager manager=new LinearLayoutManager(this);
        //recyclerView.setLayoutManager(manager);

       //LinearLayoutManager manager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
       // recyclerView.setLayoutManager(manager);

        //GridLayoutManager manager=new GridLayoutManager(this,2);
        //recyclerView.setLayoutManager(manager);

        StaggeredGridLayoutManager manager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this,recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position)
                {
                    case 0:
                        Intent intent=new Intent(getApplicationContext(),ScrollingActivity.class);
                        startActivity(intent);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        });
    }
}