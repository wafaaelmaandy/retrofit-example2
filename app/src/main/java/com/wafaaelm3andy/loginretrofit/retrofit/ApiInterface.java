package com.wafaaelm3andy.loginretrofit.retrofit;

import com.wafaaelm3andy.loginretrofit.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {
@POST("user")
Call<User>createAccount(@Body User user) ;
}
