package com.example.gitplushandroidexample.customers;

import android.widget.Filter;

import com.example.gitplushandroidexample.model.Customer;

import java.util.ArrayList;

public class CustomFilter extends Filter {

    ArrayList<Customer> filterList;
    CustomerAdapter customerAdapter;

    public CustomFilter(ArrayList<Customer> filterList, CustomerAdapter customerAdapter) {
        this.filterList = filterList;
        this.customerAdapter = customerAdapter;
    }


    @Override
    protected FilterResults performFiltering(CharSequence charSequence) {

        FilterResults results = new FilterResults();
        if (charSequence != null && charSequence.length() > 0) {

            charSequence = charSequence.toString().toUpperCase();

            ArrayList<Customer> filterModels = new ArrayList<>();

            for (int i = 0; i < filterList.size(); i++) {

                if (filterList.get(i).getCustomer_first_name().toUpperCase().contains(charSequence)) {
                    filterModels.add(filterList.get(i));
                }
            }

            results.count = filterModels.size();
            results.values = filterModels;

        } else {

            results.count = filterList.size();
            results.values = filterList;
        }
        return results;
    }

    @Override
    protected void publishResults(CharSequence charSequence, FilterResults filterResults) {


        customerAdapter.customers = (ArrayList<Customer>) filterResults.values;

        customerAdapter.notifyDataSetChanged();

    }
}
