package com.example.gitplushandroidexample.products;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gitplushandroidexample.R;
import com.example.gitplushandroidexample.utils.DbHelper;

public class ProductDetails extends AppCompatActivity {

    DbHelper dbHelper;
    EditText productName, productDescription, productCost, productRate, productCode,
            productUnit;
    TextView addNewProduct, saveProduct;
    Intent intent;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        dbHelper = new DbHelper(this);

        productName = findViewById(R.id.product_name);
        productDescription = findViewById(R.id.product_description);
        productRate = findViewById(R.id.sales_rate);
        productCost = findViewById(R.id.purchase_rate);
        productCode = findViewById(R.id.item_codes);
        productUnit = findViewById(R.id.product_unit);

        addNewProduct = findViewById(R.id.add_new_product);
        saveProduct = findViewById(R.id.textView_save_product);


        intent = getIntent();
        Bundle bundle = intent.getExtras();

        id = intent.getStringExtra("code");

        if (bundle != null) {

            saveProduct.setVisibility(View.VISIBLE);
            String name = intent.getStringExtra("productName");
            String description = intent.getStringExtra("productDescription");
            String price = intent.getStringExtra("msrp");
            String rate = intent.getStringExtra("productPrice");
            String units = intent.getStringExtra("units");
            actionBar.setTitle(name);
            productName.setText(name);
            productDescription.setText(description);
            productRate.setText(price);
            productCost.setText(rate);
            productCode.setText(id);
            productUnit.setText(units);

            saveProduct.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    updateProduct();

                }
            });

        } else {

            actionBar.setTitle("Add New Product");
            addNewProduct.setVisibility(View.VISIBLE);
            addNewProduct.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    addProduct();
                }
            });
        }

    }

    private void updateProduct() {

        String name = productName.getText().toString().trim();
        String pDescription = productDescription.getText().toString().trim();
        double pRate = Double.parseDouble(productRate.getText().toString().trim());
        double pCost = Double.parseDouble(productCost.getText().toString().trim());
        String pCode = productCode.getText().toString().trim();
        int pUnit = Integer.parseInt(productUnit.getText().toString().trim());


        if (name.isEmpty()) {
            productName.setError("Name is needed");
            productName.requestFocus();
            return;
        }

        if (pDescription.isEmpty()) {
            productDescription.setError("contact needed");
            productDescription.requestFocus();
            return;
        }

        dbHelper.updateProduct(Integer.parseInt(id),2,2,name,pDescription,2,2,10,pCost,
                pRate,2,"red",2,2,10,5,5,
                10,"helloWorld",2,"nice stock");

        Toast.makeText(ProductDetails.this, "Product Updated", Toast.LENGTH_SHORT).show();

        Intent productUpdated = new Intent(ProductDetails.this, Products.class);
        startActivity(productUpdated);
    }

    private void addProduct() {

        String name = productName.getText().toString().trim();
        String pDescription = productDescription.getText().toString().trim();
        String pRate = productRate.getText().toString().trim();//double
        String pCost = productCost.getText().toString().trim();//double
        String pCode = productCode.getText().toString().trim();
        int pUnit = Integer.parseInt(productUnit.getText().toString().trim());//integer


        if (name.isEmpty()) {
            productName.setError("Name is needed");
            productName.requestFocus();
            return;
        }

        if (pDescription.isEmpty()) {
            productDescription.setError("contact needed");
            productDescription.requestFocus();
            return;

        }

        if (dbHelper.addProduct(2, 2, name, pDescription, 2, 2, 2,Integer.parseInt(pRate) , Integer.parseInt(pCost), 2,
                "red", 2, 2, 2, 2, 2, pUnit, "pic", 2, "very good")) {

            Intent productAdded = new Intent(ProductDetails.this, Products.class);
            productAdded.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            ;
            startActivity(productAdded);
            Toast.makeText(this, "product Added", Toast.LENGTH_SHORT).show();

        } else
            Toast.makeText(this, "customer not added", Toast.LENGTH_SHORT).show();



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_product_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.deleteProduct)
        {
            deleteProduct();

        }

        return super.onOptionsItemSelected(item);
    }

    private void deleteProduct() {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setMessage("Delete option");

        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dbHelper.deleteProduct(Integer.parseInt(id));

                Intent productDeleted = new Intent(ProductDetails.this, Products.class);
                productDeleted. addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(productDeleted);
                Toast.makeText(ProductDetails.this, "product deleted", Toast.LENGTH_SHORT).show();

            }
        });

        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        AlertDialog dialog = alertDialog.create();
        dialog .show();
    }

}