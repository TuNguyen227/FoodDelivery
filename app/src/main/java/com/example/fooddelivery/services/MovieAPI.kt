package com.example.fooddelivery.services

import com.example.fooddelivery.modelMovieData.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {
    @GET("movie/now_playing")
    suspend fun listOfnowplaying(
        @Query("language") language:String,
        @Query("page") page:Int,
        @Query("api_key") key:String
    ) : MovieResponse

    @GET("movie/upcoming")
    suspend fun listOfupcoming(
        @Query("language") language:String,
        @Query("page") page:Int,
        @Query("api_key") key:String
    ) : MovieResponse

}