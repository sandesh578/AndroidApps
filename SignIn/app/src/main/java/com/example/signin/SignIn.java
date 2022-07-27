package com.example.signin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;

public class SignIn extends AppCompatActivity {

    AlertDialog.Builder builder;
    EditText e1, e2;
    Button showhide_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        e2 = (EditText) findViewById(R.id.password_field);
        showhide_btn = (Button) findViewById(R.id.showhide_btn);
        showhide_btn.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                if (e2.getText().toString().isEmpty()) {
                                                    e2.setError("Please Enter the Password");
                                                } else {
                                                    if (showhide_btn.getText().toString().equals("Show")) {
                                                        showhide_btn.setText("Hide");
                                                        e2.setTransformationMethod(null);
                                                    } else {
                                                        showhide_btn.setText("Show");
                                                        e2.setTransformationMethod(new PasswordTransformationMethod());
                                                    }
                                                }
                                            }
                                        }
        );
    }

    public void displayMessage(View view) {
        e1 = (EditText) findViewById(R.id.email_field);
        String email = String.valueOf(e1.getText());
        e2 = (EditText) findViewById(R.id.password_field);
        String password = String.valueOf(e2.getText());

        if (e1.getText().toString().isEmpty()) {
            e1.setError("Email cant be empty");
        }
        builder = new AlertDialog.Builder(this);

        builder.setMessage("Is your email and password correct?\nEmail:" + email + "\nPassword:" + password)
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        Toast t = Toast.makeText(getApplicationContext(), "Your Info Submitted Successfully", Toast.LENGTH_SHORT);
                        t.show();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        Toast t = Toast.makeText(getApplicationContext(), "Please confirm again", Toast.LENGTH_SHORT);
                        t.show();
                    }
                });
        AlertDialog alert = builder.create();
        alert.setTitle("Confirmation");
        alert.show();

    }
}