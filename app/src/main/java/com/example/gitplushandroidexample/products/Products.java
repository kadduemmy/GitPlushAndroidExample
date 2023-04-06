package com.example.gitplushandroidexample;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Products extends AppCompatActivity {

    SQLiteDatabase sqLiteDatabase;
    RecyclerView productRecyclerView;
    ProductAdapter productAdapter;
    ArrayList<Product> products;
    FloatingActionButton addProduct;
    int numberOfProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        ActionBar actionBar = getSupportActionBar();
        numberOfProducts = 20;
        actionBar.setTitle("Products"+" "+"("+numberOfProducts+")");
        actionBar.setDisplayHomeAsUpEnabled(true);


        productRecyclerView = findViewById(R.id.product_recycler);
        addProduct = findViewById(R.id.add_product_btn);

        addProduct.setOnClickListener(v->addProduct());

        sqLiteDatabase = openOrCreateDatabase(AddProduct.DATABASE_NAME, MODE_PRIVATE, null);
        loadProductsFromDatabase();



    }

    private void addProduct() {

    startActivity(new Intent(this,AddProduct.class));
    }

    private void loadProductsFromDatabase() {

        String sql = "SELECT * FROM products";

        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);

        products = new ArrayList<Product>();

        if (cursor.moveToFirst()) {
            do {
                products.add(new Product(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getInt(3)

                ));

            }

            while (cursor.moveToNext());
            productAdapter = new ProductAdapter(this, products);
            productRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            productRecyclerView.setAdapter(productAdapter);

        }
    }
}