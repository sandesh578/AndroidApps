package com.example.whatsapp;

import android.os.Bundle;

import com.example.whatsapp.databinding.ActivityChatDetailedBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

public class ChatDetailedActivity extends AppCompatActivity {

    ActivityChatDetailedBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityChatDetailedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }
}