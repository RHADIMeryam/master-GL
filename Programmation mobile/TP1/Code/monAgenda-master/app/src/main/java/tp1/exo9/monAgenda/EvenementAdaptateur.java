package tp1.exo9.monAgenda;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class EvenementAdaptateur extends ArrayAdapter<Evenement> {
    public EvenementAdaptateur(@NonNull Context context, List<Evenement> events) {
        super(context, 0,events);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        Evenement evenement = getItem(position);

        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.evenement, parent, false);

        TextView eventXml = convertView.findViewById(R.id.evenement);

        String nomEvent = evenement.getNom() +" "+ CalendrierUtil.tempsFormatter(evenement.getTemps());
        eventXml.setText(nomEvent);
        return convertView;
    }


}
