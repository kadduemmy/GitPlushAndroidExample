package com.example.gitplushandroidexample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class ProductDetails extends AppCompatActivity {

    EditText productName,productCategory,productPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        ActionBar actionBar = getActionBar();



        productName = findViewById(R.id.product_name);
        productCategory = findViewById(R.id.product_category);
        productPrice = findViewById(R.id.product_price);

        Intent intent = getIntent();

        String name = intent.getStringExtra("productName");
        String category = intent.getStringExtra("productCategory") ;
        String price = String.valueOf(intent.getStringExtra("productPrice"));

        actionBar.setTitle("hello");

        productName.setText(name);
        productCategory.setText(category);
        productPrice.setText(price);
    }
}