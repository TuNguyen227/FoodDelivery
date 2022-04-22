package com.example.fooddelivery.modelMovieData

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.fooddelivery.services.MovieRESTClient
import kotlinx.coroutines.launch

class movieModel : ViewModel() {
    private var movieData: MutableLiveData<List<Movie>> = MutableLiveData<List<Movie>>()
    private var list= listOf<Movie>()
    val _movieData:LiveData<List<Movie>>
        get()=movieData

    fun getMovieNowPlaying()
    {
        viewModelScope.launch {
            val movieResponse=MovieRESTClient.getInstace()._api.listOfnowplaying("en-US", 1, "9ce4d2e6f7246681a9d6c76b0c1ca341")
            list=movieResponse.results
            movieData.postValue(movieResponse.results)
        }

    }
    fun getMovieTopPlaying() {
        viewModelScope.launch {
            val movieResponse=MovieRESTClient.getInstace()._api.listOfupcoming("en-US", 1, "9ce4d2e6f7246681a9d6c76b0c1ca341")
            list=movieResponse.results
            movieData.postValue(movieResponse.results)
        }

    }

    fun getListMovie(): List<Movie> {
        return list
    }

}