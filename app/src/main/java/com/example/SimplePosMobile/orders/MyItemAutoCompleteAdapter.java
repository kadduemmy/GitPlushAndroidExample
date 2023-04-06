package com.example.gitplushandroidexample.orders;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyItemAutoCompleteAdapter extends RecyclerView.Adapter<MyItemAutoCompleteAdapter.MyAutoCompleteHolder> {
    @NonNull
    @Override
    public MyAutoCompleteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAutoCompleteHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyAutoCompleteHolder extends RecyclerView.ViewHolder {
        public MyAutoCompleteHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
