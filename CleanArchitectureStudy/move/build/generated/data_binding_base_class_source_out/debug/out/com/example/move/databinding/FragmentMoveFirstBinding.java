// Generated by data binding compiler. Do not edit!
package com.example.move.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.example.move.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentMoveFirstBinding extends ViewDataBinding {
  @NonNull
  public final ConstraintLayout frameLayout;

  @NonNull
  public final Button secondBtn;

  @NonNull
  public final Button thirdBtn;

  protected FragmentMoveFirstBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ConstraintLayout frameLayout, Button secondBtn, Button thirdBtn) {
    super(_bindingComponent, _root, _localFieldCount);
    this.frameLayout = frameLayout;
    this.secondBtn = secondBtn;
    this.thirdBtn = thirdBtn;
  }

  @NonNull
  public static FragmentMoveFirstBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_move_first, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentMoveFirstBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentMoveFirstBinding>inflateInternal(inflater, R.layout.fragment_move_first, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentMoveFirstBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_move_first, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentMoveFirstBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentMoveFirstBinding>inflateInternal(inflater, R.layout.fragment_move_first, null, false, component);
  }

  public static FragmentMoveFirstBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static FragmentMoveFirstBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentMoveFirstBinding)bind(component, view, R.layout.fragment_move_first);
  }
}
