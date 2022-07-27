package com.example.whatsapp.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.whatsapp.Adapter.UserAdapter;
import com.example.whatsapp.R;
import com.example.whatsapp.databinding.FragmentChatBinding;
import com.example.whatsapp.models.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class ChatFragment extends Fragment {


    public ChatFragment() {
        // Required empty public constructor
    }
    FragmentChatBinding binding;
    ArrayList<User> list=new ArrayList<>();
    FirebaseDatabase database;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentChatBinding.inflate(inflater,container,false);
        UserAdapter adapter=new UserAdapter(list,getContext());
        binding.chatRecycleView.setAdapter(adapter);

        database=FirebaseDatabase.getInstance();
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        binding.chatRecycleView.setLayoutManager(layoutManager);

        database.getReference().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for(DataSnapshot dataSnapshot:snapshot.getChildren())
                {
                    User user=dataSnapshot.getValue(User.class);
                    user.getUserId(dataSnapshot.getKey());
                    list.add(user);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return  binding.getRoot();
    }
}