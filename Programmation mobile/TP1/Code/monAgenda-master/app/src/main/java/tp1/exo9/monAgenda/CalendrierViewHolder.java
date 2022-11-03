package tp1.exo9.monAgenda;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalDate;
import java.util.ArrayList;

public class CalendrierViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{
    public final TextView jourDeSemaine;
    private final ArrayList<LocalDate> jours;
    public final View parentView;
    private final CalendrierAdaptateur.OnItemListener onItemListener;
    public CalendrierViewHolder(@NonNull View itemView, CalendrierAdaptateur.OnItemListener onItemListener,ArrayList<LocalDate> jours)
    {
        super(itemView);
        parentView = itemView.findViewById(R.id.parentView);
        jourDeSemaine = itemView.findViewById(R.id.jour);
        this.onItemListener = onItemListener;
        itemView.setOnClickListener(this);
        this.jours=jours;
    }

    @Override
    public void onClick(View view)
    {
        onItemListener.onItemClick(getAdapterPosition(), jours.get(getAdapterPosition()));
    }
}
