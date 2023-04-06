package com.example.gitplushandroidexample.model;

public class Item {

    int item_id;
    double order_number;
    String item;
    double price;
    int qty;
    double total;

    public Item() {
    }

    public Item(int item_id, double order_number, String item, double price, int qty) {
        this.item_id = item_id;
        this.order_number = order_number;
        this.item = item;
        this.price = price;
        this.qty = qty;
    }

    public Item(int item_id, double order_number, String item, double price, int qty, double total) {
        this.item_id = item_id;
        this.order_number = order_number;
        this.item = item;
        this.price = price;
        this.qty = qty;
        this.total = total;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public double getOrder_number() {
        return order_number;
    }

    public void setOrder_number(double order_number) {
        this.order_number = order_number;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
