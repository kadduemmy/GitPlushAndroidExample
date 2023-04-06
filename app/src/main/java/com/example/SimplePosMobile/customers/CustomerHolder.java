package com.example.gitplushandroidexample.customers;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gitplushandroidexample.utils.ItemClickListener;
import com.example.gitplushandroidexample.R;

public class CustomerHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView customerName,customerNumber,dateDate;

    ItemClickListener itemClickListener;

    public CustomerHolder(@NonNull View itemView) {
        super(itemView);

        this.customerName= itemView.findViewById(R.id.customer_name);
        this.customerNumber = itemView.findViewById(R.id.customer_number);
        this.dateDate = itemView.findViewById(R.id.date_added);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        this.itemClickListener.onItemClickListener(view,getLayoutPosition());
    }

    public void setItemClickListener (ItemClickListener ic){
        this.itemClickListener = ic;
    }
}
