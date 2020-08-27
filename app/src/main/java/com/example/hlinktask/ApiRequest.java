package com.example.hlinktask;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiRequest {

    @GET("api/v1/images/latest/")
    Call<Article> getMovieArticles();
}
