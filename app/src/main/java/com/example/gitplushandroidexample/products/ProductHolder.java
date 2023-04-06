package com.example.gitplushandroidexample;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductHolder<T> extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView name,code,price,category;
    ItemClickListener  itemClickListener;

    public ProductHolder(@NonNull View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.product_name);
        code = itemView.findViewById(R.id.product_code);
        price = itemView.findViewById(R.id.product_price);
        category = itemView.findViewById(R.id.product_discount);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        this.itemClickListener.onItemClickListener(view,getLayoutPosition());

    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
}
