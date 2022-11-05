package fr.uavignon.ceri.tp3;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;

import fr.uavignon.ceri.tp3.data.City;
import fr.uavignon.ceri.tp3.data.Forecast;
import fr.uavignon.ceri.tp3.data.WeatherRepository;
import fr.uavignon.ceri.tp3.data.WeatherResult;

public class DetailViewModel extends AndroidViewModel {
    public static final String TAG = DetailViewModel.class.getSimpleName();
    final MediatorLiveData<DetailViewModel> results = new MediatorLiveData<>();
     private LiveData<WeatherResult> lastResult;

    private WeatherRepository repository;
    private MutableLiveData<City> city;

    public DetailViewModel(Application application) {
        super(application);
        repository = WeatherRepository.get(application);
        city = new MutableLiveData<>();
    }

    public void setCity(long id) {
        repository.getCity(id);
        city = repository.getSelectedCity();
    }

    LiveData<City> getCity() {
        return city;
    }

    public void Update(City city) {
        repository.loadWeatherCity(city);

    }
}
