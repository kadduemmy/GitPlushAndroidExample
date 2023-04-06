package com.example.gitplushandroidexample.products;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gitplushandroidexample.utils.ItemClickListener;
import com.example.gitplushandroidexample.R;
import com.example.gitplushandroidexample.model.Product;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductHolder> implements Filterable {

    Context context;
    ArrayList<Product> products,filterList;
    ProductFilter filter;

    public ProductAdapter(Context context, ArrayList<Product> products) {
        this.context = context;
        this.products = products;
        this.filterList = products;
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
        holder.code.setText("(Code:"+String.valueOf(products.get(position).getProduct_id())+")");
        holder.price.setText(String.valueOf(products.get(position).getProduct_price()));
        holder.category.setText(String.valueOf(products.get(position).getCategory_id()));

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {

                Intent intent =  new Intent(context,ProductDetails.class);

                intent.putExtra("productName",products.get(position).getProduct_name());
                intent.putExtra("productDescription",products.get(position).getProduct_description());
                intent.putExtra("productPrice",String.valueOf(products.get(position).getProduct_price()));
                intent.putExtra("msrp",String.valueOf(products.get(position).getProduct_msrp()));
                intent.putExtra("code",String.valueOf(products.get(position).getProduct_id()));
                intent.putExtra("units",String.valueOf(products.get(position).getProduct_unit_order()));

                Toast.makeText(v.getContext(), String.valueOf(products.get(position).getProduct_id()), Toast.LENGTH_SHORT).show();

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount()
    {
        return products.size();
    }

    @Override
    public Filter getFilter() {

        if(filter == null){
            filter = new ProductFilter(filterList,this);
        }
        return filter;
    }
}
