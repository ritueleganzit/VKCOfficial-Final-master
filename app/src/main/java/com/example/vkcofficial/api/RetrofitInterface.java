package com.example.vkcofficial.api;



import com.example.vkcofficial.model.AllArticleResponse;
import com.example.vkcofficial.model.AllPOResponse;
import com.example.vkcofficial.model.AllVendorListResponse;
import com.example.vkcofficial.model.ArticleWiseDefectResponse;
import com.example.vkcofficial.model.CompletePoNotificationResponse;
import com.example.vkcofficial.model.LoginResponse;
import com.example.vkcofficial.model.PendingPOResponse;
import com.example.vkcofficial.model.ReportResponse;
import com.example.vkcofficial.model.SearchDataResponse;
import com.example.vkcofficial.model.SearchPOResponse;
import com.example.vkcofficial.model.TotalVendorDefectResponse;
import com.example.vkcofficial.model.VendorMessageResponse;
import com.example.vkcofficial.model.griddata.POGridResponse;
import com.example.vkcofficial.model.p_grid.PendingPoGridResponse;

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


 @FormUrlEncoded()
    @POST("/VKC-API/pendingArticle")
    Call<PendingPoGridResponse> pendingArticle   (
            @Field("pur_doc_num") String pur_doc_num,
            @Field("article") String article,
            @Field("doc_date") String doc_date


    );

@FormUrlEncoded()
    @POST("/VKC-API/pendingGrid")
    Call<POGridResponse> pendingGrid   (
            @Field("pur_doc_num") String pur_doc_num,
            @Field("article") String article,
            @Field("doc_date") String doc_date


    );


    @POST("/VKC-API/allPoNumber")
    Call<AllPOResponse> allPoNumber   (



    );


    @FormUrlEncoded
    @POST("/VKC-API/poAritcleList")
    Call<AllArticleResponse> poAritcleList   (

            @Field("pur_doc_num") String pur_doc_num

    );
@FormUrlEncoded
    @POST("/VKC-API/completePoList")
    Call<SearchPOResponse> completePoList   (

            @Field("pur_doc_num") String pur_doc_num,
            @Field("article") String article,
            @Field("date") String date,
            @Field("vendor_id") String vendor_id

    );


@FormUrlEncoded
    @POST("/VKC-API/totalVendorDefect")
    Call<TotalVendorDefectResponse> totalVendorDefect   (

            @Field("article") String article

    );
@FormUrlEncoded
    @POST("/VKC-API/articleWiseDefect")
    Call<ArticleWiseDefectResponse> articleWiseDefect   (

            @Field("article") String article

    );

@FormUrlEncoded
    @POST("/VKC-API/report")
    Call<ReportResponse> report   (

            @Field("daterange") String daterange,
            @Field("vendor_id") String vendor_id,
            @Field("type") String type

    );@FormUrlEncoded
    @POST("/VKC-API/serchVendorList")
    Call<SearchDataResponse> serchVendorList   (

            @Field("search") String search

    );

    @POST("/VKC-API/allVendorList")
    Call<AllVendorListResponse> allVendorList   (


    );


    @POST("/VKC-API/allArticleList")
    Call<AllArticleResponse> allArticleList   (


    );

    @POST("/VKC-API/completePoNotification")
    Call<CompletePoNotificationResponse> completePoNotification   (


    );
}
