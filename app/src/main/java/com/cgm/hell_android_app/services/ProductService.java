package com.cgm.hell_android_app.services;

import com.cgm.hell_android_app.entities.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductService {
    @GET("products")
    Call<List<Product>>getProductFromRestAPI();
}
