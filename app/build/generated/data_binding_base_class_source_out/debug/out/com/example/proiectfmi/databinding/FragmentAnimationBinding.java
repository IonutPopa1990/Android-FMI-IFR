// Generated by view binder compiler. Do not edit!
package com.example.proiectfmi.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.viewbinding.ViewBinding;
import com.example.proiectfmi.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentAnimationBinding implements ViewBinding {
  @NonNull
  private final MotionLayout rootView;

  @NonNull
  public final Button btnMotionLayoutAnimator;

  @NonNull
  public final Button btnObjectAnimator;

  @NonNull
  public final View redView;

  private FragmentAnimationBinding(@NonNull MotionLayout rootView,
      @NonNull Button btnMotionLayoutAnimator, @NonNull Button btnObjectAnimator,
      @NonNull View redView) {
    this.rootView = rootView;
    this.btnMotionLayoutAnimator = btnMotionLayoutAnimator;
    this.btnObjectAnimator = btnObjectAnimator;
    this.redView = redView;
  }

  @Override
  @NonNull
  public MotionLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentAnimationBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentAnimationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_animation, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentAnimationBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_motion_layout_animator;
      Button btnMotionLayoutAnimator = rootView.findViewById(id);
      if (btnMotionLayoutAnimator == null) {
        break missingId;
      }

      id = R.id.btn_object_animator;
      Button btnObjectAnimator = rootView.findViewById(id);
      if (btnObjectAnimator == null) {
        break missingId;
      }

      id = R.id.redView;
      View redView = rootView.findViewById(id);
      if (redView == null) {
        break missingId;
      }

      return new FragmentAnimationBinding((MotionLayout) rootView, btnMotionLayoutAnimator,
          btnObjectAnimator, redView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
