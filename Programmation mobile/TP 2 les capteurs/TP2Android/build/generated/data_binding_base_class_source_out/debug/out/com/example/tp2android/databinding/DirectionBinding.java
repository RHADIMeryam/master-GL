// Generated by view binder compiler. Do not edit!
package com.example.tp2android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.tp2android.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class DirectionBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView direction;

  @NonNull
  public final TextView directionR;

  private DirectionBinding(@NonNull ConstraintLayout rootView, @NonNull TextView direction,
      @NonNull TextView directionR) {
    this.rootView = rootView;
    this.direction = direction;
    this.directionR = directionR;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static DirectionBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static DirectionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.direction, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static DirectionBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.direction;
      TextView direction = ViewBindings.findChildViewById(rootView, id);
      if (direction == null) {
        break missingId;
      }

      id = R.id.directionR;
      TextView directionR = ViewBindings.findChildViewById(rootView, id);
      if (directionR == null) {
        break missingId;
      }

      return new DirectionBinding((ConstraintLayout) rootView, direction, directionR);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}