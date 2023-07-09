package com.fadli.finalmovie


import com.fadli.finalmovie.domain.usecase.GetMovieUseCase
import com.fadli.finalmovie.domain.model.Movie
import com.fadli.finalmovie.domain.repository.MovieRepository
import com.fadli.finalmovie.domain.usecase.GetMovie
import com.fadli.finalmovie.util.Dispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.dsl.module
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class MovieUseCaseTest {

    private lateinit var getMoviesUseCase: GetMovie
    private lateinit var getMovieDetailUseCase: GetMovieUseCase

    @BeforeTest
    fun setup() {
        // Mock dependencies
        val testModule = module {
            single<Dispatcher> { TestDispatcher() }
            single<MovieRepository> { FakeMovieRepository() }
        }



        // Instantiate use cases
        getMoviesUseCase = GetMovie()
        getMovieDetailUseCase = GetMovieUseCase()

        startKoin {
            modules(testModule)
        }

        // Load Koin modules with test dependencies
        loadKoinModules(testModule)
    }

    //Skenario pengujian sistem
    //1.	Memastikan data list movie yang didapat sesuai

    @Test
    fun testGetMovies() = runBlocking {
        // Perform use case
        val movies = getMoviesUseCase(3)

        // Assertion
        assertEquals(3, movies.size)
        assertEquals("Movie 1", movies[0].title)
        assertEquals("Movie 2", movies[1].title)
        assertEquals("Movie 3", movies[2].title)
    }

    //2.	Memastikan data di detail movie sesuai dengan pencocokan id
    @Test
    fun testGetMovieDetail() = runBlocking {
        // Perform use case
        val movieId = 455476
        val movie = getMovieDetailUseCase(movieId)

        // Assertion
        assertEquals(movieId, movie.id)
        assertEquals("Movie $movieId", movie.title)
        assertEquals("Overview $movieId", movie.description)
        assertEquals("poster$movieId.jpg", movie.imageUrl)
        assertEquals("2022-01-01", movie.releaseDate)
    }

    // Fake implementation of Dispatcher for testing
    class TestDispatcher : Dispatcher {
        override val io = Dispatchers.Unconfined
    }

    // Fake implementation of MovieRepository for testing
    class FakeMovieRepository : MovieRepository {
        override suspend fun getMovies(page: Int): List<Movie> {
            // Simulate API response
            return listOf(
                Movie(1, "Movie 1", "Overview 1", "poster1.jpg", "2022-01-01"),
                Movie(2, "Movie 2", "Overview 2", "poster2.jpg", "2022-02-01"),
                Movie(3, "Movie 3", "Overview 3", "poster3.jpg", "2022-03-01")
            )
        }

        override suspend fun getMovie(movieId: Int): Movie {
            // Simulate API response
            return Movie(movieId, "Movie $movieId", "Overview $movieId", "poster$movieId.jpg", "2022-01-01")
        }
    }
}
