package com.example.move;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.example.move.databinding.ActivityMoveBindingImpl;
import com.example.move.databinding.FragmentMoveFirstBindingImpl;
import com.example.move.databinding.FragmentMoveSecondBindingImpl;
import com.example.move.databinding.FragmentMoveThirdBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYMOVE = 1;

  private static final int LAYOUT_FRAGMENTMOVEFIRST = 2;

  private static final int LAYOUT_FRAGMENTMOVESECOND = 3;

  private static final int LAYOUT_FRAGMENTMOVETHIRD = 4;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(4);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.move.R.layout.activity_move, LAYOUT_ACTIVITYMOVE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.move.R.layout.fragment_move_first, LAYOUT_FRAGMENTMOVEFIRST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.move.R.layout.fragment_move_second, LAYOUT_FRAGMENTMOVESECOND);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.move.R.layout.fragment_move_third, LAYOUT_FRAGMENTMOVETHIRD);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYMOVE: {
          if ("layout/activity_move_0".equals(tag)) {
            return new ActivityMoveBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_move is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTMOVEFIRST: {
          if ("layout/fragment_move_first_0".equals(tag)) {
            return new FragmentMoveFirstBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_move_first is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTMOVESECOND: {
          if ("layout/fragment_move_second_0".equals(tag)) {
            return new FragmentMoveSecondBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_move_second is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTMOVETHIRD: {
          if ("layout/fragment_move_third_0".equals(tag)) {
            return new FragmentMoveThirdBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_move_third is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(2);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    result.add(new com.example.core.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(1);

    static {
      sKeys.put(0, "_all");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(4);

    static {
      sKeys.put("layout/activity_move_0", com.example.move.R.layout.activity_move);
      sKeys.put("layout/fragment_move_first_0", com.example.move.R.layout.fragment_move_first);
      sKeys.put("layout/fragment_move_second_0", com.example.move.R.layout.fragment_move_second);
      sKeys.put("layout/fragment_move_third_0", com.example.move.R.layout.fragment_move_third);
    }
  }
}
