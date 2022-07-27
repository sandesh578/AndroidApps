package com.example.userinput;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et = (EditText) findViewById(R.id.quantity_edit_view), et1, et2, et3;
    TextView tv;
    CheckBox ck1,ck2;
    boolean isChecked1,isChecked2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void display() {
        et = (EditText) findViewById(R.id.quantity_edit_view);
        int quantity = Integer.parseInt(String.valueOf(et.getText()));
        et1 = (EditText) findViewById(R.id.prices_edit_view);
        int price = Integer.parseInt(String.valueOf(et1.getText()));
        et3 = (EditText) findViewById(R.id.name);
        String name = String.valueOf(et3.getText());
        ck1=(CheckBox)findViewById(R.id.check_box1);
        isChecked1=ck1.isChecked();
        String checkbox1=String.valueOf(ck1.getText());
        ck2=(CheckBox)findViewById(R.id.check_box2);
        isChecked2=ck2.isChecked();
        String checkbox2=String.valueOf(ck2.getText());
        changeViewName();
        //Intent intent=new Intent(Intent.ACTION_SENDTO);
       // intent.setData(Intent.parseUri("mailto:"));
        //intent.putExtra(Intent.EXTRA_SUBJECT,"Order Request");
        //intent.putExtra(Intent.EXTRA_TEXT,printMessage);

        if(isChecked2&&isChecked1) {
            et1.setText("Name :" + name + "\nQuantity :" + quantity + "\nTotal Price:" + (quantity * price*2*3) + "\n"+checkbox2+" is added.\n"+checkbox2+" is also added.\nThank you!!");
        }
        else if(isChecked1==true)
        {
            et1.setText("Name :" + name + "\nQuantity :" + quantity + "\nTotal Price:" + (quantity * price*2) + "\n"+checkbox1+" is added.\nThank you!!");
        }
        else if(isChecked2==true)
        {
            et1.setText("Name :" + name + "\nQuantity :" + quantity + "\nTotal Price:" + (quantity * price*3) + "\n"+checkbox2+" is  added.\nThank you!!");
        }
        else
        {
            et1.setText("Name :" + name + "\nQuantity :" + quantity + "\nTotal Price:" + (quantity * price) + "\nNothing is added.\nThank you!!");
        }

    }

    public void changeViewName() {
        tv = (TextView) findViewById(R.id.price_text_view);
        tv.setText("Order Summary");
    }

    public void submitOrder(View view) {
        display();
    }

    public void addItem(View view) {
        et = (EditText) findViewById(R.id.quantity_edit_view);
        int quantity = Integer.parseInt(String.valueOf(et.getText()));
        quantity++;
        if(quantity>100)
        {
            Toast.makeText(getApplicationContext(),"Limit reached",Toast.LENGTH_SHORT).show();
            return;
        }
        et.setText(String.valueOf(R.string.quantity));
    }

    public void subItem(View view) {
        et = (EditText) findViewById(R.id.quantity_edit_view);
        int quantity = Integer.parseInt(String.valueOf(et.getText()));
        quantity--;
        if(quantity<1)
        {
            Toast.makeText(getApplicationContext(),"Limit reached",Toast.LENGTH_SHORT).show();
            return;
        }
        et.setText(String.valueOf(quantity));
    }
}