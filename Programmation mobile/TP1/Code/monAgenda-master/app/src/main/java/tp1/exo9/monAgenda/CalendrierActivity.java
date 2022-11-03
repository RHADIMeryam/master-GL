package tp1.exo9.monAgenda;

import static tp1.exo9.monAgenda.CalendrierUtil.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.time.LocalDate;
import java.util.ArrayList;

public class CalendrierActivity extends AppCompatActivity implements CalendrierAdaptateur.OnItemListener {

    private TextView mois;
    private RecyclerView recycler;
    private ListView evenementList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendrier);
        initWidgets();
        setSemaine();
    }

    private void initWidgets()
    {
        recycler = findViewById(R.id.recycler);
        mois = findViewById(R.id.mois);
        evenementList = findViewById(R.id.evenementList);
    }

    private void setSemaine()
    {
        mois.setText(moisAnneeDeDate(CalendrierUtil.dateSelectionner));
        ArrayList<LocalDate> jours = joursDansSemainList(CalendrierUtil.dateSelectionner);

        CalendrierAdaptateur calendarAdapter = new CalendrierAdaptateur(jours,this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 7);
        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(calendarAdapter);
        setAdaptateurDeEvenement();
    }


    public void semainePasser(View view)
    {
        CalendrierUtil.dateSelectionner = CalendrierUtil.dateSelectionner.minusWeeks(1);
        setSemaine();
    }

    public void semaineProchaine(View view)
    {
        CalendrierUtil.dateSelectionner = CalendrierUtil.dateSelectionner.plusWeeks(1);
        setSemaine();
    }

    @Override
    public void onItemClick(int position, LocalDate date)
    {
        CalendrierUtil.dateSelectionner = date;
        setSemaine();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        setAdaptateurDeEvenement();
    }

    private void setAdaptateurDeEvenement()
    {
        ArrayList<Evenement> evenemetsHebdo = Evenement.evenementDeDate(CalendrierUtil.dateSelectionner);
        EvenementAdaptateur evenementAdaptateur = new EvenementAdaptateur(getApplicationContext(), evenemetsHebdo);
        evenementList.setAdapter(evenementAdaptateur);
    }

    public void nouveauEven(View view)
    {
        startActivity(new Intent(this, EvenementActivity.class));
    }
}