package com.example.core.base.navi;

import java.lang.System;

/**
 * 화면 이동에 사용하는 Interface
 *
 * 추후, 화면 이동에 필요한 데이터를 넘겨야 하는 경우 등
 * 매개 변수가 달라지면 이곳에서 추가해야 하는지 여부 판단을 해야한다.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001H&\u00a8\u0006\t"}, d2 = {"Lcom/example/core/base/navi/NavigationInterface;", "", "changeActivity", "", "context", "Landroid/content/Context;", "fromActivity", "", "data", "core_debug"})
public abstract interface NavigationInterface {
    
    public abstract void changeActivity(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    java.lang.String fromActivity, @org.jetbrains.annotations.Nullable()
    java.lang.Object data);
}