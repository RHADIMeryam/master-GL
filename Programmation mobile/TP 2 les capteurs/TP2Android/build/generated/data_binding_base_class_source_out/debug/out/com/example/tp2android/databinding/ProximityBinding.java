// Generated by view binder compiler. Do not edit!
package com.example.tp2android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.tp2android.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ProximityBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final ImageView away;

  @NonNull
  public final TextView etat;

  @NonNull
  public final ImageView near;

  private ProximityBinding(@NonNull RelativeLayout rootView, @NonNull ImageView away,
      @NonNull TextView etat, @NonNull ImageView near) {
    this.rootView = rootView;
    this.away = away;
    this.etat = etat;
    this.near = near;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ProximityBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ProximityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.proximity, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ProximityBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.away;
      ImageView away = ViewBindings.findChildViewById(rootView, id);
      if (away == null) {
        break missingId;
      }

      id = R.id.etat;
      TextView etat = ViewBindings.findChildViewById(rootView, id);
      if (etat == null) {
        break missingId;
      }

      id = R.id.near;
      ImageView near = ViewBindings.findChildViewById(rootView, id);
      if (near == null) {
        break missingId;
      }

      return new ProximityBinding((RelativeLayout) rootView, away, etat, near);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}