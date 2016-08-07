package com.meahu.retrofit.interfaceservice;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Tiger on 2016/7/23.
 */
public interface RequestSerives {
//http://106.3.227.33/pulamsi/mobileLogin/submit.html
    @POST("mobileLogin/submit.html")
    Call<String> getString(@Query("loginname")String loginname,
                           @Query("nloginpwd") String nloginpwd);

}
