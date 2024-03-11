package com.cgm.hell_android_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.cgm.hell_android_app.entities.Product;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView productListView = findViewById(R.id.productList);

        List<Product> productListData = Arrays.asList(
                new Product("Sam sung", 700, "p1.jpg"),
                new Product("Iphone 15 pro max", 1200, "p2.jpg"));

        ArrayAdapter<Product> adapter = new ArrayAdapter<Product>(this,
                android.R.layout.simple_list_item_1, productListData);

        productListView.setAdapter(adapter);
    }
}