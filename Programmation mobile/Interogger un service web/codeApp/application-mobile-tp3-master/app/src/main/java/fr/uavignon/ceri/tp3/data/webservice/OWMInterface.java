package fr.uavignon.ceri.tp3.data.webservice;

import java.util.List;

import fr.uavignon.ceri.tp3.data.City;
import fr.uavignon.ceri.tp3.data.WeatherResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface OWMInterface {



    @GET("/data/2.5/weather?")
    Call<WeatherResponse> getWeatherResponse(
            @Query("q") String q,
            @Query("appid") String key);
}
