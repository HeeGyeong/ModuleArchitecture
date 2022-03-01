package com.example.moviesearch

import com.example.core.base.navi.Navigation
import com.example.core.base.util.NetworkManager
import com.example.domain.usecase.movie.GetLocalMoviesUseCase
import com.example.domain.usecase.movie.GetMoviesUseCase
import com.example.domain.usecase.movie.GetPagingMoviesUseCase
import com.example.moviesearch.view.MovieSearchViewModel
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    private lateinit var msViewModel: MovieSearchViewModel

    @Before
    fun setUp() {
        val gmUc: GetMoviesUseCase = mock(GetMoviesUseCase::class.java)
        val gpmUc: GetPagingMoviesUseCase = mock(GetPagingMoviesUseCase::class.java)
        val glmUc: GetLocalMoviesUseCase = mock(GetLocalMoviesUseCase::class.java)
        val nM: NetworkManager = mock(NetworkManager::class.java)
        val navi: Navigation = mock(Navigation::class.java)

        msViewModel = MovieSearchViewModel(gmUc, gpmUc, glmUc, nM, navi)
        msViewModel.testString = "setUp"
    }

    @Test
    fun late_init_vm() {
        assertThat(msViewModel.testString).isEqualTo("setUp")
        assertThat(msViewModel.unitTest()).isEqualTo("unitTest")

        assertThat(msViewModel.toastMsg).isNotNull()

        // msViewModel is not Mock
//        verify(msViewModel, times(1)).unitTest()
//        verify(msViewModel, times(1)).testString
    }

    // sampleVm is Mock
    private val sampleVM: MovieSearchViewModel = mock(MovieSearchViewModel::class.java)

    @Test
    fun mock_vm() {
        `when`(sampleVM.unitTest()).thenReturn("sampleVM")
        assertThat(sampleVM.unitTest()).isEqualTo("sampleVM")

        verify(sampleVM, times(1)).unitTest()

        `when`(sampleVM.queryTest()).thenReturn("bed")
        assertThat(sampleVM.queryTest()).isEqualTo("bed")

        assertThat(sampleVM.currentQuery).isNull()
    }
}
