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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class ListAnnonceDetailFragement extends Fragment {

    private DatabaseReference reference,general;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1, mParam2;
    private String image, nomVoiture, prix, description, addresse, telephone, modele;
    private TextInputLayout prixHolder, nameHolder, numeroHolder, modeleHolder, descriptionHolder, addreHolder;
    private ImageView imageHolder;
    private Button supprimer, buttonAppel, update;
    // AlertDialog alert=dialogBuilder.create();

    public ListAnnonceDetailFragement() {
    }

    public ListAnnonceDetailFragement(String image, String nomVoiture, String prix, String description, String addresse, String telephone, String modele) {
        this.image = image;
        this.nomVoiture = nomVoiture;
        this.prix = prix;
        this.description = description;
        this.addresse = addresse;
        this.telephone = telephone;
        this.modele = modele;
    }
    public static ListAnnonceDetailFragement newInstance(String param1, String param2) {
        ListAnnonceDetailFragement fragment = new ListAnnonceDetailFragement();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SessionManager sessionManager= new SessionManager(this.getActivity());
        HashMap<String,String> userDetails= sessionManager.getUserDetailFromSession();
        String  usernameSaisson=userDetails.get(SessionManager.KEY_USERNAME);
        reference = FirebaseDatabase.getInstance().getReference(usernameSaisson);
        general= FirebaseDatabase.getInstance().getReference("Annonce");
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.detail_voiture_user, container, false);
        imageHolder = view.findViewById(R.id.imgHolder);
        nameHolder = view.findViewById(R.id.nomHolder);
        modeleHolder = view.findViewById(R.id.modeleHolder);
        descriptionHolder = view.findViewById(R.id.desciptionHolder);
        addreHolder = view.findViewById(R.id.addrHolder);
        numeroHolder = view.findViewById(R.id.numeroHolder);
        prixHolder = view.findViewById(R.id.prixHolder);
        supprimer = view.findViewById(R.id.supprimer);
        nameHolder.getEditText().setText(nomVoiture);
        modeleHolder.getEditText().setText(modele);
        descriptionHolder.getEditText().setText(description);
        addreHolder.getEditText().setText(addresse);
        numeroHolder.getEditText().setText(telephone);
        prixHolder.getEditText().setText(prix);
        Glide.with(getContext()).load(image).into(imageHolder);
        buttonAppel = view.findViewById(R.id.appel);
        String telAppel = numeroHolder.getEditText().getText().toString();
        update = view.findViewById(R.id.update);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update(view);

            }
        });
        supprimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteAnnonce(nomVoiture);
            }
        });
        buttonAppel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                callIntent.setData(Uri.parse("tel:" + telAppel));
                getActivity().startActivity(callIntent);
            }
        });

        return view;
    }

    private void deleteAnnonce(String nomVoiture) {

       reference.child(nomVoiture).removeValue();
       general.child(nomVoiture).removeValue();
        Toast.makeText(getActivity(), "Annonce supprimé !", Toast.LENGTH_LONG).show();

    }

    public void update(View view) {
        if (isAddChanged() || isModeleChanged() || isDescriptionChanged() || isPrixChanged() || isTelChanged()) {
            Toast.makeText(getActivity(), "Data est changer", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getActivity(), "Data n'est pas charger ", Toast.LENGTH_LONG).show();

        }
    }

    private boolean isTelChanged() {
        if (!telephone.equals(numeroHolder.getEditText().getText().toString())) {
            reference.child(nomVoiture).child("telephone").setValue(numeroHolder.getEditText().getText().toString());
            general.child(nomVoiture).child("telephone").setValue(numeroHolder.getEditText().getText().toString());
            telephone = numeroHolder.getEditText().toString();
            return true;
        } else {
            return false;
        }
    }

    private boolean isPrixChanged() {
        if (!prix.equals(prixHolder.getEditText().getText().toString())) {
            reference.child(nomVoiture).child("prix").setValue(prixHolder.getEditText().getText().toString());
            general.child(nomVoiture).child("prix").setValue(prixHolder.getEditText().getText().toString());

            prix = prixHolder.getEditText().toString();
            return true;
        } else {
            return false;
        }
    }

    private boolean isAddChanged() {
        if (!addresse.equals(addreHolder.getEditText().getText().toString())) {
            reference.child(nomVoiture).child("addr").setValue(addreHolder.getEditText().getText().toString());
            general.child(nomVoiture).child("addr").setValue(addreHolder.getEditText().getText().toString());
            addresse = addreHolder.getEditText().toString();
            return true;
        } else {
            return false;
        }
    }

    private boolean isModeleChanged() {

        if (!modele.equals(modeleHolder.getEditText().getText().toString())) {
            reference.child(nomVoiture).child("modele").setValue(modeleHolder.getEditText().getText().toString());
            general.child(nomVoiture).child("modele").setValue(modeleHolder.getEditText().getText().toString());
            modele = modeleHolder.getEditText().toString();
            return true;
        } else {
            return false;
        }
    }

    private boolean isDescriptionChanged() {
        if (!description.equals(descriptionHolder.getEditText().getText().toString())) {
            reference.child(nomVoiture).child("description").setValue(descriptionHolder.getEditText().getText().toString());
            general.child(nomVoiture).child("description").setValue(descriptionHolder.getEditText().getText().toString());
            description = descriptionHolder.getEditText().toString();
            return true;
        } else {
            return false;
        }
    }
}