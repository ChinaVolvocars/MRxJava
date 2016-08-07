package com.meahu.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.meahu.retrofit.interfaceservice.RequestSerives;
import com.meahu.retrofit.retrofit2.Utils.IPUtils;
import com.meahu.retrofit.retrofit2.model.IPModel;

import java.io.IOException;

import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        retrofit();

        Call<IPModel> call = IPUtils.ipService.getIpMsg("124.90.191.217");
        call.enqueue(new Callback<IPModel>() {
            @Override
            public void onResponse(Call<IPModel> call, Response<IPModel> response) {

                Log.i("onResponse", "当前的IP>>>"+response.body().toString());

            }

            @Override
            public void onFailure(Call<IPModel> call, Throwable t) {

                Log.d("onFailure", "错误");

            }
        });


    }

    private void retrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://106.3.227.33/pulamsi/")
                //增加返回值为String的支持
                .addConverterFactory(ScalarsConverterFactory.create())
                //
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        RequestSerives requestSerives = retrofit.create(RequestSerives.class);
        Call<String> call = requestSerives.getString("13288453023", "1234");
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d("onResponse", response.body().toString());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("onFailure", "失败");


            }
        });
    }
}
