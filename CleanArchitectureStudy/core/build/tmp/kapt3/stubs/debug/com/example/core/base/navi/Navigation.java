package com.example.core.base.navi;

import java.lang.System;

/**
 * 화면 이동할 때 사용할 Navigation class
 * Interface 의 구현부를 호출하여 필요한 화면 이동을 실행시킨다.
 * 구현부는 Presentation Module 에 존재한다.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J/\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/example/core/base/navi/Navigation;", "", "naviInterface", "Lcom/example/core/base/navi/NavigationInterface;", "(Lcom/example/core/base/navi/NavigationInterface;)V", "invoke", "", "context", "Landroid/content/Context;", "action", "Lcom/example/core/base/BaseViewModel$ActivityAction;", "fromActivity", "", "data", "core_debug"})
public class Navigation {
    private final com.example.core.base.navi.NavigationInterface naviInterface = null;
    
    public Navigation(@org.jetbrains.annotations.NotNull()
    com.example.core.base.navi.NavigationInterface naviInterface) {
        super();
    }
    
    public final void invoke(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    com.example.core.base.BaseViewModel.ActivityAction action, @org.jetbrains.annotations.Nullable()
    java.lang.String fromActivity, @org.jetbrains.annotations.Nullable()
    java.lang.Object data) {
    }
}