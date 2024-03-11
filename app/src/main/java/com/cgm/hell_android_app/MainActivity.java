package com.cgm.hell_android_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.cgm.hell_android_app.entities.Product;
import com.cgm.hell_android_app.services.ProductService;

import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView productListView = findViewById(R.id.productList);

//        List<Product> productListData = Arrays.asList(
//                new Product("Sam sung", 700, "p1.jpg"),
//                new Product("Iphone 15 pro max", 1200, "p2.jpg"));

        Retrofit retrofit = null;
        Call<List<Product>> call = null;
        ProductService productService = null;

        retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/HelloWebApp/rest/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        productService = retrofit.create(ProductService.class);
        call = productService.getProductFromRestAPI();

        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                if(response.isSuccessful()){
                    List<Product> productList = response.body();
                    ArrayAdapter<Product> adapter =
                            new ArrayAdapter<Product>(MainActivity.this,
                            android.R.layout.simple_list_item_1, productList);

                    productListView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

            }
        });


    }
}