package com.example.fooddelivery.services

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieRESTClient {
    private lateinit var api:MovieAPI

    val _api: MovieAPI
        get() =api

    init {
        api=createMovieService()
    }
    companion object
    {
        private var instance: MovieRESTClient?=null

        fun getInstace() = instance ?: synchronized(this){
            instance ?: MovieRESTClient().also { instance= it }
        }



    }
    private fun createMovieService() :MovieAPI
    {
        val httpClient= OkHttpClient.Builder()
            .build()

        val retrofit=Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .build()

        return retrofit.create(MovieAPI::class.java)
    }
}