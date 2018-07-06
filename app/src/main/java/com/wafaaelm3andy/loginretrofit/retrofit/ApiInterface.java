package com.wafaaelm3andy.loginretrofit.retrofit;

import com.wafaaelm3andy.loginretrofit.model.User;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiInterface {
@POST("user")
Call<User>createAccount(@Body User user) ;
@Multipart
@POST ("upload")
    Call<ResponseBody>uploadPhoto(@Part ("description")RequestBody description,
                                  @Part MultipartBody.Part photo);
}
