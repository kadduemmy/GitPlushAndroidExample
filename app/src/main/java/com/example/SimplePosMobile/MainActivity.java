package com.example.gitplushandroidexample;

import static com.example.gitplushandroidexample.R.id.add_customer_btn;
import static com.example.gitplushandroidexample.R.id.purchase_btn;
import static com.example.gitplushandroidexample.R.id.sale_stock_btn;
import static com.example.gitplushandroidexample.R.id.view_report_btn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Button;
import android.widget.Toast;

import com.example.gitplushandroidexample.customeraccount.CustomerAccount;
import com.example.gitplushandroidexample.customers.CustomerActivity;
import com.example.gitplushandroidexample.orders.OrderActivity;
import com.example.gitplushandroidexample.products.Products;

public class MainActivity extends AppCompatActivity {



    Button purchaseButton, sellStockButton, viewReportButton, addCustomerButton,addProductsButton;
    CardView posCard,posProduct ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("TRESKBILLS");
        getSupportActionBar().setSubtitle("kaddu emmy");

        purchaseButton = findViewById(purchase_btn);
        sellStockButton = findViewById(sale_stock_btn);
        viewReportButton = findViewById(view_report_btn);
        addCustomerButton = findViewById(add_customer_btn);
        addProductsButton = findViewById(R.id.add_products_btn);
        posCard = findViewById(R.id.pos_card);
        posProduct = findViewById(R.id.card_three);

        purchaseButton.setOnClickListener(v->purchaseStock());
        sellStockButton.setOnClickListener(v->sellStock());
        viewReportButton.setOnClickListener(v->viewReports());
        addCustomerButton .setOnClickListener(v->addCustomer());
        addProductsButton.setOnClickListener(v->addProducts());
        posCard.setOnClickListener(v->makeOrder());
        posProduct.setOnClickListener(v->makeWebView());


    }

    private void makeWebView() {

        startActivity(new Intent(MainActivity.this, WebPageInformationGenerator.class));
    }

    private void makeOrder() {
        startActivity(new Intent(MainActivity.this, OrderActivity.class));
    }

    private void addProducts() {
        startActivity(new Intent(MainActivity.this, Products.class));
    }

    private void purchaseStock() {

        startActivity(new Intent(MainActivity.this, CustomerAccount.class));
    }

    private void sellStock() {

        startActivity(new Intent(MainActivity.this, HomeActivity.class));
    }

    private void viewReports() {

        startActivity(new Intent(MainActivity.this, HomeSummary.class));


    }

    private void addCustomer() {

      //  Toast.makeText(MainActivity.this,"we are soon adding customers",Toast.LENGTH_SHORT).show();

        startActivity(new Intent(MainActivity.this, CustomerActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);

        //MenuItem item = menu.findItem(R.id.search);

   /*     SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                adapter.getFilter().filter(newText);
                return false;
            }
        });*/
        return true;
    }

}