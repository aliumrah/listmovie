package com.fadli.finalmovie.domain.repository

import com.fadli.finalmovie.domain.model.Movie

internal interface MovieRepository {
    suspend fun getMovies(page: Int): List<Movie>

    suspend fun getMovie(movieId: Int): Movie
}