package com.example.locationprojet;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.locationprojet.model.AnnonceModel;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Annonce extends AppCompatActivity {
    ImageView img;
    Button browse, ajouter,retour;
    Uri filepath;
    Bitmap bitmap;
    public List<AnnonceModel> annonces;
    private FirebaseDatabase fire,fireUser;
    private String usernameSaisson;
    private DatabaseReference referenceAnnonce,referenceAnnonceUser;
    private TextInputLayout descriptionTV, nomVoitureTV, prixVoitureTV,modeleTV,addrTV,teleTV,username;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.annonce);

        annonces= new ArrayList<AnnonceModel>();
        //recupuration de tous les champs
        descriptionTV = findViewById(R.id.description);
        nomVoitureTV = findViewById(R.id.nomVoiture);
        prixVoitureTV = findViewById(R.id.prixAnnonce);
        modeleTV = findViewById(R.id.detail);
        addrTV = findViewById(R.id.addAnnonce);
        teleTV = findViewById(R.id.telAnnonce);
        img = (ImageView) findViewById(R.id.imageView);
        ajouter = findViewById(R.id.ajouter);
        browse = findViewById(R.id.browse);
        retour=findViewById(R.id.retour);
        username=findViewById(R.id.usernameC);
        fire = FirebaseDatabase.getInstance();
        fireUser=FirebaseDatabase.getInstance();
        annonces = new ArrayList<>();
        referenceAnnonce = fire.getReference("Annonce");
        SessionManager sessionManager= new SessionManager(this);
        HashMap<String,String> userDetails= sessionManager.getUserDetailFromSession();
         usernameSaisson=userDetails.get(SessionManager.KEY_USERNAME);
        System.out.println(usernameSaisson);
        referenceAnnonceUser=fireUser.getReference(usernameSaisson);

        ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ajouterFireBase();
            }
        });
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Annonce.this, Home.class);
                startActivity(intent);
            }
        });

        browse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Dexter.withActivity(Annonce.this)
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse response)
                            {
                                Intent intent=new Intent(Intent.ACTION_PICK);
                                intent.setType("image/*");
                                startActivityForResult(Intent.createChooser(intent,"Choisir une image"),1);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse response) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                                token.continuePermissionRequest();
                            }
                        }).check();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        if(requestCode==1  && resultCode==RESULT_OK)
        {
            filepath=data.getData();
            try{
                InputStream inputStream=getContentResolver().openInputStream(filepath);
                bitmap= BitmapFactory.decodeStream(inputStream);
                img.setImageBitmap(bitmap);
            }catch (Exception ex)
            {

            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


    public void ajouterFireBase() {
        ProgressDialog dialog=new ProgressDialog(this);
        dialog.setTitle("Image entrain d'etre ajoutée");
        dialog.show();
        FirebaseStorage storage=FirebaseStorage.getInstance();
        StorageReference uploader=storage.getReference("Image1"+new Random().nextInt(50));
        uploader.putFile(filepath)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot)
                    {
                        uploader.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri){

                                dialog.dismiss();
                                String nomvoiture= nomVoitureTV.getEditText().getText().toString();
                                String description=descriptionTV.getEditText().getText().toString();
                                String  prix=prixVoitureTV.getEditText().getText().toString();
                                String modele=modeleTV.getEditText().getText().toString();
                                String addr=addrTV.getEditText().getText().toString();
                                String telephone=teleTV.getEditText().getText().toString();
                                String image=filepath.toString();
                                //it will create a unique id and we will use it as the Primary Key for our Artist
                                String id = referenceAnnonce.push().getKey();
                                AnnonceModel annonceModel = new AnnonceModel(id,image,nomvoiture,modele,prix,description,addr,telephone);
                                referenceAnnonce.child(nomvoiture).setValue(annonceModel);
                                referenceAnnonceUser.child(nomvoiture).setValue(annonceModel);
                                annonces.add(annonceModel);
                                //vider les casses après remplissage
                                img.setImageResource(R.drawable.ic_launcher_background);
                                nomVoitureTV.getEditText().setText("");
                                descriptionTV.getEditText().setText("");
                                prixVoitureTV.getEditText().setText("");
                                modeleTV.getEditText().setText("");
                                addrTV.getEditText().setText("");
                                teleTV.getEditText().setText("");
                                Toast.makeText(getApplicationContext(),"Annonce ajoutée",Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(Annonce.this, Home.class);
                                startActivity(intent);

                            }
                        });
                    }
                })
                .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onProgress(UploadTask.TaskSnapshot taskSnapshot)
                    {
                        float percent=(100*taskSnapshot.getBytesTransferred())/taskSnapshot.getTotalByteCount();
                        dialog.setMessage("Chargement :"+(int)percent+" %");
                    }
                });
    }

}
