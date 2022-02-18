package com.example.moviesearch.view;

import java.lang.System;

/**
 * MovieSearchActivity 에 사용되는 VM
 *
 * 해당 Activity 에서 사용되는 UseCase 를 모두 파라미터로 받는다.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001&B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\b\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020!H\u0002J\u0006\u0010\"\u001a\u00020!J\u000e\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020%R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u00168F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00120\u00168F\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u0018\u00a8\u0006\'"}, d2 = {"Lcom/example/moviesearch/view/MovieSearchViewModel;", "Lcom/example/core/base/BaseViewModel;", "getMoviesUseCase", "Lcom/example/domain/usecase/movie/GetMoviesUseCase;", "getPagingMoviesUseCase", "Lcom/example/domain/usecase/movie/GetPagingMoviesUseCase;", "getLocalMoviesUseCase", "Lcom/example/domain/usecase/movie/GetLocalMoviesUseCase;", "networkManager", "Lcom/example/core/base/util/NetworkManager;", "navigation", "Lcom/example/core/base/navi/Navigation;", "(Lcom/example/domain/usecase/movie/GetMoviesUseCase;Lcom/example/domain/usecase/movie/GetPagingMoviesUseCase;Lcom/example/domain/usecase/movie/GetLocalMoviesUseCase;Lcom/example/core/base/util/NetworkManager;Lcom/example/core/base/navi/Navigation;)V", "_movieList", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/example/domain/model/Movie;", "_toastMsg", "Lcom/example/moviesearch/view/MovieSearchViewModel$MessageSet;", "currentQuery", "", "movieList", "Landroidx/lifecycle/LiveData;", "getMovieList", "()Landroidx/lifecycle/LiveData;", "query", "getQuery", "()Landroidx/lifecycle/MutableLiveData;", "toastMsg", "getToastMsg", "checkNetworkState", "", "requestLocalMovies", "", "requestMovie", "requestPagingMovie", "offset", "", "MessageSet", "moviesearch_debug"})
public final class MovieSearchViewModel extends com.example.core.base.BaseViewModel {
    private final com.example.domain.usecase.movie.GetMoviesUseCase getMoviesUseCase = null;
    private final com.example.domain.usecase.movie.GetPagingMoviesUseCase getPagingMoviesUseCase = null;
    private final com.example.domain.usecase.movie.GetLocalMoviesUseCase getLocalMoviesUseCase = null;
    private final com.example.core.base.util.NetworkManager networkManager = null;
    private final com.example.core.base.navi.Navigation navigation = null;
    private java.lang.String currentQuery = "";
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> query = null;
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.example.domain.model.Movie>> _movieList = null;
    private final androidx.lifecycle.MutableLiveData<com.example.moviesearch.view.MovieSearchViewModel.MessageSet> _toastMsg = null;
    
    public MovieSearchViewModel(@org.jetbrains.annotations.NotNull()
    com.example.domain.usecase.movie.GetMoviesUseCase getMoviesUseCase, @org.jetbrains.annotations.NotNull()
    com.example.domain.usecase.movie.GetPagingMoviesUseCase getPagingMoviesUseCase, @org.jetbrains.annotations.NotNull()
    com.example.domain.usecase.movie.GetLocalMoviesUseCase getLocalMoviesUseCase, @org.jetbrains.annotations.NotNull()
    com.example.core.base.util.NetworkManager networkManager, @org.jetbrains.annotations.NotNull()
    com.example.core.base.navi.Navigation navigation) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getQuery() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.domain.model.Movie>> getMovieList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.example.moviesearch.view.MovieSearchViewModel.MessageSet> getToastMsg() {
        return null;
    }
    
    public final void requestMovie() {
    }
    
    public final void requestPagingMovie(int offset) {
    }
    
    private final boolean checkNetworkState() {
        return false;
    }
    
    private final void requestLocalMovies() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/example/moviesearch/view/MovieSearchViewModel$MessageSet;", "", "(Ljava/lang/String;I)V", "LAST_PAGE", "EMPTY_QUERY", "NETWORK_NOT_CONNECTED", "ERROR", "SUCCESS", "NO_RESULT", "LOCAL_SUCCESS", "moviesearch_debug"})
    public static enum MessageSet {
        /*public static final*/ LAST_PAGE /* = new LAST_PAGE() */,
        /*public static final*/ EMPTY_QUERY /* = new EMPTY_QUERY() */,
        /*public static final*/ NETWORK_NOT_CONNECTED /* = new NETWORK_NOT_CONNECTED() */,
        /*public static final*/ ERROR /* = new ERROR() */,
        /*public static final*/ SUCCESS /* = new SUCCESS() */,
        /*public static final*/ NO_RESULT /* = new NO_RESULT() */,
        /*public static final*/ LOCAL_SUCCESS /* = new LOCAL_SUCCESS() */;
        
        MessageSet() {
        }
    }
}