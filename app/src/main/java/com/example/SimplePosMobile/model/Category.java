package com.example.gitplushandroidexample.model;

import android.media.Image;

public class Category {

    public static final String TABLE_CATEGORY = "category";
    public static final String CATEGORY_ID ="category_id";
    public static final  String CATEGORY_NAME = "category_name";
    public static final String CATEGORY_DESCRIPTION ="category_description";
    public static final String CATEGORY_PICTURE = "category_picture";
    public static final String CATEGORY_STATUS ="category_status";

    int category_id;
    String category_name;
    String category_description;
    String picture;
    String status;

    public static final String CREATE_TABLE_CATEGORY = "CREATE TABLE IF NOT EXISTS  "+TABLE_CATEGORY  +"  (\n" +
            " "+CATEGORY_ID+" INTEGER NOT NULL CONSTRAINT products_pk PRIMARY KEY AUTOINCREMENT,\n" +
            " "+CATEGORY_NAME+" varchar (200) NOT NULL,\n" +
            " "+CATEGORY_DESCRIPTION+" varchar(200) NOT NULL, \n" +
            " "+CATEGORY_PICTURE+" varchar(200) NOT NULL, \n" +
            " "+CATEGORY_STATUS+" varchar (200) NOT NULL\n" +
            ");";


    public Category() {
    }

    public Category(int category_id, String category_name, String category_description, String picture,
                    String status) {
        this.category_id = category_id;
        this.category_name = category_name;
        this.category_description = category_description;
        this.picture = picture;
        this.status = status;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCategory_description() {
        return category_description;
    }

    public void setCategory_description(String category_description) {
        this.category_description = category_description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
