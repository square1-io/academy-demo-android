package com.sq1.masterclassandroid.apiclient;

import com.sq1.masterclassandroid.model.Team;

import java.util.ArrayList;

/**
 * Created by Pedro on 22/09/2017.
 */

public interface HttpTaskListener {

    void onHttpTaskCompleted(ArrayList<Team> teams);
}

