package com.fadli.finalmovie.data.remoteServices



@kotlinx.serialization.Serializable
internal data class MoviesResponse(
    val results: List<MovieRemote>
)
