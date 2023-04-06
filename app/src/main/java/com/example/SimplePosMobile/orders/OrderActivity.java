package com.example.gitplushandroidexample.orders;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gitplushandroidexample.R;
import com.example.gitplushandroidexample.utils.DbHelper;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    AutoCompleteTextView  orderItem;
    EditText orderNumber, orderPrice, orderQty;
    Button cancelItem, updateItem;
    DbHelper dbHelper;
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

        dbHelper = new DbHelper(this);

        final String [] myData,myPrice;
        ArrayList<String> array = new ArrayList<>();

        Cursor cr = dbHelper.getAllProducts();
        cr.moveToFirst();//cursor pointing to first row
        myData = new String[cr.getCount()];//create array string based on numbers of row
        myPrice = new String[cr.getCount()];
        int i=0;
        do  {
            myData[i] = cr.getString(1);//insert new stations to the array list
            myPrice[i] = cr.getString(3);
            //Log.i("ArrayList",mydata[i]);
            i++;
        }while(cr.moveToNext());

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, myPrice);

        orderItem.setAdapter(adapter);


        intent = getIntent();

        Bundle bundle = intent.getExtras();

        if (bundle != null) {
           // updateCart();
        } else {

            updateItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                  //  addOrderItem();
                }
            });

        }

        cancelItem.setOnClickListener(view -> finish());


    }

 /*   private void updateCart() {

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

*/

 /*   private void addOrderItem() {

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

    }*/


}