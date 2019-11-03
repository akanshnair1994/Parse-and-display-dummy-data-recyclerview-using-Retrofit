package com.megamind.midtermprogram2.Retrofit;

import com.megamind.midtermprogram2.Pojo.Data;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("bins/17f6k0")
    Call<Data> getData();
}
