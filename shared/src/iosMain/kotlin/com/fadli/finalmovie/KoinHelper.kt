package com.fadli.finalmovie

import com.fadli.finalmovie.injec.getSharedModules
import org.koin.core.context.startKoin

fun initKoin(){
    startKoin {
        modules(getSharedModules())
    }
}