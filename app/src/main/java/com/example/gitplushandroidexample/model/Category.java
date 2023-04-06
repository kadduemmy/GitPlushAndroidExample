package com.example.gitplushandroidexample;

import android.media.Image;

public class Category {

    public static final String TABLE_CATEGORY = "customers";
    public static final String CATEGORY_ID ="customer_id";
    public static final String CUSTOMER_FIRST_NAME ="customer_first_name";
    public static final String CUSTOMER_SECOND_NAME = "customer_second_name";
    public static final String CUSTOMER_CONTACT ="customer_contact";
    public static final String ADDRESS_ONE ="customer_address_one";

    int category_id;
    String category_name;
    String category_description;
    Image picture;
    String status;

    public Category() {
    }


}
