package com.demo.imageapidemo.rest;

import com.demo.imageapidemo.Model.ProfileResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("photos")
    Call<List<ProfileResponse>> getProfileDetails();

}
