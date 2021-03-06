package com.example.core.base.util;

import java.lang.System;

/**
 * DataStore Class.
 *
 * Preference 가 deprecated 되면서 DataStore 를 사용 하도록 권장하고 있음.
 * 따라서, Preference 대신 사용하기 위해서 생성.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001aJ\u0019\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R%\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011*\u00020\u00038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/example/core/base/util/DataStore;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "dataStorePermission", "Lkotlinx/coroutines/flow/Flow;", "", "getDataStorePermission", "()Lkotlinx/coroutines/flow/Flow;", "dataStoreText", "", "getDataStoreText", "permissionKey", "Landroidx/datastore/preferences/core/Preferences$Key;", "stringKey", "dataStore", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "getDataStore", "(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", "dataStore$delegate", "Lkotlin/properties/ReadOnlyProperty;", "setDataStorePermission", "", "isCheck", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setDataStoreText", "text", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_debug"})
public final class DataStore {
    private final android.content.Context context = null;
    private final kotlin.properties.ReadOnlyProperty dataStore$delegate = null;
    private final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> stringKey = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.lang.String> dataStoreText = null;
    private final androidx.datastore.preferences.core.Preferences.Key<java.lang.Boolean> permissionKey = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.lang.Boolean> dataStorePermission = null;
    
    public DataStore(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    private final androidx.datastore.core.DataStore<androidx.datastore.preferences.core.Preferences> getDataStore(android.content.Context $this$dataStore) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.String> getDataStoreText() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object setDataStoreText(@org.jetbrains.annotations.NotNull()
    java.lang.String text, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.Boolean> getDataStorePermission() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object setDataStorePermission(boolean isCheck, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}