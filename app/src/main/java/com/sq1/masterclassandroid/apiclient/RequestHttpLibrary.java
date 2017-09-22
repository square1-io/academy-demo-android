package com.sq1.masterclassandroid.apiclient;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.sq1.masterclassandroid.model.Team;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Pedro on 22/09/2017.
 */

public class RequestHttpLibrary {

    private static final String TAG = RequestHttpLibrary.class.getSimpleName();

    private Context context;
    private HttpTaskListener listener;

    AsyncHttpClient client;


    public RequestHttpLibrary(Context context, HttpTaskListener listener) {

        this.context = context;
        this.listener = listener;

        client = new AsyncHttpClient();
    }


    public void execute() {

        client.get("http://api.football-data.org/v1/competitions/455/leagueTable", new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {

                Log.i(TAG, "onSuccess: " + response);

                parseLibraryResult(response);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {

                Log.i(TAG, "onFailure: " + throwable.getMessage());
            }
        });
    }

    private void parseLibraryResult(JSONObject response) {

        ArrayList<Team> teams = new ArrayList<>();

        Gson gson = new Gson();

        try {

            JSONArray jsonTeams = response.getJSONArray("standing");

            for (int i = 0; i < jsonTeams.length(); i++) {

                teams.add(gson.fromJson(String.valueOf(jsonTeams.get(i)), Team.class));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        listener.onHttpTaskCompleted(teams);
    }
}

