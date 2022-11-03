package com.example.locationprojet;

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

import java.util.HashMap;

public class ListAnnonceUtilisateur extends Fragment{

        private static final String ARG_PARAM1 = "param1";
        private static final String ARG_PARAM2 = "param2";
        private String mParam1;
        private String mParam2;
        private RecyclerView recview;
        private MyAdapterUser adapter;


        public ListAnnonceUtilisateur(){}
        public static  ListAnnonceUtilisateur newInstance(String param1, String param2) {
            ListAnnonceUtilisateur fragment = new  ListAnnonceUtilisateur();
            Bundle args = new Bundle();
            args.putString(ARG_PARAM1, param1);
            args.putString(ARG_PARAM2, param2);

            fragment.setArguments(args);
            return fragment;

        }

        @Override
        public void onCreate(Bundle savedInstanceState) {

            setHasOptionsMenu(true);
            super.onCreate(savedInstanceState);
            if (getArguments() != null) {
                mParam1 = getArguments().getString(ARG_PARAM1);
                mParam2 = getArguments().getString(ARG_PARAM2);
            }

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view=inflater.inflate(R.layout.list_annonce_user, container, false);
            recview=(RecyclerView)view.findViewById(R.id.recviewUser);
            recview.setLayoutManager(new LinearLayoutManager(getContext()));
            SessionManager sessionManager= new SessionManager(this.getActivity());
            HashMap<String,String> userDetails= sessionManager.getUserDetailFromSession();
            String  usernameSaisson=userDetails.get(SessionManager.KEY_USERNAME);
            FirebaseRecyclerOptions<AnnonceModel> options =
                    new FirebaseRecyclerOptions.Builder<AnnonceModel>()
                            .setQuery(FirebaseDatabase.getInstance().getReference(usernameSaisson), AnnonceModel.class)
                            .build();
                adapter = new MyAdapterUser(options);
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

        SessionManager sessionManager= new SessionManager(this.getActivity());
        HashMap<String,String> userDetails= sessionManager.getUserDetailFromSession();
        String  usernameSaisson=userDetails.get(SessionManager.KEY_USERNAME);
        FirebaseRecyclerOptions<AnnonceModel> options =
                new FirebaseRecyclerOptions.Builder<AnnonceModel>()
                        .setQuery(FirebaseDatabase.getInstance()
                                .getReference(usernameSaisson).orderByChild("nomVoiture")
                                .startAt(mot).endAt(mot+"~"), AnnonceModel.class)
                        .build();
        adapter=new MyAdapterUser(options);
        adapter.startListening();
        recview.setAdapter(adapter);
    }
}
