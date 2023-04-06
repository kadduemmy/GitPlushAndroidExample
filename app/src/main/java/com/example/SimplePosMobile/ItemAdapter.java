package com.example.gitplushandroidexample;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.gitplushandroidexample.model.Item;
import com.example.gitplushandroidexample.orders.OrderActivity;

import java.util.List;

public class ItemAdapter extends ArrayAdapter<Item> {

    SQLiteDatabase mdatabase;
    Context mCtx;
    int layoutRes;
    List<Item> itemList;
    int overAllprice;

    public ItemAdapter(Context mCtx, int layoutRes, List<Item> itemList,SQLiteDatabase mdatabase) {
        super(mCtx, layoutRes, itemList);
        this.mCtx = mCtx;
        this.layoutRes = layoutRes;
        this.itemList = itemList;
        this.mdatabase = mdatabase;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(mCtx);

        View view = inflater.inflate(layoutRes,null);

        TextView itemName = view.findViewById(R.id.itemName);
        TextView itemPrice = view.findViewById(R.id.itemRate);
        TextView itemQuantity = view.findViewById(R.id.itemQty);
        TextView itemAmount = view.findViewById(R.id.item_cart_amount);
        ImageView imageDelete = view.findViewById(R.id.image_delete);


        final Item item = itemList.get(position);


        itemName.setText(item.getItem());
        itemPrice.setText(String.valueOf(item.getPrice()));
        itemQuantity.setText(String.valueOf(item.getQty()));

        int a = (int) item.getPrice();
        int b = (int) item.getQty();

        int amount =(a*b);

        itemAmount.setText(String.valueOf(amount));

        overAllprice = overAllprice+amount;

        //MainActivity.totalAmount = setText(String.valueOf(overAllprice));

        imageDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String sql = "DELETE FROM order_details WHERE order_id= ?";
                mdatabase.execSQL(sql, new Integer[]{item.getItem_id()});

                loadCart();


            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Item item = itemList.get(position);

                String id = String.valueOf(item.getItem_id());
                String pName = item.getItem();
                String gQuantity = String.valueOf(item.getQty());
                String gPrice = String.valueOf(item.getPrice());

                Intent intent = new Intent (mCtx, OrderActivity.class);
                intent.putExtra("id", id);
                intent.putExtra("product_name",pName);
                intent.putExtra("product_quantity",gQuantity);
                intent.putExtra("product_price",gPrice);

                mCtx.startActivity(intent);


            }
        });


        return view;
    }

    private void loadCart() {


        String sql2 = "SELECT * FROM order_details";

        Cursor cursor = mdatabase.rawQuery(sql2, null);

        if (cursor.moveToFirst()) {

            itemList.clear();

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
            notifyDataSetChanged();
        }

    }

}
