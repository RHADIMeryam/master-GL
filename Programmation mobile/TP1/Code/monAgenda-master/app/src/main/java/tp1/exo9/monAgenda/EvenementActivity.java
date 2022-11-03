package tp1.exo9.monAgenda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.time.LocalTime;

public class EvenementActivity extends AppCompatActivity {

    private EditText nom;
    private TextView date, temps;

    private LocalTime tempsLocal;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evenement);
        initWidgets();
        tempsLocal = LocalTime.now();
        date.setText("Date: " + CalendrierUtil.dateFormatter(CalendrierUtil.dateSelectionner));
        temps.setText("Temps: " + CalendrierUtil.tempsFormatter(tempsLocal));
    }

    private void initWidgets()
    {
        nom = findViewById(R.id.nom);
        date = findViewById(R.id.date);
        temps = findViewById(R.id.temps);
    }

    public void sauvegarderEvenement(View view)
    {
        String nomEven = nom.getText().toString();
        Evenement nouveauEven = new Evenement(nomEven, CalendrierUtil.dateSelectionner, tempsLocal);
        Evenement.listEvenement.add(nouveauEven);
        finish();
    }
}