package com.example.gitplushandroidexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    public static final String DATABASE_NAME = "treskbills";
    AutoCompleteTextView  orderItem;
    EditText orderNumber, orderPrice, orderQty;
    Button cancelItem, updateItem;
    SQLiteDatabase mdatabase;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        orderNumber = findViewById(R.id.order_number);
        orderItem = findViewById(R.id.item);
        orderPrice = findViewById(R.id.price);
        orderQty = findViewById(R.id.qty);
        cancelItem = findViewById(R.id.cancel_tem);
        updateItem = findViewById(R.id.add_item);


        mdatabase = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
        createTable();

        final String [] mydata,myPrice;
        ArrayList<String> array = new ArrayList<>();
        //Inside the method you've read the cursor, loop through it and add those item to array
        String sql="SELECT * FROM products";
        //execute SQL
        Cursor cr = mdatabase.rawQuery(sql, null);
        cr.moveToFirst();//cursor pointing to first row
        mydata = new String[cr.getCount()];//create array string based on numbers of row
        myPrice = new String[cr.getCount()];
        int i=0;
        do  {
            mydata[i] = cr.getString(1);//insert new stations to the array list
            myPrice[i] = cr.getString(3);
            //Log.i("ArrayList",mydata[i]);
            i++;
        }while(cr.moveToNext());
        //Finally Set the adapter to AutoCompleteTextView like this,
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, mydata);
        //populate the list to the AutoCompleteTextView controls
        orderItem.setAdapter(adapter);




        intent = getIntent();

        Bundle bundle = intent.getExtras();

        if (bundle != null) {

            updateCart();

        } else {



            updateItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {



                    addOrderItem();
                }
            });

        }

        cancelItem.setOnClickListener(view -> finish());


    }

    private void updateCart() {

        String names = intent.getStringExtra("product_name");
        String qty = intent.getStringExtra("product_quantity");
        String price = intent.getStringExtra("product_price");
        final String id = intent.getStringExtra("id");

        orderItem.setText(names);
        orderQty.setText(qty);
        orderPrice.setText(price);

        updateItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String number = orderNumber.getText().toString().trim();
                String name = orderItem.getText().toString().trim();
                String price = orderPrice.getText().toString().trim();
                String quantity = orderQty.getText().toString().trim();
                String total = orderQty.getText().toString().trim();


                if (number.isEmpty()) {

                    orderNumber.setError("name is required");
                    orderNumber.requestFocus();
                    return;
                }

                if (name.isEmpty()) {

                    orderItem.setError("rate required");
                    orderItem.requestFocus();
                    return;
                }

                if (price.isEmpty()) {

                    orderPrice.setError("quantity required");
                    orderPrice.requestFocus();
                    return;
                }

                if (quantity.isEmpty()) {

                    orderQty.setError("quantity required");
                    orderQty.requestFocus();
                    return;
                }

                String sql = "UPDATE order_details SET order_item =?, order_price =?, order_quantity=?  WHERE order_id=?";

                mdatabase.execSQL(sql, new String[]{name, price, qty, id});

                Intent intent = new Intent(OrderActivity.this, OrderDetails.class);
                Toast.makeText(OrderActivity.this, "updated successfully", Toast.LENGTH_SHORT).show();
                startActivity(intent);

            }


        });


    }

    private void createTable() {

        String sql = "CREATE TABLE IF NOT EXISTS order_details (\n" +
                "order_id INTEGER NOT NULL CONSTRAINT employees_pk PRIMARY KEY AUTOINCREMENT,\n" +
                "order_number double NOT NULL,\n" +
                "order_item varchar(200 ) NOT NULL,\n" +
                "order_price double  NOT NULL,\n" +
                "order_quantity double  NOT NULL,\n" +
                "order_total double NOT NULL\n" +
                ")";

        mdatabase.execSQL(sql);
    }


    private void addOrderItem() {

        String number = orderNumber.getText().toString().trim();
        String name = orderItem.getText().toString().trim();
        String price = orderPrice.getText().toString().trim();
        String quantity = orderQty.getText().toString().trim();
        String total = orderQty.getText().toString().trim();


        if (number.isEmpty()) {

            orderNumber.setError("name is required");
            orderNumber.requestFocus();
            return;
        }

        if (name.isEmpty()) {

            orderItem.setError("rate required");
            orderItem.requestFocus();
            return;
        }

        if (price.isEmpty()) {

            orderPrice.setError("quantity required");
            orderPrice.requestFocus();
            return;
        }

        if (quantity.isEmpty()) {

            orderQty.setError("quantity required");
            orderQty.requestFocus();
            return;
        }

        String sql = "INSERT INTO order_details(order_number,order_item,order_price,order_quantity,order_total) " +
                "VALUES(?,?,?,?,?)";

        mdatabase.execSQL(sql, new String[]{number, name, price, quantity, total});
        Intent intent = new Intent(this, OrderDetails.class);

        startActivity(intent);

        Toast.makeText(this, "Item added successfully", Toast.LENGTH_SHORT).show();

    }


}