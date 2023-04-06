package com.example.gitplushandroidexample.model;

public class Product {

    public static final String TABLE_PRODUCTS = "products";

    public static final String PRODUCT_ID ="product_id";
    public static final String PRODUCT_SKU ="product_sku";
    public static final String VENDOR_PRODUCT_ID = "vendor_id";
    public static final String PRODUCT_NAME ="product_name";
    public static final String PRODUCT_DESCRIPTION ="product_description";
    public static final String SUPPLIER_ID ="supplier_id";
    public static final String CATEGORY_ID = "category_id";
    public static final String QUANTITY_PER_UNIT ="product_qty";
    public static final String UNIT_PRICE ="product_price";
    public static final String MSRP ="product_msrp";
    public static final String AVAILABLE_SIZE = "product_size";
    public static final String AVAILABLE_COLORS ="product_color";
    public static final String DISCOUNT = "discount";
    public static final String UNITS_WEIGHT ="product_weight";
    public static final String UNITS_IN_STOCK="product_in_stock";
    public static final String UNITS_ON_ORDER ="product_unit_order";
    public static final String REORDER_LEVEL = "product_reorder_level";
    public static final String PRODUCT_LEVEL ="product_level";
    public static final String PICTURE ="product_picture";
    public static final String RANKING ="ranking";
    public static final String NOTE ="note";

    int product_id;
    int product_sku;
    int vendor_id;
    String product_name;
    String product_description;
    int supplier_id;
    int category_id;
    int product_qty;
    double product_price;
    double product_msrp;
    int product_size;
    String product_color;
    double discount;
    int product_weight;
    int product_in_stock;
    int product_unit_order;
    int product_reorder_level;
    int product_level;
    String product_picture;
    int ranking;
    String note;

    public static final String CREATE_TABLE_PRODUCTS = "CREATE TABLE IF NOT EXISTS "+TABLE_PRODUCTS+" (\n"
            +PRODUCT_ID+ " INTEGER NOT NULL CONSTRAINT products_pk PRIMARY KEY AUTOINCREMENT,\n"
            +PRODUCT_SKU+ " INTEGER,\n"
            +VENDOR_PRODUCT_ID+ " INTEGER, \n"
            +PRODUCT_NAME+ " varchar (200) NOT NULL, \n"
            +PRODUCT_DESCRIPTION+ " varchar (200) ,\n"
            +SUPPLIER_ID+ " INTEGER, \n"
            +CATEGORY_ID+ " INTEGER, \n"
            +QUANTITY_PER_UNIT+ " INTEGER,\n"
            +UNIT_PRICE +" double, \n"
            +MSRP+ " double,  \n"
            +AVAILABLE_SIZE+ " INTEGER ,\n"
            +AVAILABLE_COLORS+ " varchar(200), \n"
            +DISCOUNT+ " double, \n"
            +UNITS_WEIGHT+ " INTEGER,\n"
            +UNITS_IN_STOCK+ " INTEGER, \n"
            +UNITS_ON_ORDER+" INTEGER, \n"
            +REORDER_LEVEL+ " INTEGER,\n"
            +PRODUCT_LEVEL+ " INTEGER, \n"
            +PICTURE+ " varchar(200), \n"
            +RANKING+ " INTEGER,\n"
            +NOTE+ " varchar(200) \n"+
            ");";


    public Product() {
    }


    public Product(int product_id, int product_sku, int vendor_id, String product_name,
                   String product_description, int supplier_id, int category_id, int product_qty,
                   double product_price, double product_msrp, int product_size, String product_color,
                   double discount, int product_weight, int product_in_stock, int product_unit_order,
                   int product_reorder_level, int product_level, String product_picture, int ranking,
                   String note) {

        this.product_id = product_id;
        this.product_sku = product_sku;
        this.vendor_id = vendor_id;
        this.product_name = product_name;
        this.product_description = product_description;
        this.supplier_id = supplier_id;
        this.category_id = category_id;
        this.product_qty = product_qty;
        this.product_price = product_price;
        this.product_msrp = product_msrp;
        this.product_size = product_size;
        this.product_color = product_color;
        this.discount = discount;
        this.product_weight = product_weight;
        this.product_in_stock = product_in_stock;
        this.product_unit_order = product_unit_order;
        this.product_reorder_level = product_reorder_level;
        this.product_level = product_level;
        this.product_picture = product_picture;
        this.ranking = ranking;
        this.note = note;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getProduct_sku() {
        return product_sku;
    }

    public void setProduct_sku(int product_sku) {
        this.product_sku = product_sku;
    }

    public int getVendor_id() {
        return vendor_id;
    }

    public void setVendor_id(int vendor_id) {
        this.vendor_id = vendor_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public int getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getProduct_qty() {
        return product_qty;
    }

    public void setProduct_qty(int product_qty) {
        this.product_qty = product_qty;
    }

    public double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }

    public double getProduct_msrp() {
        return product_msrp;
    }

    public void setProduct_msrp(double product_msrp) {
        this.product_msrp = product_msrp;
    }

    public int getProduct_size() {
        return product_size;
    }

    public void setProduct_size(int product_size) {
        this.product_size = product_size;
    }

    public String getProduct_color() {
        return product_color;
    }

    public void setProduct_color(String product_color) {
        this.product_color = product_color;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getProduct_weight() {
        return product_weight;
    }

    public void setProduct_weight(int product_weight) {
        this.product_weight = product_weight;
    }

    public int getProduct_in_stock() {
        return product_in_stock;
    }

    public void setProduct_in_stock(int product_in_stock) {
        this.product_in_stock = product_in_stock;
    }

    public int getProduct_unit_order() {
        return product_unit_order;
    }

    public void setProduct_unit_order(int product_unit_order) {
        this.product_unit_order = product_unit_order;
    }

    public int getProduct_reorder_level() {
        return product_reorder_level;
    }

    public void setProduct_reorder_level(int product_reorder_level) {
        this.product_reorder_level = product_reorder_level;
    }

    public int getProduct_level() {
        return product_level;
    }

    public void setProduct_level(int product_level) {
        this.product_level = product_level;
    }

    public String getProduct_picture() {
        return product_picture;
    }

    public void setProduct_picture(String product_picture) {
        this.product_picture = product_picture;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
