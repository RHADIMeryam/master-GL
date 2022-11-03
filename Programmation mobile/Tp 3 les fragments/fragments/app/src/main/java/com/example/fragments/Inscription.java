package com.example.fragments;

import android.os.Bundle;
import androidx.fragment.app.*;
import android.view.*;
import android.widget.*;

public class Inscription extends Fragment {

    View view;
    EditText nom,prenom,email,tel,date;
    CheckBox music,lecture,sport;
    String lectureS=" Lecture pas couché",musicS=" Musique pas couché",sportS=" Sport pas couché";
    Bundle bundle = new Bundle();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.inscription, container, false);
        Button valider = view.findViewById(R.id.valider);
        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 nom = view.findViewById(R.id.nomI);
                 prenom = view.findViewById(R.id.prenomI);
                 email = view.findViewById(R.id.emailI);
                 tel = view.findViewById(R.id.telI);
                 date = view.findViewById(R.id.dateI);
                 lecture=view.findViewById(R.id.lecture);
                 music=view.findViewById(R.id.music);
                 sport=view.findViewById(R.id.sport);
                 if (lecture.isChecked()){
                     lectureS=" Lecture";
                 }
                if (music.isChecked()){
                    musicS=" Musique";
                }
                if (sport.isChecked()){
                    sportS=" Sport";
                }
                bundle.putString("nom",nom.getText().toString());
                bundle.putString("prenom",prenom.getText().toString());
                bundle.putString("email",email.getText().toString());
                bundle.putString("tel",tel.getText().toString());
                bundle.putString("date",date.getText().toString());
                bundle.putString("lecture",lectureS);
                bundle.putString("music",musicS);
                bundle.putString("sport",sportS);
                bundle.putString("data", " Nom: "+nom.getText().toString()
                                        +"\n Prenom: "+prenom.getText().toString()
                                        +"\n Date de naissance: "+date.getText().toString()
                                        +"\n Numero de telephone :"+tel.getText().toString()
                                        +"\n Email: "+email.getText().toString()
                                        +"\n Centre d'interet: \n "+lectureS
                                        +"\n "+ sportS
                                        +"\n "+musicS);
                getParentFragmentManager().setFragmentResult("dataEnvoyee", bundle);
                affichage();
            }
        });
        return view;

    }
    private void affichage() {
        Affichage affichage =new Affichage();
        FragmentManager fragmentManager = getParentFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.activity_main, affichage).commit();

    }
}