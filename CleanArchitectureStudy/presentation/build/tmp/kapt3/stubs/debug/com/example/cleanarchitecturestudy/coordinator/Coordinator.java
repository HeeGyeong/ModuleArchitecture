package com.example.cleanarchitecturestudy.coordinator;

import java.lang.System;

/**
 * 외부 Module 을 호출하여 Activity 이동을 하기 위한 Coordinator.
 *
 * 각 화면을 Module 로 나눠두었기 때문에, Activity 의 이동을 Coordinator Pattern 을 사용하여 구현해보았다.
 * Main 의 경우 같은 Module 이기 때문에 그대로 StartActivity 를 호출하였고,
 * 다른 케이스의 경우 외두 Module 이기 때문에 해당 Module 을 사용할 수 있는 Initializer 를 통해 접근 하도록 하였다.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/example/cleanarchitecturestudy/coordinator/Coordinator;", "Lcom/example/core/base/navi/NavigationInterface;", "()V", "changeActivity", "", "context", "Landroid/content/Context;", "fromActivity", "", "presentation_debug"})
public final class Coordinator implements com.example.core.base.navi.NavigationInterface {
    
    public Coordinator() {
        super();
    }
    
    @java.lang.Override()
    public void changeActivity(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    java.lang.String fromActivity) {
    }
}