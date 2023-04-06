package com.example.SimplePosMobile.customers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.SimplePosMobile.R;
import com.example.SimplePosMobile.model.Customer;
import com.example.SimplePosMobile.utils.DbHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class CustomerDetails extends AppCompatActivity {

    EditText customerName, customerSecondName, contact,
            addressOne, addressTwo, city, state, pin, email, label, tin;
    String customerId ;
    DbHelper dbHelper;
    TextView addCustomer, close, deleteCustomer,upDateCustomer;
    ArrayList<Customer> customers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_details);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        dbHelper = new DbHelper(this);

        customerName = findViewById(R.id.customer_first_name);
        customerSecondName = findViewById(R.id.customer_second_name);
        contact = findViewById(R.id.customer_contact);
        addressOne = findViewById(R.id.customer_address_one);
        addressTwo = findViewById(R.id.customer_address_two);
        city = findViewById(R.id.customer_city);
        state = findViewById(R.id.customer_state);
        pin = findViewById(R.id.customer_pin);
        email = findViewById(R.id.customer_email);
        label = findViewById(R.id.customer_label);
        tin = findViewById(R.id.customer_tin);

        //button initialization
        addCustomer = findViewById(R.id.add_customer);
        close = findViewById(R.id.close_textView);
        deleteCustomer = findViewById(R.id.delete_customer);
        upDateCustomer = findViewById(R.id.update_customer);

        Intent intent = getIntent();


        customerId = intent.getStringExtra("CustomerId");
        String name = intent.getStringExtra("DetailName");
        String contacts = intent.getStringExtra("DetailContact");
        String sName = intent.getStringExtra("DetailName2");
        String sAddressOne = intent.getStringExtra("AddressOne");
        String sAddressTwo = intent.getStringExtra("AddressTwo");
        String sState = intent.getStringExtra("State");
        String sCity = intent.getStringExtra("City");
        String sPin = intent.getStringExtra("Pin");
        String sEmail = intent.getStringExtra("Email");
        String sLabel = intent.getStringExtra("Label");
        String sTin = intent.getStringExtra("Tin");

        deleteCustomer.setOnClickListener(v -> deleteCustomer());
        close.setOnClickListener(v->closeActivity());

          if (customerId==null) {

            actionBar.setTitle("Add New Customer");
            addCustomer.setVisibility(View.VISIBLE);
            addCustomer.setOnClickListener(v -> addCustomer());
        }

          else {

              actionBar.setTitle(name);
              customerName.setText(name);
              contact.setText(String.valueOf(contacts));
              customerSecondName.setText(sName);
              addressOne.setText(sAddressOne);
              addressTwo.setText(sAddressTwo);
              state.setText(sState);
              pin.setText(sPin);
              city.setText(sCity);
              email.setText(sEmail);
              label.setText(sLabel);
              tin.setText(sTin);

               deleteCustomer.setVisibility(View.VISIBLE);
               upDateCustomer.setVisibility(View.VISIBLE);
               upDateCustomer.setOnClickListener(v->updateCustomer());
               addCustomer.setOnClickListener(v->updateCustomer());

          }

    }

    private void closeActivity() {

        Intent closeCustomerDetails = new Intent(CustomerDetails.this, CustomerActivity.class);
        closeCustomerDetails. addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(closeCustomerDetails);
    }

    private void addCustomer() {

        String name = customerName.getText().toString().trim();
        String cName = customerSecondName.getText().toString().trim();
        String cContact = contact.getText().toString().trim();
        String cAddressOne = addressOne.getText().toString().trim();
        String cAddressTwo = addressTwo.getText().toString().trim();
        String cCity = city.getText().toString().trim();
        String cState = state.getText().toString().trim();
        String cEmail = email.getText().toString().trim();
        String cPin = pin.getText().toString().trim();
        String cLabel = label.getText().toString().trim();
        String cTin = tin.getText().toString().trim();


        if (name.isEmpty()) {

            customerName.setError("Name is needed");
            customerName.requestFocus();
            return;
        }

        if (cContact.isEmpty()) {

            contact.setError("contact needed");
            contact.requestFocus();
            return;
        }

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String joiningDate = sdf.format(cal.getTime());

        //inserting values into the database
     if(dbHelper.addCustomer(name,cName,cContact,cAddressOne,cAddressTwo,cCity,cState,cEmail,cPin,cLabel,cTin,joiningDate)){

         Intent customerAdded = new Intent(CustomerDetails.this, CustomerActivity.class);
         customerAdded. addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);;
         startActivity(customerAdded);
         Toast.makeText(this, "Customer Added", Toast.LENGTH_SHORT).show();

     }

     else
         Toast.makeText(this,"customer not added",Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.customer_details_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.deleteC)
        {
            deleteCustomer();

        }
        return super.onOptionsItemSelected(item);
    }

    private void updateCustomer() {

        String name = customerName.getText().toString().trim();
        String name2 = customerSecondName.getText().toString().trim();
        String uContact = contact.getText().toString().trim();
        String uAddressOne = addressOne.getText().toString().trim();
        String uAddressTwo = addressTwo.getText().toString().trim();
        String uCity = city.getText().toString().trim();
        String uState = state.getText().toString().trim();
        String uEmail = email.getText().toString().trim();
        String uPin = pin.getText().toString().trim();
        String uLabel = label.getText().toString().trim();
        String uTin = tin.getText().toString().trim();

        if (name.isEmpty()) {

            customerName.setError("Name cant be empty");
            customerName.requestFocus();
            return;
        }

        if (uContact.isEmpty()) {

            contact.setError("Salary cant be empty");
            contact.requestFocus();
            return;
        }

        dbHelper.updateCustomer(Integer.parseInt(customerId),name,name2,uContact,uAddressOne,uAddressTwo,uCity,uState,uEmail,uPin,uLabel,uTin);

        Toast.makeText(CustomerDetails.this, "Customer Updated", Toast.LENGTH_SHORT).show();

        Intent customerUpdated = new Intent(CustomerDetails.this, CustomerActivity.class);
        customerUpdated. addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(customerUpdated);

        loadCustomerFromDatabaseAgain();

    }

    private void deleteCustomer() {

        AlertDialog.Builder alertDialog =   new AlertDialog.Builder(this);

        alertDialog .setMessage("Are you sure");

        alertDialog .setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dbHelper.deleteCustomer(Integer.valueOf(customerId));
                loadCustomerFromDatabaseAgain();

                Intent customerAdded = new Intent(CustomerDetails.this, CustomerActivity.class);
                customerAdded. addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(customerAdded);
                Toast.makeText(CustomerDetails.this, "customer deleted", Toast.LENGTH_SHORT).show();

            }
        });
        alertDialog.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        AlertDialog dialog = alertDialog.create();
        dialog .show();
    }

    private void loadCustomerFromDatabaseAgain() {

        Cursor cursor =  dbHelper.getAllCustomers();
        customers = new ArrayList<Customer>();

        if (cursor.moveToFirst()) {
            do {
                customers.add(new Customer(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6),
                        cursor.getString(7),
                        cursor.getString(8),
                        cursor.getString(9),
                        cursor.getString(10),
                        cursor.getString(11),
                        cursor.getString(12)

                ));


            }
            while (cursor.moveToNext());
        }


    }
}


