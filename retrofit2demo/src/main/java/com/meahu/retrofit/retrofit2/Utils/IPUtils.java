package com.meahu.retrofit.retrofit2.Utils;

import com.meahu.retrofit.retrofit2.model.IPModel;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Tiger on 2016/7/23.
 */
public class IPUtils {
    public static final String URL = "http://ip.taobao.com/service/";

    public interface IPService {
        @GET("getIpInfo.php")
        Call<IPModel> getIpMsg(@Query("ip") String ip);
    }

    static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build();

    public static IPService ipService = retrofit.create(IPService.class);

}
