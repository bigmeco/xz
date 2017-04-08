package bigi.testretoflistv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;

import bigi.testretoflistv.POJO.ExampleNewF;
import bigi.testretoflistv.POJO.ResultNewF;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<ResultNewF> data;
    private DataAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }
    private void initViews(){
        recyclerView = (RecyclerView)findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        loadJSON();
    }
    private void loadJSON(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestInterface request = retrofit.create(RequestInterface.class);
        Call<ExampleNewF> call = request.getJSON(1);
        call.enqueue(new Callback<ExampleNewF>() {
            @Override
            public void onResponse(Call<ExampleNewF> call, Response<ExampleNewF> response) {

                ExampleNewF exampleNewF = response.body();
                System.out.println(exampleNewF.getTotalPages()+ "fffffffffffffffffffffffffffffffffffffffffffffffff");
                data = new ArrayList<>(exampleNewF.getAndroid());
                adapter = new DataAdapter(data);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ExampleNewF> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });
    }
}