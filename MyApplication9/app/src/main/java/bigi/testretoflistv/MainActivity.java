package bigi.testretoflistv;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import bigi.testretoflistv.POJO.ExampleNewF;
import bigi.testretoflistv.POJO.ResultNewF;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<ResultNewF> movieArrayList;
    private DataAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.card_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadJSON();
    }

    private void loadJSON() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestInterface request = retrofit.create(RequestInterface.class);
        Call<ExampleNewF> call = request.getJSON(1);
        call.enqueue(new Callback<ExampleNewF>() {
            @Override
            public void onResponse(Call<ExampleNewF> call, Response<ExampleNewF> response) {
                List<ResultNewF> movies = response.body().getResults();
                recyclerView.setAdapter(new DataAdapter(movies, getApplicationContext()));

            }

            @Override
            public void onFailure(Call<ExampleNewF> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
    }
}