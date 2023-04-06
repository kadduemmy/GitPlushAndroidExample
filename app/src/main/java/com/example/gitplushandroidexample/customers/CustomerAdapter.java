package com.example.gitplushandroidexample.customers;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gitplushandroidexample.ItemClickListener;
import com.example.gitplushandroidexample.R;

import java.util.ArrayList;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerHolder>implements Filterable {

    Context context;
    static ArrayList<Customer> customers,filterList;
    CustomFilter filter;

    public CustomerAdapter(Context context, ArrayList<Customer> customers) {
        this.context = context;
        this.customers = customers;
        this.filterList =customers;
    }

    @NonNull
    @Override
    public CustomerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.customer_card_row,null);

        return new CustomerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerHolder holder, int position) {

        holder.customerName.setText(customers.get(position).getCustomer_first_name());
        holder.customerNumber.setText(String.format(String.valueOf(customers.get(position).getCustomer_contact())));
      //  holder.dateDate.setText((String.format(String.valueOf(customers.get(position).getJoining_date()))));

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {


                String cName = customers.get(position).getCustomer_first_name();
                String sName = customers.get(position).getCustomer_second_name();
                String cContact = String.valueOf(customers.get(position).getCustomer_contact());
                String sAddressOne = customers.get(position).getCustomer_address_one();
                String sAddressTwo = customers.get(position).getCustomer_address_one();
                String sCity = customers.get(position).getCity();
                //String sState = customers.get(position).getCustomer_second_name();
                String sEmail = customers.get(position).getEmail();
                String sLabel = customers.get(position).getLabel();
                String sTin = customers.get(position).getTin();
                String NCustomers = String.valueOf(getItemCount());
                String cCustomerId = String.valueOf(customers.get(position).getCustomer_id());

                Intent intent = new Intent(context,CustomerDetails.class);

                intent.putExtra("DetailName",cName);
                intent.putExtra("DetailName2",sName);
                intent.putExtra("DetailContact",cContact);
                intent.putExtra("AddressOne",sAddressOne);
                intent.putExtra("AddressTwo",sAddressTwo);
                intent.putExtra("City",sCity);
                intent.putExtra("Email",sEmail);
                intent.putExtra("Label",sLabel);
                intent.putExtra("Tin",sTin);

                intent.putExtra("CustomerCount",NCustomers);
                intent.putExtra("CustomerId",cCustomerId);

                context.startActivity(intent);
            }
        });

    }

    @Override
    public  int getItemCount() {

        return customers.size();
    }

    @Override
    public Filter getFilter() {
        if(filter == null){

            filter = new CustomFilter(filterList,this);
        }

        return filter;
    }
}
