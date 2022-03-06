package com.example.cleanarchitecturestudy.view;

import java.lang.System;

/**
 * MainActivity.
 *
 * 해당 프로젝트에서는 사실 필요성이 없지만, 테스트를 위해 이것 저것 추가해보기 위해 만들어 두었음.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\b\u0010\u0011\u001a\u00020\u000bH\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/example/cleanarchitecturestudy/view/MainActivity;", "Lcom/example/core/base/BaseActivity;", "Lcom/example/cleanarchitecturestudy/databinding/ActivityMainBinding;", "()V", "viewModel", "Lcom/example/cleanarchitecturestudy/view/MainViewModel;", "getViewModel", "()Lcom/example/cleanarchitecturestudy/view/MainViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "btnClick", "", "view", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "permissionCheck", "presentation_debug"})
public final class MainActivity extends com.example.core.base.BaseActivity<com.example.cleanarchitecturestudy.databinding.ActivityMainBinding> {
    private final kotlin.Lazy viewModel$delegate = null;
    
    public MainActivity() {
        super(0);
    }
    
    private final com.example.cleanarchitecturestudy.view.MainViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void btnClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    /**
     * TedPermission Library 사용을 해보기 위해 추가.
     */
    private final void permissionCheck() {
    }
}