package com.example.moviesearch.view

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.core.base.BaseViewModel
import com.example.core.base.navi.Navigation
import com.example.core.base.util.NetworkManager
import com.example.domain.model.Movie
import com.example.domain.usecase.movie.GetLocalMoviesUseCase
import com.example.domain.usecase.movie.GetMoviesUseCase
import com.example.domain.usecase.movie.GetPagingMoviesUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * MovieSearchActivity 에 사용되는 VM
 *
 * 해당 Activity 에서 사용되는 UseCase 를 모두 파라미터로 받는다.
 */
class MovieSearchViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val getPagingMoviesUseCase: GetPagingMoviesUseCase,
    private val getLocalMoviesUseCase: GetLocalMoviesUseCase,
    private val networkManager: NetworkManager,
    private val navigation: Navigation
) : BaseViewModel(navigation) {

    var currentQuery: String = "" // 현재 검색어
    val query = MutableLiveData<String>() // 검색어(EditText two-way binding)

    // 영화 리스트가 저장되는 변수. 해당 변수는 xml 에서 binding 되어 실제로 데이터를 뿌려주게 된다.
    private val _movieList = MutableLiveData<MutableList<Movie>>()
    val movieList: LiveData<MutableList<Movie>> get() = _movieList

    // 검색 결과에 따른 toast 메세지.
    private val _toastMsg = MutableLiveData<MessageSet>()
    val toastMsg: LiveData<MessageSet> get() = _toastMsg

    var testString = "default"
    fun unitTest(): String {
        testString = "unitTest"
        return testString
    }

    fun queryTest(): String {
        return currentQuery
    }

    // 영화 검색
    fun requestMovie() {
        currentQuery = query.value.toString().trim()
        if (currentQuery.isEmpty()) {
            _toastMsg.value = MessageSet.EMPTY_QUERY
            return
        }
        if (!checkNetworkState()) return // 네트워크 연결 유무
        compositeDisposable.add(
            getMoviesUseCase(currentQuery)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { showProgress() }
                .doAfterTerminate { hideProgress() }
                .subscribe({ movies -> // currentQuery 를 사용하여 검색한 결과 값이 movie 에 들어있다.
                    if (movies.isEmpty()) {
                        _toastMsg.value = MessageSet.NO_RESULT
                    } else {
                        _movieList.value = movies as ArrayList<Movie>
                        _toastMsg.value = MessageSet.SUCCESS
                    }
                }, {
                    _toastMsg.value = MessageSet.ERROR
                })
        )
    }

    // 검색한 영화 더 불러오기
    fun requestPagingMovie(offset: Int) {
        if (!checkNetworkState()) return // 네트워크 연결 유무
        compositeDisposable.add(
            getPagingMoviesUseCase(currentQuery, offset)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { showProgress() }
                .doAfterTerminate { hideProgress() }
                .subscribe({ movies ->
                    val pagingMovieList = _movieList.value!!
                    pagingMovieList.addAll(movies)
                    _movieList.value = pagingMovieList
                    _toastMsg.value = MessageSet.SUCCESS
                }, {
                    when (it.message) {
                        "LAST_PAGE" -> _toastMsg.value = MessageSet.LAST_PAGE
                        else -> _toastMsg.value = MessageSet.ERROR
                    }
                })
        )
    }

    private fun checkNetworkState(): Boolean {
        return if (networkManager.checkNetworkState()) {
            true
        } else {
            requestLocalMovies()
            false
        }
    }

    private fun requestLocalMovies() {
        compositeDisposable.add(
            // getLocalMoviesUseCase.execute(currentQuery)
            getLocalMoviesUseCase(currentQuery)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { showProgress() }
                .doAfterTerminate { hideProgress() }
                .subscribe({ movies ->
                    if (movies.isEmpty()) {
                        _toastMsg.value = MessageSet.NETWORK_NOT_CONNECTED
                    } else {
                        _movieList.value = movies as ArrayList<Movie>
                        _toastMsg.value = MessageSet.LOCAL_SUCCESS
                    }
                }, {
                    _toastMsg.value = MessageSet.NETWORK_NOT_CONNECTED
                })
        )
    }

    enum class MessageSet {
        LAST_PAGE,
        EMPTY_QUERY,
        NETWORK_NOT_CONNECTED,
        ERROR,
        SUCCESS,
        NO_RESULT,
        LOCAL_SUCCESS
    }
}
