package com.example.gitplushandroidexample.products;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.gitplushandroidexample.MainActivity;
import com.example.gitplushandroidexample.utils.DbHelper;
import com.example.gitplushandroidexample.R;
import com.example.gitplushandroidexample.model.Product;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Products extends AppCompatActivity {

    DbHelper dbHelper;
    RecyclerView productRecyclerView;
    ProductAdapter productAdapter;
    ArrayList<Product> products;
    FloatingActionButton addProduct;
    int numberOfProducts;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        dbHelper = new DbHelper(this);

        productRecyclerView = findViewById(R.id.product_recycler);
        addProduct = findViewById(R.id.add_product_btn);

        addProduct.setOnClickListener(v->addProduct());
        loadProductsFromDatabase();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent,0);
        myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        finish();
        return true;
    }

    private void addProduct() {

        Intent addProduct = new Intent(Products.this, ProductDetails.class);
        startActivity(addProduct);
    }

    private void loadProductsFromDatabase() {

        Cursor cursor = dbHelper.getAllProducts();
        products = new ArrayList<Product>();

        if (cursor.moveToFirst()) {
            do {
                products.add(new Product(

                        cursor.getInt(0),
                        cursor.getInt(1),
                        cursor.getInt(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getInt(5),
                        cursor.getInt(6),
                        cursor.getInt(7),
                        cursor.getDouble(8),
                        cursor.getDouble(9),
                        cursor.getInt(10),
                        cursor.getString(11),
                        cursor.getDouble(12),
                        cursor.getInt(13),
                        cursor.getInt(14),
                        cursor.getInt(15),
                        cursor.getInt(16),
                        cursor.getInt(17),
                        cursor.getString(18),
                        cursor.getInt(19),
                        cursor.getString(20)
                ));

            }

            while (cursor.moveToNext());
            productAdapter = new ProductAdapter(this, products);
            productRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            productRecyclerView.setAdapter(productAdapter);

            numberOfProducts = productAdapter.getItemCount();
            actionBar.setTitle("Products"+" "+"("+numberOfProducts+")");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_products,menu);
        MenuItem item = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {

                productAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                productAdapter.getFilter().filter(newText);
                return false;
            }
        });

        return true;
    }
}