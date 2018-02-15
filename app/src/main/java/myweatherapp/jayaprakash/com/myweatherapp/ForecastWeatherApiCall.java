package myweatherapp.jayaprakash.com.myweatherapp;


import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 * Created by Prakash on 12-Feb-18.
 */

public class ForecastWeatherApiCall {


    private static final String OPEN_WEATHER_MAP_API = "66ae74c96653d3a67c78d6fc2840f8cd";
    static ArrayList<Double> tempratureValue = new ArrayList<Double>();


    public interface AsyncResponse {

        void processFinish(ArrayList minValue, ArrayList maxValue);
    }


    public static class placeIdTask extends AsyncTask<String, Void, JSONObject> {

        public AsyncResponse delegate = null;//Call back interface
        DateFormat df = DateFormat.getDateTimeInstance();
        String tempDate = "";

        public placeIdTask(AsyncResponse asyncResponse) {
            delegate = asyncResponse;//Assigning call back interfacethrough constructor
        }

        @Override
        protected JSONObject doInBackground(String... params) {


            JSONObject jsonWeather = null;
            try {
                jsonWeather = getWeatherJSON(params[0], params[1]);
            } catch (Exception e) {
                Log.d("Error", "Cannot process JSON results", e);
            }


            return jsonWeather;
        }

        @Override
        protected void onPostExecute(JSONObject json) {
            try {

                if (json != null) {

                    JSONArray jArray = json.getJSONArray("list");

                    ArrayList<Double> minValue = new ArrayList<Double>();
                    ArrayList<Double> maxValue = new ArrayList<Double>();


                    tempDate = df.format(new Date(jArray.getJSONObject(0).getLong("dt") * 1000));


                    if (jArray != null) {
                        for (int i = 0; i < jArray.length(); i++) {

                            String date = df.format(new Date(jArray.getJSONObject(i).getLong("dt") * 1000));

                            if (tempDate.substring(0, 6).equals(date.substring(0, 6))) {


                                tempratureValue.add(Double.valueOf(jArray.getJSONObject(i).getJSONObject("main").getString("temp_max")));
                                tempratureValue.add(Double.valueOf(jArray.getJSONObject(i).getJSONObject("main").getString("temp_min")));


                            } else {

                                tempDate = date;
                                minValue.add(Collections.min(tempratureValue));
                                maxValue.add(Collections.max(tempratureValue));
                                tempratureValue.clear();
                            }


                        }

                    }

                    delegate.processFinish(minValue, maxValue);

                }
            } catch (JSONException e) {
                Log.e("err", "Cannot process JSON results", e);
            }


        }
    }


    public static JSONObject getWeatherJSON(String lat, String lon) {
        try {

            URL url = new URL("http://api.openweathermap.org/data/2.5/forecast?lat=" + lat + "&lon=" + lon + "&units=metric");

            HttpURLConnection connection =
                    (HttpURLConnection) url.openConnection();

            connection.addRequestProperty("x-api-key", OPEN_WEATHER_MAP_API);

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

            StringBuffer json = new StringBuffer(1024);
            String tmp = "";
            while ((tmp = reader.readLine()) != null)
                json.append(tmp).append("\n");
            reader.close();

            JSONObject data = new JSONObject(json.toString());

            // This value will be 404 if the request was not
            // successful
            if (data.getInt("cod") != 200) {
                return null;
            }
            return data;
        } catch (Exception e) {
            return null;
        }
    }
}
