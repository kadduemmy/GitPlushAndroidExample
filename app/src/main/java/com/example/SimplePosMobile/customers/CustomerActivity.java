package com.example.SimplePosMobile.customers;

import androidx.annotation.NonNull;
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
import android.view.View;
import android.widget.SearchView;

import com.example.SimplePosMobile.MainActivity;
import com.example.SimplePosMobile.R;
import com.example.SimplePosMobile.model.Customer;
import com.example.SimplePosMobile.utils.DbHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class CustomerActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CustomerAdapter customerAdapter;
    DbHelper dbHelper;
    ArrayList<Customer> customers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView = findViewById(R.id.customer_view_recycler);

        dbHelper = new DbHelper(this);

        loadCustomersFromDatabase();

        FloatingActionButton addButtonCustomer = findViewById(R.id.add_customer_btn);
        addButtonCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               addCustomer();
            }
        });


    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
        finish();
        return true;
    }

    private void loadCustomersFromDatabase() {

        Cursor cursor = dbHelper.getAllCustomers();
        customers = new ArrayList<Customer>();

        if (cursor.moveToFirst()) {
            do {
                customers.add(new Customer(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6),
                        cursor.getString(7),
                        cursor.getString(8),
                        cursor.getString(9),
                        cursor.getString(10),
                        cursor.getString(11),
                        cursor.getString(12)

                ));
            }

            while (cursor.moveToNext());
            customerAdapter = new CustomerAdapter(this, customers);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(customerAdapter);

            getSupportActionBar().setTitle("Customers" + " " + "(" + customerAdapter.getItemCount() + ")");
        }

    }

    private void addCustomer() {
        Intent intent = new Intent(getApplicationContext(), CustomerDetails.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_customers, menu);
        MenuItem item = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {

                customerAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                customerAdapter.getFilter().filter(newText);
                return false;
            }
        });

        return true;
    }


}