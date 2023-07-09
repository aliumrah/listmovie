package com.fadli.finalmovie.android.nav

import androidx.navigation.NavType
import androidx.navigation.navArgument

interface Destination {
    val title: String
    val route: String
    val routeWithArgs: String
}

object Home: Destination {
    override val title: String
        get() = "Daftar Film"

    override val route: String
        get() = "home"

    override val routeWithArgs: String
        get() = route
}

object Detail: Destination {
    override val title: String
        get() = "Detail Daftar Film"

    override val route: String
        get() = "detail"

    override val routeWithArgs: String
        get() = "$route/{filmId}"

    val arguments = listOf(
        navArgument(name = "filmId"){type = NavType.IntType}
    )
}

val movieDestinations = listOf(Home, Detail)















