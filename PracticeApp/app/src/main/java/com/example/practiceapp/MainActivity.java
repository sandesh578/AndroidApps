package com.example.practiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=(Button) findViewById(R.id.btn);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String text=b1.getText().toString();
                Toast toast= Toast.makeText(MainActivity.this,"Hello dear button is clicked",Toast.LENGTH_LONG);
                toast.setGravity(Gravity.BOTTOM | Gravity.RIGHT,0,0);
                toast.show();
               // Intent intent=new Intent(MainActivity.this, ImplicitIntentActivity.class);
                //intent.putExtra("dataname",text);
               // startActivity(intent);
            }
        });
    }
}