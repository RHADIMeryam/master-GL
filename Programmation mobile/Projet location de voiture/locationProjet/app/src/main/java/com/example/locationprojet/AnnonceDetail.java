package com.example.locationprojet;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import com.bumptech.glide.Glide;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AnnonceDetail extends Fragment {

    private DatabaseReference reference;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1,mParam2;
    private String image, nomVoiture,prix,description,addresse, telephone,modele;
    private TextInputLayout prixHolder,nameHolder,numeroHolder,modeleHolder,descriptionHolder,addreHolder;
    private ImageView imageHolder;
    private Button buttonAppel;

    public AnnonceDetail(){}
    public AnnonceDetail(String image, String nomVoiture, String prix, String description, String addresse, String telephone, String modele) {
        this.image = image;
        this.nomVoiture = nomVoiture;
        this.prix = prix;
        this.description = description;
        this.addresse = addresse;
        this.telephone = telephone;
        this.modele = modele;
    }
    public static AnnonceDetail newInstance(String param1, String param2) {
        AnnonceDetail fragment = new AnnonceDetail();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       reference=FirebaseDatabase.getInstance().getReference("Annonce");

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.detail_voiture, container, false);
        imageHolder=view.findViewById(R.id.imgHolder);
        nameHolder=view.findViewById(R.id.nomHolder);
        modeleHolder=view.findViewById(R.id.modeleHolder);
        descriptionHolder=view.findViewById(R.id.desciptionHolder);
        addreHolder=view.findViewById(R.id.addrHolder);
        numeroHolder=view.findViewById(R.id.numeroHolder);
        prixHolder=view.findViewById(R.id.prixHolder);

        nameHolder.getEditText().setText(nomVoiture);
        modeleHolder.getEditText().setText(modele);
        descriptionHolder.getEditText().setText(description);
        addreHolder.getEditText().setText(addresse);
        numeroHolder.getEditText().setText(telephone);
        prixHolder.getEditText().setText(prix);
        Glide.with(getContext()).load(image).into(imageHolder);
        buttonAppel=view.findViewById(R.id.appel);
        String telAppel=numeroHolder.getEditText().getText().toString();

        buttonAppel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                callIntent.setData(Uri.parse("tel:" + telAppel));
                getActivity().startActivity(callIntent);
            }
        });

        return  view;
    }

    }