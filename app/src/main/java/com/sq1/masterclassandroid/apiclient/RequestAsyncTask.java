package com.sq1.masterclassandroid.apiclient;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.sq1.masterclassandroid.model.Team;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Pedro on 22/09/2017.
 */
public class RequestAsyncTask extends AsyncTask<Void, Void, ArrayList<Team>> {

    private static final String TAG = RequestAsyncTask.class.getSimpleName();

    Context context;
    private HttpTaskListener listener;

    public RequestAsyncTask(Context context, HttpTaskListener listener) {

        this.context = context;
        this.listener = listener;
    }

    @Override
    protected ArrayList<Team> doInBackground(Void... voids) {

        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String answerJsonStr = null;

        try {
            URL url = new URL("http://api.football-data.org/v1/competitions/455/leagueTable");
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();
            if (inputStream == null) {
                return null;
            }
            reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line + "\n");
            }

            if (buffer.length() == 0) {
                return null;
            }
            answerJsonStr = buffer.toString();
            Log.i(TAG, "JSON obtained: " + answerJsonStr);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (final IOException e) {
                    Log.e(TAG, "Error closing stream", e);
                }
            }
        }
        return parseAsyncResult(answerJsonStr);
    }

    private ArrayList<Team> parseAsyncResult(String answerJsonStr) {

        // parsing json to object by hand

        ArrayList<Team> teams = new ArrayList<>();

        try {
            JSONObject jsonAnswer = new JSONObject(answerJsonStr);
            JSONArray jsonTeams = jsonAnswer.getJSONArray("standing");
            for (int i = 0; i < jsonTeams.length(); i++) {

                Team tempTeam = new Team();
                JSONObject jsonTeam = jsonTeams.getJSONObject(i);
                tempTeam.setTeamName(jsonTeam.getString("teamName"));
                tempTeam.setPosition(jsonTeam.getInt("position"));
                tempTeam.setPoints(jsonTeam.getInt("points"));

                teams.add(tempTeam);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return teams;
    }

    @Override
    protected void onPostExecute(ArrayList<Team> teams) {

        listener.onHttpTaskCompleted(teams);
        super.onPostExecute(teams);
    }
}

