package com.megamind.midtermprogram2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.megamind.midtermprogram2.Adapter.DataAdapter;
import com.megamind.midtermprogram2.Pojo.Data;
import com.megamind.midtermprogram2.Pojo.Datum;
import com.megamind.midtermprogram2.Retrofit.ApiService;
import com.megamind.midtermprogram2.Retrofit.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    List<Datum> data;
    RecyclerView recyclerView;
    DataAdapter adapter;
    ProgressBar progressBar;
    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);

        ApiService apiService = RetrofitClient.getApiService();
        Call<Data> call = apiService.getData();
        data = new ArrayList<>();
        progressBar.setVisibility(View.VISIBLE);

        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                progressBar.setVisibility(View.GONE);

                if (response.isSuccessful()) {
                    data = response.body().getData();
                    adapter = new DataAdapter(MainActivity.this, data);
                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(MainActivity.this, "Some Problem occurred. Please try again", Toast.LENGTH_SHORT).show();
                    try {
                        Log.e(TAG, response.errorBody().string());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, "There was some problem retrieving the call", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
