package myweatherapp.jayaprakash.com.myweatherapp;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.Window;
import android.widget.TextView;

/**
 * Created by Prakash on 12-Feb-18.
 */

public class CurrentWeather extends AppCompatActivity {

    TextView humidity;
    TextView cityField, detailsField, currentTemperatureField, humidity_field, pressure_field, weatherIcon, updatedField;
    Typeface weatherFont;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_weather);
        humidity = (TextView) findViewById(R.id.city_field);

        weatherFont = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/weathericons-regular-webfont.ttf");

        cityField = (TextView) findViewById(R.id.city_field);
        updatedField = (TextView) findViewById(R.id.updated_field);
        detailsField = (TextView) findViewById(R.id.details_field);
        currentTemperatureField = (TextView) findViewById(R.id.current_temperature_field);
        humidity_field = (TextView) findViewById(R.id.humidity_field);
        pressure_field = (TextView) findViewById(R.id.pressure_field);
        weatherIcon = (TextView) findViewById(R.id.weather_icon);
        weatherIcon.setTypeface(weatherFont);


        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                return;
            } else {

                cityField.setText(extras.getString("weather_city"));
                updatedField.setText(extras.getString("weather_updatedOn"));
                detailsField.setText(extras.getString("weather_description"));
                currentTemperatureField.setText(extras.getString("weather_temperature"));
                humidity_field.setText("Humidity: " + extras.getString("weather_humidity"));
                pressure_field.setText("Pressure: " + extras.getString("weather_pressure"));
                weatherIcon.setText(Html.fromHtml(extras.getString("weather_iconText")));

            }
        } else {
            return;
        }


    }


}
