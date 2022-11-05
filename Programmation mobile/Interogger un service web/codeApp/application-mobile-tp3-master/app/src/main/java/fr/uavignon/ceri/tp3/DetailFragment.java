package fr.uavignon.ceri.tp3;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import fr.uavignon.ceri.tp3.data.City;

public class DetailFragment extends Fragment {
    public static final String TAG = DetailFragment.class.getSimpleName();

    private DetailViewModel viewModel;
    private TextView textCityName, textCountry, textTemperature, textHumidity, textCloudiness, textWind, textLastUpdate;
    private ImageView imgWeather;
    private ProgressBar progress;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(this).get(DetailViewModel.class);

        // Get selected city
        DetailFragmentArgs args = DetailFragmentArgs.fromBundle(getArguments());
        long cityID = args.getCityNum();
        Log.d(TAG,"selected id="+cityID);
        viewModel.setCity(cityID);
        listenerSetup();
        observerSetup();
    }


    private void listenerSetup() {
        textCityName = getView().findViewById(R.id.nameCity);
        textCountry = getView().findViewById(R.id.country);
        textTemperature = getView().findViewById(R.id.editTemperature);
        textHumidity = getView().findViewById(R.id.editHumidity);
        textCloudiness = getView().findViewById(R.id.editCloudiness);
        textWind = getView().findViewById(R.id.editWind);
        textLastUpdate = getView().findViewById(R.id.editLastUpdate);

        imgWeather = getView().findViewById(R.id.iconeWeather);

        progress = getView().findViewById(R.id.progress);
        // viewModel.results
        getView().findViewById(R.id.buttonUpdate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String CityName= textCityName.getText().toString();
                String Country= textCountry.getText().toString();
                City city=new City(CityName,Country);
               // textLastUpdate.setText(city.getDate());
                viewModel.Update(city);
            }


        });

        getView().findViewById(R.id.buttonBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(fr.uavignon.ceri.tp3.DetailFragment.this)
                        .navigate(R.id.action_DetailFragment_to_ListFragment);
            }
        });
    }

    private void observerSetup() {
        viewModel.getCity().observe(getViewLifecycleOwner(),
                city -> {
                    if (city != null) {
                        Log.d(TAG, "observing city view");

                        textCityName.setText(city.getName());
                        textCountry.setText(city.getCountry());
                        if (city.getTemperature() != null)
                            textTemperature.setText(Math.round(city.getTemperature())+" °C");
                        if (city.getHumidity() != null)
                            textHumidity.setText(city.getHumidity()+" %");
                        if (city.getCloudiness() != null)
                            textCloudiness.setText(city.getCloudiness()+" %");
                        if (city.getFullWind() != null)
                            textWind.setText((city.getFullWind()));
                            textLastUpdate.setText(city.getStrLastUpdate());
                       // if(city.getStrLastUpdate() !=null)
                           // textLastUpdate.setText(city.getDate());

                        }

                        // set ImgView
                        if (city.getIconUri() != null)
                            imgWeather.setImageDrawable(getResources().getDrawable(getResources().getIdentifier(city.getIconUri(),
                                null, getContext().getPackageName())));


                });



    }


}