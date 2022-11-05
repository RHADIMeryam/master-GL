package fr.uavignon.ceri.tp3;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

import fr.uavignon.ceri.tp3.data.City;

public class MainActivity extends AppCompatActivity {
    private TextView temp;
    private City[] city ;
    ImageView imgIcone;
    TextView itemTmp;
    private ListViewModel list;
    ListViewModel viewmodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        temp=findViewById(R.id.item_temp);
       imgIcone =findViewById(R.id.item_image);
      viewmodel=new ViewModelProvider(this).get(ListViewModel.class);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
      int id = item.getItemId();
      /*  Button b1=findViewById(R.id.buttonUpdate);
        b1.setOnClickListener((View.OnClickListener)this);

        public void OnClick(View view){
         if(view.getId()==R.id.buttonUpdate){

         }
        }*/
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_update_all) {
           LiveData<List<City>> allCities = null;
           // if (city.getIconUri() != null)
               //imgIcone.setImageDrawable(getResources().getDrawable(getResources().getIdentifier(city.getIconUri(),
                   //     null, getContext().getPackageName())));
          // itemTmp.setText(Math.round(city[0].getTemperature())+" °C");
           // LiveData<List<City>>=
            //viewModel.Update(city);
            viewmodel.updateCities();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}