package myweatherapp.jayaprakash.com.myweatherapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Prakash on 12-Feb-18.
 */

public class MainActivity extends AppCompatActivity {


    String chennaiWeatherCity, chennaiWeatherDescription, chennaiWeatherTemperature, chennaiWeatherHumidity, chennaiWeatherPressure, chennaiWeatherUpdatedOn, chennaiWeatherIconText, chennaiWeatherSunRise;
    String mumbaiWeatherCity, mumbaiWeatherDescription, mumbaiWeatherTemperature, mumbaiWeatherHumidity, mumbaiWeatherPressure, mumbaiWeatherUpdatedOn, mumbaiWeatherIconText, mumbaiWeatherSunRise;
    String bangaloreWeatherCity, bangaloreWeatherDescription, bangaloreWeatherTemperature, bangaloreWeatherHumidity, bangaloreWeatherPressure, bangaloreWeatherUpdatedOn, bangaloreWeatherIconText, bangaloreWeatherSunRise;
    String newdelhiWeatherCity, newdelhiWeatherDescription, newdelhiWeatherTemperature, newdelhiWeatherHumidity, newdelhiWeatherPressure, newdelhiWeatherUpdatedOn, newdelhiWeatherIconText, newdelhiWeatherSunRise;
    String day[] = new String[4];

    TextView chennaiCityField, chennaiDetailsField, chennaiCurrentTemperatureField, chennaiWeatherIcon;
    TextView mumbaiCityField, mumbaiDetailsField, mumbaiCurrentTemperatureField, mumbaiWeatherIcon;
    TextView bangaloreCityField, bangaloreDetailsField, bangaloreCurrentTemperatureField, bangaloreWeatherIcon;
    TextView newdelhiCityField, newdelhiDetailsField, newdelhiCurrentTemperatureField, newdelhiWeatherIcon;
    TextView chennaiDay1Field, chennaiDay2Filed, chennaiDay3Field, mumbaiDay1Field, mumbaiDay2Field, mumbaiDay3Field;
    TextView bangaloreDay1Field, bangaloreDay2Field, bangaloreDay3Field, newdelhiDay1Field, newdelhiDay2Field, newdelhiDay3Field;
    TextView chennaiMinTempField1, chennaiMaxTempField1, chennaiMinTempField2, chennaiMaxTempField2, chennaiMinTempField3, chennaiMaxTempField3;
    TextView mumbaiMinTempField1, mumbaiMaxTempField1, mumbaiMinTempField2, mumbaiMaxTempField2, mumbaiMinTempField3, mumbaiMaxTempField3;
    TextView bangaloreMinTempField1, bangaloreMaxTempField1, bangaloreMinTempField2, bangaloreMaxTempField2, bangaloreMinTempField3, bangaloreMaxTempField3;
    TextView newdelhiMinTempField1, newdelhiMaxTempField1, newdelhiMinTempField2, newdelhiMaxTempField2, newdelhiMinTempField3, newdelhiMaxTempField3;
    CardView chennaiWeatherField, mumbaiWeatherField, bangaloreWeatherField, newdelhiWeatherField;

    Typeface weatherFont;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);


        weatherFont = Typeface.createFromAsset(getAssets(),
                "fonts/weathericons-regular-webfont.ttf");


        chennaiDay1Field = (TextView) findViewById(R.id.day1);
        chennaiDay2Filed = (TextView) findViewById(R.id.day2);
        chennaiDay3Field = (TextView) findViewById(R.id.day3);
        mumbaiDay1Field = (TextView) findViewById(R.id.mumbai_day1);
        mumbaiDay2Field = (TextView) findViewById(R.id.mumbai_day2);
        mumbaiDay3Field = (TextView) findViewById(R.id.mumbai_day3);
        bangaloreDay1Field = (TextView) findViewById(R.id.bangalore_day1);
        bangaloreDay2Field = (TextView) findViewById(R.id.bangalore_day2);
        bangaloreDay3Field = (TextView) findViewById(R.id.bangalore_day3);
        newdelhiDay1Field = (TextView) findViewById(R.id.newdelhi_day1);
        newdelhiDay2Field = (TextView) findViewById(R.id.newdelhi_day2);
        newdelhiDay3Field = (TextView) findViewById(R.id.newdelhi_day3);


        chennaiMinTempField1 = (TextView) findViewById(R.id.chennai_min_temp_1);
        chennaiMinTempField2 = (TextView) findViewById(R.id.chennai_min_temp_2);
        chennaiMinTempField3 = (TextView) findViewById(R.id.chennai_min_temp_3);
        chennaiMaxTempField1 = (TextView) findViewById(R.id.chennai_max_temp_1);
        chennaiMaxTempField2 = (TextView) findViewById(R.id.chennai_max_temp_2);
        chennaiMaxTempField3 = (TextView) findViewById(R.id.chennai_max_temp_3);
        mumbaiMinTempField1 = (TextView) findViewById(R.id.mumbai_min_temp_1);
        mumbaiMinTempField2 = (TextView) findViewById(R.id.mumbai_min_temp_2);
        mumbaiMinTempField3 = (TextView) findViewById(R.id.mumbai_min_temp_3);
        mumbaiMaxTempField1 = (TextView) findViewById(R.id.mumbai_max_temp_1);
        mumbaiMaxTempField2 = (TextView) findViewById(R.id.mumbai_max_temp_2);
        mumbaiMaxTempField3 = (TextView) findViewById(R.id.mumbai_max_temp_3);
        bangaloreMinTempField1 = (TextView) findViewById(R.id.bangalore_min_temp_1);
        bangaloreMinTempField2 = (TextView) findViewById(R.id.bangalore_min_temp_2);
        bangaloreMinTempField3 = (TextView) findViewById(R.id.bangalore_min_temp_3);
        bangaloreMaxTempField1 = (TextView) findViewById(R.id.bangalore_max_temp_1);
        bangaloreMaxTempField2 = (TextView) findViewById(R.id.bangalore_max_temp_2);
        bangaloreMaxTempField3 = (TextView) findViewById(R.id.bangalore_max_temp_3);
        newdelhiMinTempField1 = (TextView) findViewById(R.id.newdelhi_min_temp_1);
        newdelhiMinTempField2 = (TextView) findViewById(R.id.newdelhi_min_temp_2);
        newdelhiMinTempField3 = (TextView) findViewById(R.id.newdelhi_min_temp_3);
        newdelhiMaxTempField1 = (TextView) findViewById(R.id.newdelhi_max_temp_1);
        newdelhiMaxTempField2 = (TextView) findViewById(R.id.newdelhi_max_temp_2);
        newdelhiMaxTempField3 = (TextView) findViewById(R.id.newdelhi_max_temp_3);


        chennaiWeatherField = (CardView) findViewById(R.id.chennai_weather_field);
        mumbaiWeatherField = (CardView) findViewById(R.id.mumbai_weather_field);
        bangaloreWeatherField = (CardView) findViewById(R.id.bangalore_weather_field);
        newdelhiWeatherField = (CardView) findViewById(R.id.newdelhi_weather_field);

        chennaiCityField = (TextView) findViewById(R.id.city_field);
        chennaiDetailsField = (TextView) findViewById(R.id.details_field);
        chennaiCurrentTemperatureField = (TextView) findViewById(R.id.current_temperature_field);
        chennaiWeatherIcon = (TextView) findViewById(R.id.weather_icon);
        chennaiWeatherIcon.setTypeface(weatherFont);

        mumbaiCityField = (TextView) findViewById(R.id.mumbai_city_field);
        mumbaiDetailsField = (TextView) findViewById(R.id.mumbai_details_field);
        mumbaiCurrentTemperatureField = (TextView) findViewById(R.id.mumbai_current_temperature_field);
        mumbaiWeatherIcon = (TextView) findViewById(R.id.mumbai_weather_icon);
        mumbaiWeatherIcon.setTypeface(weatherFont);

        bangaloreCityField = (TextView) findViewById(R.id.bangalore_city_field);
        bangaloreDetailsField = (TextView) findViewById(R.id.bangalore_details_field);
        bangaloreCurrentTemperatureField = (TextView) findViewById(R.id.bangalore_current_temperature_field);
        bangaloreWeatherIcon = (TextView) findViewById(R.id.bangalore_weather_icon);
        bangaloreWeatherIcon.setTypeface(weatherFont);

        newdelhiCityField = (TextView) findViewById(R.id.newdelhi_city_field);
        newdelhiDetailsField = (TextView) findViewById(R.id.newdelhi_details_field);
        newdelhiCurrentTemperatureField = (TextView) findViewById(R.id.newdelhi_current_temperature_field);
        newdelhiWeatherIcon = (TextView) findViewById(R.id.newdelhi_weather_icon);
        newdelhiWeatherIcon.setTypeface(weatherFont);


        getDay();
        GetForecastChennai("19.014410", "72.847939");
        GetForecastMumbai("13.087840", "80.278473");
        GetForecastBangalore("12.976230", "77.603287");
        GetForecastNewDelhi("28.612820", "77.231140");

        getCurrentWeatherChennai("13.087840", "80.278473");
        getCurrentWeatherMumbai("19.014410", "72.847939");
        getCurrentWeatherBangalore("12.976230", "77.603287");
        getCurrentWeatherNewDelhi("28.612820", "77.231140");


        chennaiWeatherField.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cityWeatherDetail(chennaiWeatherCity, chennaiWeatherDescription, chennaiWeatherTemperature, chennaiWeatherHumidity, chennaiWeatherPressure, chennaiWeatherUpdatedOn, chennaiWeatherIconText, chennaiWeatherSunRise);

            }
        });

        mumbaiWeatherField.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cityWeatherDetail(mumbaiWeatherCity, mumbaiWeatherDescription, mumbaiWeatherTemperature, mumbaiWeatherHumidity, mumbaiWeatherPressure, mumbaiWeatherUpdatedOn, mumbaiWeatherIconText, mumbaiWeatherSunRise);
            }
        });

        bangaloreWeatherField.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cityWeatherDetail(bangaloreWeatherCity, bangaloreWeatherDescription, bangaloreWeatherTemperature, bangaloreWeatherHumidity, bangaloreWeatherPressure, bangaloreWeatherUpdatedOn, bangaloreWeatherIconText, bangaloreWeatherSunRise);
            }
        });

        newdelhiWeatherField.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cityWeatherDetail(newdelhiWeatherCity, newdelhiWeatherDescription, newdelhiWeatherTemperature, newdelhiWeatherHumidity, newdelhiWeatherPressure, newdelhiWeatherUpdatedOn, newdelhiWeatherIconText, newdelhiWeatherSunRise);
            }
        });


    }

    /**
     * Get next three days from current date
     */
    public void getDay() {


        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Calendar date = Calendar.getInstance();

        // Get Date in next 3 days

        for (int i = 0; i < 3; i++) {
            day[i] = format.format(date.getTime());
            date.add(Calendar.DATE, 1);
            day[i] = android.text.format.DateFormat.format("EEEE", date).toString();
        }

        chennaiDay1Field.setText(day[0]);
        chennaiDay2Filed.setText(day[1]);
        chennaiDay3Field.setText(day[2]);
        mumbaiDay1Field.setText(day[0]);
        mumbaiDay2Field.setText(day[1]);
        mumbaiDay3Field.setText(day[2]);
        bangaloreDay1Field.setText(day[0]);
        bangaloreDay2Field.setText(day[1]);
        bangaloreDay3Field.setText(day[2]);
        newdelhiDay1Field.setText(day[0]);
        newdelhiDay2Field.setText(day[1]);
        newdelhiDay3Field.setText(day[2]);

    }

    /**
     * Get current weather for Chennai
     */
    public void getCurrentWeatherChennai(final String lattitude, final String longtitude) {
        final CurrentWeatherApiCall.placeIdTask asyncTask2 = new CurrentWeatherApiCall.placeIdTask(new CurrentWeatherApiCall.AsyncResponse() {
            @Override
            public void processFinish(String weather_city, String weather_description, String weather_temperature, String weather_humidity, String weather_pressure, String weather_updatedOn, String weather_iconText, String sun_rise) {

                chennaiWeatherCity = weather_city;
                chennaiWeatherDescription = weather_description;
                chennaiWeatherTemperature = weather_temperature;
                chennaiWeatherHumidity = weather_humidity;
                chennaiWeatherPressure = weather_pressure;
                chennaiWeatherUpdatedOn = weather_updatedOn;
                chennaiWeatherIconText = weather_iconText;
                chennaiWeatherSunRise = sun_rise;

                chennaiCityField.setText(chennaiWeatherCity);
                chennaiCurrentTemperatureField.setText(chennaiWeatherTemperature);
                chennaiDetailsField.setText(chennaiWeatherDescription);

                if (Build.VERSION.SDK_INT >= 24) {
                    chennaiWeatherIcon.setText(Html.fromHtml(chennaiWeatherIconText, 0)); // for 24 api and more
                } else {
                    chennaiWeatherIcon.setText(Html.fromHtml(chennaiWeatherIconText)); // or for older api
                }
            }


        });
        asyncTask2.execute(lattitude, longtitude);
    }

    /**
     * Get current weather for Mumbai
     */
    public void getCurrentWeatherMumbai(final String lattitude, final String longtitude) {

        final CurrentWeatherApiCall.placeIdTask asyncTask2 = new CurrentWeatherApiCall.placeIdTask(new CurrentWeatherApiCall.AsyncResponse() {
            @Override
            public void processFinish(String weather_city, String weather_description, String weather_temperature, String weather_humidity, String weather_pressure, String weather_updatedOn, String weather_iconText, String sun_rise) {

                mumbaiWeatherCity = weather_city;
                mumbaiWeatherDescription = weather_description;
                mumbaiWeatherTemperature = weather_temperature;
                mumbaiWeatherHumidity = weather_humidity;
                mumbaiWeatherPressure = weather_pressure;
                mumbaiWeatherUpdatedOn = weather_updatedOn;
                mumbaiWeatherIconText = weather_iconText;
                mumbaiWeatherSunRise = sun_rise;

                mumbaiCityField.setText(weather_city);
                mumbaiCurrentTemperatureField.setText(weather_temperature);
                mumbaiDetailsField.setText(weather_description);

                if (Build.VERSION.SDK_INT >= 24) {
                    mumbaiWeatherIcon.setText(Html.fromHtml(mumbaiWeatherIconText, 0)); // for 24 api and more
                } else {
                    mumbaiWeatherIcon.setText(Html.fromHtml(mumbaiWeatherIconText)); // or for older api
                }
            }
        });
        asyncTask2.execute(lattitude, longtitude);
    }

    /**
     * Get current weather for Bangalore
     */
    public void getCurrentWeatherBangalore(final String lattitude, final String longtitude) {

        final CurrentWeatherApiCall.placeIdTask asyncTask2 = new CurrentWeatherApiCall.placeIdTask(new CurrentWeatherApiCall.AsyncResponse() {
            @Override
            public void processFinish(String weather_city, String weather_description, String weather_temperature, String weather_humidity, String weather_pressure, String weather_updatedOn, String weather_iconText, String sun_rise) {

                bangaloreWeatherCity = weather_city;
                bangaloreWeatherDescription = weather_description;
                bangaloreWeatherTemperature = weather_temperature;
                bangaloreWeatherHumidity = weather_humidity;
                bangaloreWeatherPressure = weather_pressure;
                bangaloreWeatherUpdatedOn = weather_updatedOn;
                bangaloreWeatherIconText = weather_iconText;
                bangaloreWeatherSunRise = sun_rise;


                bangaloreCityField.setText(weather_city);
                bangaloreCurrentTemperatureField.setText(weather_temperature);
                bangaloreDetailsField.setText(weather_description);

                if (Build.VERSION.SDK_INT >= 24) {
                    bangaloreWeatherIcon.setText(Html.fromHtml(bangaloreWeatherIconText, 0)); // for 24 api and more
                } else {
                    bangaloreWeatherIcon.setText(Html.fromHtml(bangaloreWeatherIconText)); // or for older api
                }
            }
        });
        asyncTask2.execute(lattitude, longtitude);
    }

    /**
     * Get current weather for NewDelhi
     */
    public void getCurrentWeatherNewDelhi(final String lattitude, final String longtitude) {

        final CurrentWeatherApiCall.placeIdTask asyncTask2 = new CurrentWeatherApiCall.placeIdTask(new CurrentWeatherApiCall.AsyncResponse() {
            @Override
            public void processFinish(String weather_city, String weather_description, String weather_temperature, String weather_humidity, String weather_pressure, String weather_updatedOn, String weather_iconText, String sun_rise) {

                newdelhiWeatherCity = weather_city;
                newdelhiWeatherDescription = weather_description;
                newdelhiWeatherTemperature = weather_temperature;
                newdelhiWeatherHumidity = weather_humidity;
                newdelhiWeatherPressure = weather_pressure;
                newdelhiWeatherUpdatedOn = weather_updatedOn;
                newdelhiWeatherIconText = weather_iconText;
                newdelhiWeatherSunRise = sun_rise;

                newdelhiCityField.setText(weather_city);
                newdelhiCurrentTemperatureField.setText(weather_temperature);
                newdelhiDetailsField.setText(weather_description);

                if (Build.VERSION.SDK_INT >= 24) {
                    newdelhiWeatherIcon.setText(Html.fromHtml(newdelhiWeatherIconText, 0)); // for 24 api and more
                } else {
                    newdelhiWeatherIcon.setText(Html.fromHtml(newdelhiWeatherIconText)); // or for older api
                }
            }
        });
        asyncTask2.execute(lattitude, longtitude);
    }

    /**
     * Start CurrentWeather activity with  aditional weather details when Onclick
     */
    public void cityWeatherDetail(String weatherCity, String weatherDescription, String weatherTemperature, String weatherHumidity, String weatherPressure, String weatherUpdatedOn, String weatherIconText, String weatherSunRise) {
        Intent intent = new Intent(MainActivity.this, CurrentWeather.class);
        intent.putExtra("weather_city", weatherCity);
        intent.putExtra("weather_description", weatherDescription);
        intent.putExtra("weather_temperature", weatherTemperature);
        intent.putExtra("weather_humidity", weatherHumidity);
        intent.putExtra("weather_pressure", weatherPressure);
        intent.putExtra("weather_updatedOn", weatherUpdatedOn);
        intent.putExtra("weather_iconText", weatherIconText);
        intent.putExtra("sun_rise", weatherSunRise);
        startActivity(intent);
    }

    /**
     * Get Forecast details for Chennai
     */
    public void GetForecastChennai(String lattitude, String longtitude) {
        ForecastWeatherApiCall.placeIdTask asyncTask = new ForecastWeatherApiCall.placeIdTask(new ForecastWeatherApiCall.AsyncResponse() {
            public void processFinish(ArrayList minTemperature, ArrayList maxTemperature) {


                chennaiMinTempField1.setText(minTemperature.get(0).toString());
                chennaiMinTempField2.setText(minTemperature.get(1).toString());
                chennaiMinTempField3.setText(minTemperature.get(2).toString());

                chennaiMaxTempField1.setText(maxTemperature.get(0).toString());
                chennaiMaxTempField2.setText(maxTemperature.get(1).toString());
                chennaiMaxTempField3.setText(maxTemperature.get(3).toString());

            }
        });
        asyncTask.execute(lattitude, longtitude); //  asyncTask.execute("Latitude", "Longitude")

    }

    /**
     * Get Forecast details for Mumbai
     */
    public void GetForecastMumbai(String lattitude, String longtitude) {
        ForecastWeatherApiCall.placeIdTask asyncTask = new ForecastWeatherApiCall.placeIdTask(new ForecastWeatherApiCall.AsyncResponse() {
            public void processFinish(ArrayList minTemperature, ArrayList maxTemperature) {

                mumbaiMinTempField1.setText(minTemperature.get(0).toString());
                mumbaiMinTempField2.setText(minTemperature.get(1).toString());
                mumbaiMinTempField3.setText(minTemperature.get(2).toString());

                mumbaiMaxTempField1.setText(maxTemperature.get(0).toString());
                mumbaiMaxTempField2.setText(maxTemperature.get(1).toString());
                mumbaiMaxTempField3.setText(maxTemperature.get(3).toString());

            }
        });
        asyncTask.execute(lattitude, longtitude); //  asyncTask.execute("Latitude", "Longitude")

    }

    /**
     * Get Forecast details for Bangalore
     */
    public void GetForecastBangalore(String lattitude, String longtitude) {
        ForecastWeatherApiCall.placeIdTask asyncTask = new ForecastWeatherApiCall.placeIdTask(new ForecastWeatherApiCall.AsyncResponse() {
            public void processFinish(ArrayList minTemperature, ArrayList maxTemperature) {


                bangaloreMinTempField1.setText(minTemperature.get(0).toString());
                bangaloreMinTempField2.setText(minTemperature.get(1).toString());
                bangaloreMinTempField3.setText(minTemperature.get(2).toString());

                bangaloreMaxTempField1.setText(maxTemperature.get(0).toString());
                bangaloreMaxTempField2.setText(maxTemperature.get(1).toString());
                bangaloreMaxTempField3.setText(maxTemperature.get(3).toString());

            }
        });
        asyncTask.execute(lattitude, longtitude); //  asyncTask.execute("Latitude", "Longitude")

    }

    /**
     * Get Forecast details for NewDelhi
     */
    public void GetForecastNewDelhi(String lattitude, String longtitude) {
        ForecastWeatherApiCall.placeIdTask asyncTask = new ForecastWeatherApiCall.placeIdTask(new ForecastWeatherApiCall.AsyncResponse() {
            public void processFinish(ArrayList minTemperature, ArrayList maxTemperature) {
                newdelhiMinTempField1.setText(minTemperature.get(0).toString());
                newdelhiMinTempField2.setText(minTemperature.get(1).toString());
                newdelhiMinTempField3.setText(minTemperature.get(2).toString());

                newdelhiMaxTempField1.setText(maxTemperature.get(0).toString());
                newdelhiMaxTempField2.setText(maxTemperature.get(1).toString());
                newdelhiMaxTempField3.setText(maxTemperature.get(3).toString());

            }
        });
        asyncTask.execute(lattitude, longtitude); //  asyncTask.execute("Latitude", "Longitude")

    }


}
