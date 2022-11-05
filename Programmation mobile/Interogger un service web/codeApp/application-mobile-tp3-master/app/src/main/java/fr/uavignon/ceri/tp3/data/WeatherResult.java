package fr.uavignon.ceri.tp3.data;

import android.util.Log;

import androidx.lifecycle.LiveData;

import java.util.List;

public class WeatherResult {
    String q;
    String key;
    public final boolean isLoading;
    public final List<Forecast> forecasts;
    public final Throwable error;

    public WeatherResult(String q, String key, boolean isLoading, List<Forecast> forecasts, Throwable error) {
        this.q=q;
        this.key=key;
        this.isLoading = isLoading;
        this.forecasts = forecasts;
        this.error = error;
    }
    static void transferInfo(WeatherResponse weatherInfo, City cityInfo)
    {
        cityInfo.setHumidity(weatherInfo.main.humidity);
        cityInfo.setIcon(weatherInfo.weather.get(0).icon);
        cityInfo.setDescription(weatherInfo.weather.get(0).description);
        cityInfo.setTemperature(weatherInfo.main.temp);
        cityInfo.setWindSpeedMPerS(weatherInfo.wind.speed);
        cityInfo.setDescription(weatherInfo.weather.toString());
        cityInfo.setCloudiness(weatherInfo.clouds.all);
        cityInfo.setLastUpdate(weatherInfo.dt);
       Log.d("hii",weatherInfo.main.humidity.toString());
    }

   /* static void transferInfo2(WeatherResponse weatherResponse, LiveData<List<City>> cities)
    {
        cities.setHumidity(weatherResponse.main.humidity);

        cityInfo.setIcon(weatherInfo.weather.get(0).icon);
        cityInfo.setDescription(weatherInfo.weather.get(0).description);
        cityInfo.setTemperature(weatherInfo.main.temp);
        cityInfo.setWindSpeedMPerS(weatherInfo.wind.speed);
        cityInfo.setDescription(weatherInfo.weather.toString());
        cityInfo.setCloudiness(weatherInfo.clouds.all);
        Log.d("hii",weatherInfo.main.humidity.toString());
    } */
}
