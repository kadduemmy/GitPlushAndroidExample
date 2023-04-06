package com.example.gitplushandroidexample.orders;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.gitplushandroidexample.model.Item;
import com.example.gitplushandroidexample.ItemAdapter;
import com.example.gitplushandroidexample.R;

import java.util.ArrayList;
import java.util.List;

public class OrderDetails extends AppCompatActivity {

    public static final String DATABASE_NAME = "treskbills";
    SQLiteDatabase mdatabase;
    List<Item> itemList;
    ListView listView;
    Button addItemToCart, button_next_extra;
    public TextView totalAmount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        totalAmount = findViewById(R.id.over_all_price);
        addItemToCart = (Button) findViewById(R.id.button_add_item_to_cart);

        mdatabase = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);


        itemList = new ArrayList<>();

        listView = (ListView) findViewById(R.id.listViewItems);

        loadItemsFromDatabase();


        addItemToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(OrderDetails.this, OrderActivity.class);

                startActivity(intent);
            }
        });

    }

    private void loadItemsFromDatabase() {

        String sql = "SELECT * FROM order_details";

        Cursor cursor = mdatabase.rawQuery(sql, null);

        if (cursor.moveToFirst()) {

            do {

                itemList.add(new Item(
                        cursor.getInt(0),
                        cursor.getDouble(1),
                        cursor.getString(2),
                        cursor.getDouble(3),
                        cursor.getInt(4)
                ));
            }

            while (cursor.moveToNext());

            ItemAdapter adapter = new ItemAdapter(this, R.layout.cart_view, itemList, mdatabase);

            listView.setAdapter(adapter);

        }
    }


}