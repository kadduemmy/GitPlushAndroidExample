package com.example.gitplushandroidexample;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductHolder> {

    Context context;
    ArrayList<Product> products;

    public ProductAdapter(Context context, ArrayList<Product> products) {
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public ProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_card_row,null);

        return new ProductHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductHolder holder, int position) {

        holder.name.setText(products.get(position).getProduct_name());
        holder.code.setText(String.valueOf(products.get(position).getProduct_id()));
        holder.price.setText(String.valueOf(products.get(position).getProduct_price()));
        holder.category.setText(products.get(position).getProduct_category());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {
                //Toast.makeText(v.getContext(), "you have clicked"+position, Toast.LENGTH_SHORT).show();

                Intent intent =  new Intent(context,ProductDetails.class);
                String NumberProducts = String.valueOf(getItemCount());

                intent.putExtra("productName",products.get(position).getProduct_name());
                intent.putExtra("productCategory",products.get(position).getProduct_category());
                intent.putExtra("productPrice",products.get(position).getProduct_price());
                intent.putExtra("CustomerCount",NumberProducts);

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount()
    {
        return products.size();
    }
}
