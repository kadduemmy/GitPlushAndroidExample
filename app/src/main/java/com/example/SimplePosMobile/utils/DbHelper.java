package com.example.gitplushandroidexample.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.gitplushandroidexample.model.Category;
import com.example.gitplushandroidexample.model.Customer;
import com.example.gitplushandroidexample.model.Product;

public class DbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "treskbills";
    public static final int DATABASE_VERSION = 1;
    public DbHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        // create table customers
        sqLiteDatabase.execSQL(Customer.CREATE_TABLE_CUSTOMERS);

        //create table customers
        sqLiteDatabase.execSQL(Product.CREATE_TABLE_PRODUCTS);

        //create table category
        sqLiteDatabase.execSQL(Category.CREATE_TABLE_CATEGORY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }

   public boolean addCategory(String name,String description,String picture, String status){

       SQLiteDatabase sqLiteDatabase = getWritableDatabase();
       ContentValues cv = new ContentValues();
       cv.put(Category.CATEGORY_NAME, name);
       cv.put(Category.CATEGORY_DESCRIPTION, description);
       cv.put(Category.CATEGORY_PICTURE,picture);
       cv.put(Category.CATEGORY_PICTURE,status);

       return sqLiteDatabase.insert(Category.CREATE_TABLE_CATEGORY, null, cv) != -1;
   }

    public boolean addCustomer(String fName, String sName, String contact, String addressOne, String addressTwo,
                               String city, String state, String pin, String email, String label, String tin,
                               String joining_date) {

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(Customer.CUSTOMER_FIRST_NAME, fName);
        cv.put(Customer.CUSTOMER_SECOND_NAME, sName);
        cv.put(Customer.CUSTOMER_CONTACT, contact);
        cv.put(Customer.ADDRESS_ONE, addressOne);
        cv.put(Customer.ADDRESS_TWO, addressTwo);
        cv.put(Customer.CUSTOMER_CITY, city);
        cv.put(Customer.CUSTOMER_STATE, state);
        cv.put(Customer.CUSTOMER_PIN, pin);
        cv.put(Customer.CUSTOMER_EMAIL, email);
        cv.put(Customer.CUSTOMER_LABEL, label);
        cv.put(Customer.CUSTOMER_TIN, tin);
        cv.put(Customer.CUSTOMER_JOINING_DATE, joining_date);

        return sqLiteDatabase.insert(Customer.TABLE_CUSTOMERS, null, cv) != -1;

    }

    public boolean addProduct(int sku, int ven_id, String name, String description, int supp_id, int category_id,
                              int qty, double price, double msrp, int product_size, String color, double discount,
                              int weight, int in_stock, int unit_order, int re_order_level, int product_level,
                              String pic, int ranking, String note) {

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put(Product.PRODUCT_SKU, sku);
        cv.put(Product.VENDOR_PRODUCT_ID, ven_id);
        cv.put(Product.PRODUCT_NAME, name);
        cv.put(Product.PRODUCT_DESCRIPTION, description);
        cv.put(Product.SUPPLIER_ID, supp_id);
        cv.put(Product.CATEGORY_ID, category_id);
        cv.put(Product.QUANTITY_PER_UNIT, qty);
        cv.put(Product.UNIT_PRICE, price);
        cv.put(Product.MSRP, msrp);
        cv.put(Product.AVAILABLE_SIZE, product_size);
        cv.put(Product.AVAILABLE_COLORS, color);
        cv.put(Product.DISCOUNT, discount);
        cv.put(Product.UNITS_WEIGHT, weight);
        cv.put(Product.UNITS_IN_STOCK, in_stock);
        cv.put(Product.UNITS_ON_ORDER, unit_order);
        cv.put(Product.REORDER_LEVEL, re_order_level);
        cv.put(Product.PRODUCT_LEVEL, product_level);
        cv.put(Product.PICTURE, pic);
        cv.put(Product.RANKING, ranking);
        cv.put(Product.NOTE, note);

        return sqLiteDatabase.insert(Product.TABLE_PRODUCTS, null, cv) != -1;

    }

    public Cursor getAllCustomers() {

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        return sqLiteDatabase.rawQuery("SELECT * FROM " + Customer.TABLE_CUSTOMERS, null);

    }


    public Cursor getAllProducts() {

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        return sqLiteDatabase.rawQuery("SELECT * FROM " + Product.TABLE_PRODUCTS, null);

    }

    public boolean updateCustomer(int customer_id, String fName, String sName, String contact, String addressOne,
                           String addressTwo, String city, String state, String pin, String email, String label,
                           String tin) {

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put(Customer.CUSTOMER_FIRST_NAME, fName);
        cv.put(Customer.CUSTOMER_SECOND_NAME, sName);
        cv.put(Customer.CUSTOMER_CONTACT, contact);
        cv.put(Customer.ADDRESS_ONE, addressOne);
        cv.put(Customer.ADDRESS_TWO, addressTwo);
        cv.put(Customer.CUSTOMER_CITY, city);
        cv.put(Customer.CUSTOMER_STATE, state);
        cv.put(Customer.CUSTOMER_PIN, pin);
        cv.put(Customer.CUSTOMER_EMAIL, email);
        cv.put(Customer.CUSTOMER_LABEL, label);
        cv.put(Customer.CUSTOMER_TIN, tin);


        return sqLiteDatabase.update(Customer.TABLE_CUSTOMERS, cv, Customer.CUSTOMER_ID + "=?", new String[]{String.valueOf(customer_id)}) > 0;

    }

    public boolean updateProduct(int id, int sku, int ven_id, String name, String description, int supp_id,
                          int category_id, int qty, double price, double msrp, int product_size,
                          String color, double discount, int weight, int in_stock, int unit_order,
                          int re_order_level, int product_level, String pic, int ranking, String note) {

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put(Product.PRODUCT_SKU, sku);
        cv.put(Product.VENDOR_PRODUCT_ID, ven_id);
        cv.put(Product.PRODUCT_NAME, name);
        cv.put(Product.PRODUCT_DESCRIPTION, description);
        cv.put(Product.SUPPLIER_ID, supp_id);
        cv.put(Product.CATEGORY_ID, category_id);
        cv.put(Product.QUANTITY_PER_UNIT, qty);
        cv.put(Product.UNIT_PRICE, price);
        cv.put(Product.MSRP, msrp);
        cv.put(Product.AVAILABLE_SIZE, product_size);
        cv.put(Product.AVAILABLE_COLORS, color);
        cv.put(Product.DISCOUNT, discount);
        cv.put(Product.UNITS_WEIGHT, weight);
        cv.put(Product.UNITS_IN_STOCK, in_stock);
        cv.put(Product.UNITS_ON_ORDER, unit_order);
        cv.put(Product.REORDER_LEVEL, re_order_level);
        cv.put(Product.PRODUCT_LEVEL, product_level);
        cv.put(Product.PICTURE, pic);
        cv.put(Product.RANKING, ranking);
        cv.put(Product.NOTE, note);

        return sqLiteDatabase.update(Product.TABLE_PRODUCTS, cv, Product.PRODUCT_ID + "=?", new String[]{String.valueOf(id)}) > 0;

    }

    public boolean deleteCustomer(int id) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        return sqLiteDatabase.delete(Customer.TABLE_CUSTOMERS, Customer.CUSTOMER_ID + "=?", new String[]{String.valueOf(id)}) > 0;
    }

    public boolean deleteProduct(int id) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        return sqLiteDatabase.delete(Product.TABLE_PRODUCTS, Product.PRODUCT_ID + "=?", new String[]{String.valueOf(id)}) > 0;
    }

}
