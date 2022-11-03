package tp1.exo9.monAgenda;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalDate;
import java.util.ArrayList;

class CalendrierAdaptateur extends RecyclerView.Adapter<CalendrierViewHolder>
{
    private final ArrayList<LocalDate> jours;
    private final OnItemListener onItemListener;

    public CalendrierAdaptateur(ArrayList<LocalDate> jours, OnItemListener onItemListener)
    {
        this.jours = jours;
        this.onItemListener = onItemListener;
    }

    @NonNull
    @Override
    public CalendrierViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.calendrier, parent, false);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if(jours.size() > 15)
            layoutParams.height = (int) (parent.getHeight() * 0.166666666);
        else // week view
            layoutParams.height = (int) parent.getHeight();

        return new CalendrierViewHolder(view, onItemListener, jours);

    }

    @Override
    public void onBindViewHolder(@NonNull CalendrierViewHolder holder, int position)
    {
        final LocalDate date = jours.get(position);
        if(date == null)
            holder.jourDeSemaine.setText("");
        else
        {
            holder.jourDeSemaine.setText(String.valueOf(date.getDayOfMonth()));
            if(date.equals(CalendrierUtil.dateSelectionner))
                holder.parentView.setBackgroundColor(Color.LTGRAY);
        }    }

    @Override
    public int getItemCount()
    {
        return jours.size();
    }

    public interface  OnItemListener
    {
        void onItemClick(int position, LocalDate date);
    }
}
