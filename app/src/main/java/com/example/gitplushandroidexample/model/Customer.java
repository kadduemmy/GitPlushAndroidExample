package com.example.gitplushandroidexample.customers;

import java.util.Date;

public class Customer {

    public static final String TABLE_CUSTOMERS = "customers";
    public static final String CUSTOMER_ID ="customer_id";
    public static final String CUSTOMER_FIRST_NAME ="customer_first_name";
    public static final String CUSTOMER_SECOND_NAME = "customer_second_name";
    public static final String CUSTOMER_CONTACT ="customer_contact";
    public static final String ADDRESS_ONE ="customer_address_one";
    public static final String ADDRESS_TWO ="customer_address_two ";
    public static final String CUSTOMER_CITY ="city";
    public static final String CUSTOMER_STATE ="state";
    public static final String CUSTOMER_EMAIL ="email";
    public static final String CUSTOMER_PIN ="pin";
    public static final String CUSTOMER_LABEL ="label";
    public static final String CUSTOMER_TIN ="tin";
    public static final String CUSTOMER_JOINING_DATE ="joining_date datetime";

    int customer_id;
    String customer_first_name;
    String customer_second_name;
    String customer_contact;
    String customer_address_one;
    String customer_address_two;
    String city;
    String state;
    int pin;
    String email;
    String label;
    String tin;
    String joining_date;


    public static final String CREATE_TABLE_CUSTOMERS = "CREATE TABLE IF NOT EXISTS  "+TABLE_CUSTOMERS +"  (\n" +
            " "+CUSTOMER_ID+" INTEGER NOT NULL CONSTRAINT products_pk PRIMARY KEY AUTOINCREMENT,\n" +
            " "+CUSTOMER_FIRST_NAME+" varchar (200) NOT NULL,\n" +
            " "+CUSTOMER_SECOND_NAME+" varchar(200) NOT NULL, \n" +
            " "+CUSTOMER_CONTACT+" varchar(200) NOT NULL, \n" +
            " "+ADDRESS_ONE+" varchar (200) NOT NULL,\n" +
            "  "+ADDRESS_TWO+" varchar(200) NOT NULL, \n" +
            " "+CUSTOMER_CITY+" varchar (200) NOT NULL,\n" +
            " "+CUSTOMER_STATE+" varchar(200) NOT NULL, \n" +
            "  "+CUSTOMER_EMAIL+" varchar (200) NOT NULL,\n" +
            " "+CUSTOMER_PIN+" INTEGER NOT NULL,\n" +
            " "+CUSTOMER_LABEL+" varchar(200) NOT NULL, \n" +
            " "+CUSTOMER_TIN+" double NOT NULL, \n" +
            " "+CUSTOMER_JOINING_DATE+"  DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL\n" +
            ");";


    public Customer() {
    }

    public Customer(int customer_id, String customer_first_name, String customer_second_name, String customer_contact, String customer_address_one, String customer_address_two, String city, String state, int pin, String email, String label, String tin, String joining_date) {
        this.customer_id = customer_id;
        this.customer_first_name = customer_first_name;
        this.customer_second_name = customer_second_name;
        this.customer_contact = customer_contact;
        this.customer_address_one = customer_address_one;
        this.customer_address_two = customer_address_two;
        this.city = city;
        this.state = state;
        this.pin = pin;
        this.email = email;
        this.label = label;
        this.tin = tin;
        this.joining_date = joining_date;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_first_name() {
        return customer_first_name;
    }

    public void setCustomer_first_name(String customer_first_name) {
        this.customer_first_name = customer_first_name;
    }

    public String getCustomer_second_name() {
        return customer_second_name;
    }

    public void setCustomer_second_name(String customer_second_name) {
        this.customer_second_name = customer_second_name;
    }

    public String getCustomer_contact() {
        return customer_contact;
    }

    public void setCustomer_contact(String customer_contact) {
        this.customer_contact = customer_contact;
    }

    public String getCustomer_address_one() {
        return customer_address_one;
    }

    public void setCustomer_address_one(String customer_address_one) {
        this.customer_address_one = customer_address_one;
    }

    public String getCustomer_address_two() {
        return customer_address_two;
    }

    public void setCustomer_address_two(String customer_address_two) {
        this.customer_address_two = customer_address_two;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public String getJoining_date() {
        return joining_date;
    }

    public void setJoining_date(String joining_date) {
        this.joining_date = joining_date;
    }
}