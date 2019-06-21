package com.example.vkcofficial.api;



import com.example.vkcofficial.model.LoginResponse;
import com.example.vkcofficial.model.PendingPOResponse;
import com.example.vkcofficial.model.VendorMessageResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by eleganz on 30/4/19.
 */

public interface RetrofitInterface {
    @FormUrlEncoded()
    @POST("/VKC-API/loginOffical")
    Call<LoginResponse> loginOffical(
            @Field("email_id") String email_id,
            @Field("password") String password

    );
 @FormUrlEncoded()
    @POST("/VKC-API/vendorMessage")
    Call<VendorMessageResponse> vendorMessage   (
            @Field("data") String data


    );

 @FormUrlEncoded()
    @POST("/VKC-API/pendingPO")
    Call<PendingPOResponse> pendingPO   (
            @Field("data") String data


    );


}
