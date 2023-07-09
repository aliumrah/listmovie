package com.fadli.finalmovie.injec

import com.fadli.finalmovie.data.remoteServices.MovieService
import com.fadli.finalmovie.data.remoteServices.RemoteDataSource
import com.fadli.finalmovie.data.remoteServices.MovieRepositoryImpl
import com.fadli.finalmovie.domain.usecase.GetMovieUseCase
import com.fadli.finalmovie.domain.usecase.GetMovie
import com.fadli.finalmovie.domain.repository.MovieRepository
import com.fadli.finalmovie.util.provideDispatcher
import org.koin.dsl.module

private val dataModule = module {
    factory { RemoteDataSource(get(), get()) }
    factory { MovieService() }
}

private val utilityModule = module {
    factory { provideDispatcher() }
}

private val domainModule = module {
    single<MovieRepository> { MovieRepositoryImpl(get()) }
    factory { GetMovie() }
    factory { GetMovieUseCase() }
}

private val sharedModules = listOf(domainModule, dataModule, utilityModule)

fun getSharedModules() = sharedModules












