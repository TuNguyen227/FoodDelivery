package com.example.fooddelivery.modelMovieData

data class MovieResponse(
    val dates: Dates,
    val page: Long,
    val results: List<Movie>,
    val totalPages: Long,
    val totalResults: Long
)
