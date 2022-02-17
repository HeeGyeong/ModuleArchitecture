package com.example.core.base;

import java.lang.System;

/**
 * Application class.
 * Koin 과 DataStore 를 Setting 해주고 있다.
 *
 * 해당 class 는 Manifest 에 선언하여 사용하기 때문에 별다른 호출부는 존재하지 않는다.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/example/core/base/BaseApplication;", "Landroid/app/Application;", "()V", "dataStore", "Lcom/example/core/base/util/DataStore;", "getDataStore", "onCreate", "", "Companion", "core_debug"})
public final class BaseApplication extends android.app.Application {
    private com.example.core.base.util.DataStore dataStore;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.core.base.BaseApplication.Companion Companion = null;
    private static com.example.core.base.BaseApplication application;
    
    public BaseApplication() {
        super();
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.core.base.util.DataStore getDataStore() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/example/core/base/BaseApplication$Companion;", "", "()V", "application", "Lcom/example/core/base/BaseApplication;", "getInstance", "core_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.core.base.BaseApplication getInstance() {
            return null;
        }
    }
}