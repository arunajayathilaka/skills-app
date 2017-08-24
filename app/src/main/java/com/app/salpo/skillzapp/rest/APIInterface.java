package com.app.salpo.skillzapp.rest;

import com.app.salpo.skillzapp.Response;
import com.app.salpo.skillzapp.User;
import com.app.salpo.skillzapp.model.LoginResponse;

import retrofit2.Call;

import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by imalkariyawasam on 8/24/17.
 */

public interface APIInterface {

    @FormUrlEncoded
    @POST("login.json")
    Call<LoginResponse> login(@Field("username") String email, @Field("password") String password);

    @POST("login.json")
    Call<LoginResponse> createUser(@Body User user);

    //delete this
    @GET("/api/users?")
    Call<Response> doGetUserList(@Query("page") String page);


}
