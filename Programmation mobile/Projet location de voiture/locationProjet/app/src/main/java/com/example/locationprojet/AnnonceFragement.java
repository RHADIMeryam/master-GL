package com.example.locationprojet;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import androidx.annotation.NonNull;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.locationprojet.model.AnnonceModel;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class AnnonceFragement extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    private RecyclerView recview;
    private MyAdapter adapter;

    public AnnonceFragement(){}
    public static AnnonceFragement newInstance(String param1, String param2) {
        AnnonceFragement fragment = new AnnonceFragement();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.liste_fragment, container, false);

        recview=(RecyclerView)view.findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(getContext()));
        FirebaseRecyclerOptions<AnnonceModel> options =
                new FirebaseRecyclerOptions.Builder<AnnonceModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference("Annonce"), AnnonceModel.class)
                        .build();
        adapter=new MyAdapter(options);
        recview.setAdapter(adapter);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }
    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {

        inflater.inflate(R.menu.menu_item, menu);
        MenuItem menuItem=menu.findItem(R.id.searchId);
        MenuItem logout=menu.findItem(R.id.logout);
        logout.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent plus = new Intent(getActivity(), Connexion.class);
                startActivity(plus);
                return true;
            }
        });
        SearchView searchview=(SearchView) MenuItemCompat.getActionView(menuItem);
        searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                rechercher(s);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                rechercher(s);
                return true;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }
    public void rechercher(String mot){
        FirebaseRecyclerOptions<AnnonceModel> options =
                new FirebaseRecyclerOptions.Builder<AnnonceModel>()
                        .setQuery(FirebaseDatabase.getInstance()
                                .getReference("Annonce").orderByChild("nomVoiture")
                                .startAt(mot).endAt(mot+"~"), AnnonceModel.class)
                        .build();
        adapter=new MyAdapter(options);
        adapter.startListening();
        recview.setAdapter(adapter);
    }


}