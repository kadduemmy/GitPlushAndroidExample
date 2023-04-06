package com.example.gitplushandroidexample.products;

import android.widget.Filter;

import com.example.gitplushandroidexample.model.Product;

import java.util.ArrayList;

public class ProductFilter extends Filter {

    ArrayList<Product> filterList;
    ProductAdapter productAdapter;

    public ProductFilter(ArrayList<Product> filterList, ProductAdapter productAdapter) {
        this.filterList = filterList;
        this.productAdapter = productAdapter;
    }

    @Override
    protected FilterResults performFiltering(CharSequence charSequence) {
        FilterResults results = new FilterResults();
        if (charSequence != null && charSequence.length() > 0) {

            charSequence = charSequence.toString().toUpperCase();

            ArrayList<Product> filterModels = new ArrayList<>();

            for (int i = 0; i < filterList.size(); i++) {

                if (filterList.get(i).getProduct_name().toUpperCase().contains(charSequence)) {
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


        productAdapter.products = (ArrayList<Product>) filterResults.values;

        productAdapter.notifyDataSetChanged();

    }
}
