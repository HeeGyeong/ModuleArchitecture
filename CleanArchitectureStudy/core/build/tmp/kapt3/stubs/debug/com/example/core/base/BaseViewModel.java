package com.example.core.base;

import java.lang.System;

/**
 * BaseViewModel
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\n\b&\u0018\u00002\u00020\u0001:\u0001!B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J.\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u0011\u0010\u0019\u001a\u00020\u0016H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001aJ\u0006\u0010\u001b\u001a\u00020\u0016J\u0006\u0010\u001c\u001a\u00020\u0010J\b\u0010\u001d\u001a\u00020\u0010H\u0014J\u000e\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u0016J\u0006\u0010 \u001a\u00020\u0010R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\r8F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\""}, d2 = {"Lcom/example/core/base/BaseViewModel;", "Landroidx/lifecycle/ViewModel;", "navigation", "Lcom/example/core/base/navi/Navigation;", "(Lcom/example/core/base/navi/Navigation;)V", "_isLoading", "Landroidx/lifecycle/MutableLiveData;", "", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "getCompositeDisposable", "()Lio/reactivex/disposables/CompositeDisposable;", "isLoading", "Landroidx/lifecycle/LiveData;", "()Landroidx/lifecycle/LiveData;", "changeToActivity", "", "context", "Landroid/content/Context;", "action", "Lcom/example/core/base/BaseViewModel$ActivityAction;", "fromActivity", "", "data", "", "getDataStore", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDataStore2", "hideProgress", "onCleared", "setDataStore", "text", "showProgress", "ActivityAction", "core_debug"})
public abstract class BaseViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.core.base.navi.Navigation navigation = null;
    @org.jetbrains.annotations.NotNull()
    private final io.reactivex.disposables.CompositeDisposable compositeDisposable = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _isLoading = null;
    
    public BaseViewModel(@org.jetbrains.annotations.NotNull()
    com.example.core.base.navi.Navigation navigation) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final io.reactivex.disposables.CompositeDisposable getCompositeDisposable() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isLoading() {
        return null;
    }
    
    public final void showProgress() {
    }
    
    public final void hideProgress() {
    }
    
    public final void changeToActivity(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    com.example.core.base.BaseViewModel.ActivityAction action, @org.jetbrains.annotations.Nullable()
    java.lang.String fromActivity, @org.jetbrains.annotations.Nullable()
    java.lang.Object data) {
    }
    
    /**
     * DataStore 사용을 위한 get
     *
     * await() 를 사용하기 위하여 suspend 로 사용.
     * 동기화 된 상태로 해당 값을 가져오는 것이 아닌 비동기로 값을 사용한다면 await 를 사용하지 않아도 된다.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getDataStore(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDataStore2() {
        return null;
    }
    
    /**
     * DataStore 사용을 위한 set
     */
    public final void setDataStore(@org.jetbrains.annotations.NotNull()
    java.lang.String text) {
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/core/base/BaseViewModel$ActivityAction;", "", "(Ljava/lang/String;I)V", "MOVE", "BACK", "BUNDLE", "DATA", "core_debug"})
    public static enum ActivityAction {
        /*public static final*/ MOVE /* = new MOVE() */,
        /*public static final*/ BACK /* = new BACK() */,
        /*public static final*/ BUNDLE /* = new BUNDLE() */,
        /*public static final*/ DATA /* = new DATA() */;
        
        ActivityAction() {
        }
    }
}