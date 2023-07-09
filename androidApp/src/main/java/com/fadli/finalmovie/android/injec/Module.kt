package com.fadli.finalmovie.android.injec

import com.fadli.finalmovie.android.detailpage.DetailViewModel
import com.fadli.finalmovie.android.homepage.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { params -> DetailViewModel(getMovieUseCase = get(), movieId = params.get()) }
}