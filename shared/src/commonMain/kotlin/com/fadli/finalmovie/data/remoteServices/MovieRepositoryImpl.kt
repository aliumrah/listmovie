package com.fadli.finalmovie.data.remoteServices

import com.fadli.finalmovie.data.util.toMovie
import com.fadli.finalmovie.domain.model.Movie
import com.fadli.finalmovie.domain.repository.MovieRepository

internal class MovieRepositoryImpl(
    private val remoteDateSource: RemoteDataSource
): MovieRepository {

    override suspend fun getMovies(page: Int): List<Movie> {
        return remoteDateSource.getMovies(page = page).results.map {
            it.toMovie()
        }
    }

    override suspend fun getMovie(movieId: Int): Movie {
        return remoteDateSource.getMovie(movieId = movieId).toMovie()
    }
}