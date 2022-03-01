package com.example.cleanarchitecturestudy

import androidx.lifecycle.MutableLiveData
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.cleanarchitecturestudy.view.MainActivity
import com.example.core.base.navi.Navigation
import com.example.core.base.util.NetworkManager
import com.example.domain.usecase.movie.GetLocalMoviesUseCase
import com.example.domain.usecase.movie.GetMoviesUseCase
import com.example.domain.usecase.movie.GetPagingMoviesUseCase
import com.example.moviesearch.view.MovieAdapter
import com.example.moviesearch.view.MovieSearchViewModel
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    private lateinit var msViewModel: MovieSearchViewModel

    @get:Rule
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp() {
        val gmUc: GetMoviesUseCase = Mockito.mock(GetMoviesUseCase::class.java)
        val gpmUc: GetPagingMoviesUseCase = Mockito.mock(GetPagingMoviesUseCase::class.java)
        val glmUc: GetLocalMoviesUseCase = Mockito.mock(GetLocalMoviesUseCase::class.java)
        val nM: NetworkManager = Mockito.mock(NetworkManager::class.java)
        val navi: Navigation = Mockito.mock(Navigation::class.java)
        msViewModel = MovieSearchViewModel(gmUc, gpmUc, glmUc, nM, navi)
        msViewModel.testString = "setUp"
    }

    @Test
    fun test_vm() {
        CountDownLatch(1).await(1, TimeUnit.SECONDS)
        assertThat(msViewModel.query.value).isNull()
        Espresso.onView(withId(R.id.search_btn))
            .perform(click())
        Espresso.onView(withId(R.id.et_input))
            .perform(ViewActions.typeText("call"),
                ViewActions.replaceText("bed")
                ,ViewActions.closeSoftKeyboard())
        assertThat(msViewModel.query.value).isNull()
        Espresso.onView(withId(R.id.btn_search))
            .perform(click())
        CountDownLatch(1).await(3, TimeUnit.SECONDS)

//        assertThat(msViewModel.query.value).isEqualTo("call")
    }

    @Test
    fun test_recycler_click() {
        CountDownLatch(1).await(1, TimeUnit.SECONDS)
        Espresso.onView(withId(R.id.search_btn))
            .perform(click())
        Espresso.onView(withId(R.id.et_input))
            .perform(ViewActions.typeText("call"), ViewActions.closeSoftKeyboard())
        Espresso.onView(withId(R.id.btn_search))
            .perform(click())
        CountDownLatch(1).await(3, TimeUnit.SECONDS)
        Espresso.onView(withId(R.id.rv_movies))
            .perform(RecyclerViewActions.scrollToPosition<MovieAdapter.ViewHolder>(5))
        CountDownLatch(1).await(2, TimeUnit.SECONDS)
        Espresso.onView(withId(R.id.rv_movies))
            .perform(RecyclerViewActions.scrollToPosition<MovieAdapter.ViewHolder>(10))
        Espresso.onView(withId(R.id.rv_movies))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<MovieAdapter.ViewHolder>(
                    8,
                    click()
                )
            )
    }

    @Test
    fun test_espresso() {
        Espresso.onView(withId(R.id.search_btn))
            .perform(click())

        // movieSearch Module
        Espresso.onView(withId(R.id.et_input))
            .perform(ViewActions.typeText("call"), ViewActions.closeSoftKeyboard())
        Espresso.onView(withId(R.id.btn_search))
            .perform(click())
        CountDownLatch(1).await(5, TimeUnit.SECONDS) // delay
        Espresso.pressBack() // hardWare back button

        // move Module
        Espresso.onView(withId(R.id.move_btn))
            .perform(click())
        Espresso.onView(withId(R.id.third_btn))
            .perform(click())
        Espresso.onView(withId(R.id.first_btn))
            .perform(click())
        Espresso.onView(withId(R.id.get_data_store))
            .perform(click())

        // presentation Module
        Espresso.onView(withId(R.id.main_btn))
            .perform(click())
        CountDownLatch(1).await(5, TimeUnit.SECONDS)
    }
}
