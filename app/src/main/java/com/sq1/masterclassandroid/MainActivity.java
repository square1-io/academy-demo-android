package com.sq1.masterclassandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sq1.masterclassandroid.adapters.AdapterTeams;
import com.sq1.masterclassandroid.apiclient.HttpTaskListener;
import com.sq1.masterclassandroid.apiclient.RequestAsyncTask;
import com.sq1.masterclassandroid.model.Team;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements HttpTaskListener {

    RecyclerView rvTeamsList;
    AdapterTeams adapterTeams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvTeamsList = findViewById(R.id.rvTeamsList);
        rvTeamsList.setLayoutManager(new LinearLayoutManager(this));
        adapterTeams = new AdapterTeams(this);
        rvTeamsList.setAdapter(adapterTeams);

        requestData();
    }

    private void requestData() {

        new RequestAsyncTask(this, this).execute();
//        new RequestHttpLibrary(this, this).execute();
    }

    @Override
    public void onHttpTaskCompleted(ArrayList<Team> teams) {

        adapterTeams.updateContents(teams);
    }
}

