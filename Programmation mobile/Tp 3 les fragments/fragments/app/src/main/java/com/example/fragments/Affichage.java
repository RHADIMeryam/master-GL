package com.example.fragments;


import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.*;
import android.util.Log;
import android.view.*;
import android.widget.*;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.*;

public class Affichage extends Fragment {

    View view;
    Button telecharger;
    String data, nom, prenom, email, tel, date, lecture, music, sport;
    TextView donner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.affichage, container, false);
        telecharger = view.findViewById(R.id.telecharger);
        getParentFragmentManager().setFragmentResultListener("dataEnvoyee", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                 data = result.getString("data");
                 nom =result.getString("nom");
                 prenom =result.getString("prenom");
                 email =result.getString("email");
                 tel =result.getString("tel");
                 date =result.getString("date");
                 music =result.getString("music");
                 lecture =result.getString("lecture");
                 sport =result.getString("sport");
                 donner = view.findViewById(R.id.donnesRecuperer);
                 donner.setText(data);
                 telecharger.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            downloadToJson();
                        } catch (IOException | JSONException e) {
                          e.printStackTrace();
                        }
                    }
                });
            }
        });
        return view;
    }
    public void downloadToJson() throws JSONException, IOException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Nom", nom);
        jsonObject.put("Prenom", prenom);
        jsonObject.put("Email", email);
        jsonObject.put("Numero de telephone", tel);
        jsonObject.put("Date de naissance", date);
        jsonObject.put("Centre d'interet", lecture);
        jsonObject.put("Centre d'interet", sport);
        jsonObject.put("Centre d'interet", music);
        String json = jsonObject.toString();
        File fichier = new File(getActivity().getFilesDir(),"FILE_NAME");
        FileWriter fileWriter = new FileWriter(fichier);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(json);
        bufferedWriter.close();
    }

}