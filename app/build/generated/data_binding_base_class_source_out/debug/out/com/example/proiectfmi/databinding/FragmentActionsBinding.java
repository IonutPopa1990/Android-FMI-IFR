// Generated by view binder compiler. Do not edit!
package com.example.proiectfmi.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.example.proiectfmi.R;
import com.facebook.login.widget.LoginButton;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentActionsBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btnExplicit;

  @NonNull
  public final Button btnImplicit;

  @NonNull
  public final LoginButton loginButton;

  @NonNull
  public final TextView textActions;

  private FragmentActionsBinding(@NonNull ConstraintLayout rootView, @NonNull Button btnExplicit,
      @NonNull Button btnImplicit, @NonNull LoginButton loginButton,
      @NonNull TextView textActions) {
    this.rootView = rootView;
    this.btnExplicit = btnExplicit;
    this.btnImplicit = btnImplicit;
    this.loginButton = loginButton;
    this.textActions = textActions;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentActionsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentActionsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_actions, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentActionsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_explicit;
      Button btnExplicit = rootView.findViewById(id);
      if (btnExplicit == null) {
        break missingId;
      }

      id = R.id.btn_implicit;
      Button btnImplicit = rootView.findViewById(id);
      if (btnImplicit == null) {
        break missingId;
      }

      id = R.id.login_button;
      LoginButton loginButton = rootView.findViewById(id);
      if (loginButton == null) {
        break missingId;
      }

      id = R.id.text_actions;
      TextView textActions = rootView.findViewById(id);
      if (textActions == null) {
        break missingId;
      }

      return new FragmentActionsBinding((ConstraintLayout) rootView, btnExplicit, btnImplicit,
          loginButton, textActions);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
