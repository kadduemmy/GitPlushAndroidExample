package com.example.gitplushandroidexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.webkit.WebView;

import com.example.gitplushandroidexample.model.Customer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WebPageInformationGenerator extends AppCompatActivity {

    SQLiteDatabase sqLiteDatabase;
    ArrayList<Customer> customers;
    public static final String DATABASE_NAME = "treskbills";
    File file;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_page_information_generator);


        WebView webView = findViewById(R.id.webview); // get reference to the WebView
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);


        sqLiteDatabase = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);


        StringBuilder sb = new StringBuilder();
        sb.append("<h1>Km hardware</h1>");
        sb.append("<h2 style=\"color:maroon\">reciept review</h2>");
        sb.append("<html><body>");
        sb.append("<table border='0' width='100%'>");
        sb.append("<tr><td>ID</td><td>KM HARDWARE </td></tr>");
        sb.append("<tr style=\"background-color: lightgray\"><td>INVOICE</td><td>0704576693</td></tr>");
        sb.append("<tr><td>Email</td><td>treskmac@gmail</td></tr>");
        sb.append("<tr><td>no</td><td>0225</td></tr>");
        sb.append("</table></body></html>");


        sb.append("<table border='0' width='100%' height ='70%'>");
        String sql = "SELECT * FROM customers";
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        customers = new ArrayList<Customer>();

        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String name2 = cursor.getString(2);
            String contact = cursor.getString(3);
            sb.append("<tr><td>" + id + "</td><td>" + name + "</td></tr>");
        }
        cursor.close();

        sb.append("</table></body></html>");
        file = new File(getFilesDir(), "data.html");
        FileWriter writer;

        try {
            writer = new FileWriter(file);
            writer.write(sb.toString());
            writer.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
        webView.loadUrl("file://" + file.getAbsolutePath());

    }
    }