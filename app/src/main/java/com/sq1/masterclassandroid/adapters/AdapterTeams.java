package com.sq1.masterclassandroid.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sq1.masterclassandroid.R;
import com.sq1.masterclassandroid.model.Team;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pedro on 22/09/2017.
 */

public class AdapterTeams extends RecyclerView.Adapter<AdapterTeams.TeamViewHolder> {

    List<Team> teams;
    Context context;

    public AdapterTeams(Context context) {

        this.teams = new ArrayList<>();
        this.context = context;
    }

    public void updateContents(ArrayList<Team> newTeams) {

        teams.clear();
        teams.addAll(newTeams);
        notifyDataSetChanged();
    }



    @Override
    public TeamViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_team, parent, false);

        TeamViewHolder teamViewHolder = new TeamViewHolder(rootView);
        return teamViewHolder;
    }

    @Override
    public void onBindViewHolder(TeamViewHolder holder, int position) {

        Team team = teams.get(position);

        holder.tablePosition.setText(String.valueOf(team.getPosition()));
        holder.name.setText(team.getTeamName());
        holder.score.setText(String.valueOf(team.getPoints()) + " points");

    }

    @Override
    public int getItemCount() {

        return teams.size();
    }

    public static class TeamViewHolder extends RecyclerView.ViewHolder {

        TextView tablePosition;
        TextView name;
        TextView score;

        public TeamViewHolder(View itemView) {
            super(itemView);

            tablePosition = itemView.findViewById(R.id.tvTeamTablePosition);
            name = itemView.findViewById(R.id.tvTeamName);
            score = itemView.findViewById(R.id.tvTeamScore);
        }
    }

}

