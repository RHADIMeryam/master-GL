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

public final class SecouerBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView currx;

  @NonNull
  public final TextView curry;

  @NonNull
  public final TextView currz;

  @NonNull
  public final TextView flash;

  @NonNull
  public final TextView lastx;

  @NonNull
  public final TextView lasty;

  @NonNull
  public final TextView lastz;

  private SecouerBinding(@NonNull ConstraintLayout rootView, @NonNull TextView currx,
      @NonNull TextView curry, @NonNull TextView currz, @NonNull TextView flash,
      @NonNull TextView lastx, @NonNull TextView lasty, @NonNull TextView lastz) {
    this.rootView = rootView;
    this.currx = currx;
    this.curry = curry;
    this.currz = currz;
    this.flash = flash;
    this.lastx = lastx;
    this.lasty = lasty;
    this.lastz = lastz;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static SecouerBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static SecouerBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent,
      boolean attachToParent) {
    View root = inflater.inflate(R.layout.secouer, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static SecouerBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.currx;
      TextView currx = ViewBindings.findChildViewById(rootView, id);
      if (currx == null) {
        break missingId;
      }

      id = R.id.curry;
      TextView curry = ViewBindings.findChildViewById(rootView, id);
      if (curry == null) {
        break missingId;
      }

      id = R.id.currz;
      TextView currz = ViewBindings.findChildViewById(rootView, id);
      if (currz == null) {
        break missingId;
      }

      id = R.id.flash;
      TextView flash = ViewBindings.findChildViewById(rootView, id);
      if (flash == null) {
        break missingId;
      }

      id = R.id.lastx;
      TextView lastx = ViewBindings.findChildViewById(rootView, id);
      if (lastx == null) {
        break missingId;
      }

      id = R.id.lasty;
      TextView lasty = ViewBindings.findChildViewById(rootView, id);
      if (lasty == null) {
        break missingId;
      }

      id = R.id.lastz;
      TextView lastz = ViewBindings.findChildViewById(rootView, id);
      if (lastz == null) {
        break missingId;
      }

      return new SecouerBinding((ConstraintLayout) rootView, currx, curry, currz, flash, lastx,
          lasty, lastz);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
