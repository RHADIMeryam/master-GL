package fr.uavignon.ceri.tp3.data;

import java.util.List;

public class WeatherResponse {
    //public final Properties properties=null;
    //public City city;
    //public class Properties {
 //public final List<Forecast> periods=null;
// OWMInterface api= WeatherRepository.loadWeatherCity(city).
   public final Main main=null;
   public final Wind wind=null;
   public final Clouds clouds=null;
   public Long dt;
   public final List<Condition> weather=null;
   public static class Main{
       public final Float temp=null;
       public final Integer humidity=null;
   }
   public static class Wind{
       public final Float speed=null;
   }
   public static class Condition{
       public final String description=null;
       public final String icon=null;
   }
   public static class Clouds{
       public final Integer all=null;
   }

}