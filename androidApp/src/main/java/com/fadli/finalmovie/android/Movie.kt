package com.fadli.finalmovie.android

import android.app.Application
import com.fadli.finalmovie.android.injec.appModule
import com.fadli.finalmovie.injec.getSharedModules
import org.koin.core.context.startKoin

class Movie: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule + getSharedModules())
        }
    }
}