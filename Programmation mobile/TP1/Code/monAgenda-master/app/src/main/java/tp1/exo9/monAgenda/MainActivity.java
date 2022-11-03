package tp1.exo9.monAgenda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.time.LocalDate;

import java.util.ArrayList;
import static tp1.exo9.monAgenda.CalendrierUtil.*;

public class MainActivity extends AppCompatActivity implements CalendrierAdaptateur.OnItemListener
{
    private TextView mois;
    private RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initW();
        CalendrierUtil.dateSelectionner = LocalDate.now();
        setMois();
    }

    private void initW()
    {
        recycler = findViewById(R.id.recycler);
        mois = findViewById(R.id.mois);
    }

    private void setMois()
    {
        mois.setText(moisAnneeDeDate(CalendrierUtil.dateSelectionner));
        ArrayList<LocalDate> jourDansMois = jourDansMoisList(CalendrierUtil.dateSelectionner);

        CalendrierAdaptateur calendrierAdapteur = new CalendrierAdaptateur(jourDansMois, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 7);
        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(calendrierAdapteur);
    }



    public void moisPasser(View view)
    {
        CalendrierUtil.dateSelectionner = CalendrierUtil.dateSelectionner.minusMonths(1);
        setMois();
    }

    public void moisProchaine(View view)
    {
        CalendrierUtil.dateSelectionner = CalendrierUtil.dateSelectionner.plusMonths(1);
        setMois();
    }

    @Override
    public void onItemClick(int position, LocalDate date)
    {
        if(date != null)
        {
            CalendrierUtil.dateSelectionner = date;
            setMois();
        }
    }
    public void weeklyAction(View view)
    {
        startActivity(new Intent(this, CalendrierActivity.class));
    }
}








