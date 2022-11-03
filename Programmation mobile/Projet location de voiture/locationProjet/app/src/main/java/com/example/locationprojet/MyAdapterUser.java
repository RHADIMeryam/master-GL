package com.example.locationprojet;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.locationprojet.model.AnnonceModel;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class MyAdapterUser extends FirebaseRecyclerAdapter<AnnonceModel,MyAdapterUser.myviewholder> {

    public MyAdapterUser(@NonNull FirebaseRecyclerOptions<AnnonceModel> options) {

        super(options);
    }
    @Override
    protected void onBindViewHolder(@NonNull MyAdapterUser.myviewholder holder, int position, @NonNull AnnonceModel annonceModel) {
        holder.nomVoiture.setText(annonceModel.getNomVoiture());
        holder.description.setText(annonceModel.getDescription());
        Glide.with(holder.img.getContext())
                .load(annonceModel.getImage())
                .error(R.drawable.plus)
                .into(holder.img);


        holder.prix.setText(annonceModel.getPrix());
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity=(AppCompatActivity)view.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.wrapperUser,new ListAnnonceDetailFragement(annonceModel.getImage(), annonceModel.getNomVoiture(), annonceModel.getPrix(), annonceModel.getDescription(), annonceModel.getAddr(), annonceModel.getTelephone(), annonceModel.getModele())).addToBackStack(null).commit();
            }
        });

    }

    @NonNull
    @Override
    public MyAdapterUser.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout,parent,false);
        return new MyAdapterUser.myviewholder(view);
    }


    public class myviewholder extends RecyclerView.ViewHolder
    {

        ImageView img;
        TextView nomVoiture,description,prix;
        public myviewholder(@NonNull View itemView){
            super(itemView);
            nomVoiture =(TextView)itemView.findViewById(R.id.titreV);
            description=(TextView)itemView.findViewById(R.id.descriptionV);
            img=(ImageView) itemView.findViewById(R.id.imageV);
            prix=(TextView)itemView.findViewById(R.id.prixV);

        }
    }
}
