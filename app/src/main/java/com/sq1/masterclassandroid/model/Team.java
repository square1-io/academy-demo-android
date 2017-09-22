package com.sq1.masterclassandroid.model;

/**
 * Created by Pedro on 22/09/2017.
 */

public class Team {

    /**
     * _links : {"team":{"href":"http://api.football-data.org/v1/teams/81"}}
     * position : 1
     * teamName : FC Barcelona
     * crestURI : http://upload.wikimedia.org/wikipedia/de/a/aa/Fc_barcelona.svg
     * playedGames : 5
     * points : 15
     * goals : 17
     * goalsAgainst : 2
     * goalDifference : 15
     * wins : 5
     * draws : 0
     * losses : 0
     * home : {"goals":13,"goalsAgainst":1,"wins":3,"draws":0,"losses":0}
     * away : {"goals":4,"goalsAgainst":1,"wins":2,"draws":0,"losses":0}
     */

    private LinksBean _links;
    private int position;
    private String teamName;
    private String crestURI;
    private int playedGames;
    private int points;
    private int goals;
    private int goalsAgainst;
    private int goalDifference;
    private int wins;
    private int draws;
    private int losses;
    private HomeBean home;
    private AwayBean away;

    public LinksBean get_links() {
        return _links;
    }

    public void set_links(LinksBean _links) {
        this._links = _links;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getCrestURI() {
        return crestURI;
    }

    public void setCrestURI(String crestURI) {
        this.crestURI = crestURI;
    }

    public int getPlayedGames() {
        return playedGames;
    }

    public void setPlayedGames(int playedGames) {
        this.playedGames = playedGames;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public void setGoalsAgainst(int goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }

    public int getGoalDifference() {
        return goalDifference;
    }

    public void setGoalDifference(int goalDifference) {
        this.goalDifference = goalDifference;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public HomeBean getHome() {
        return home;
    }

    public void setHome(HomeBean home) {
        this.home = home;
    }

    public AwayBean getAway() {
        return away;
    }

    public void setAway(AwayBean away) {
        this.away = away;
    }

    public static class LinksBean {
        /**
         * team : {"href":"http://api.football-data.org/v1/teams/81"}
         */

        private TeamBean team;

        public TeamBean getTeam() {
            return team;
        }

        public void setTeam(TeamBean team) {
            this.team = team;
        }

        public static class TeamBean {
            /**
             * href : http://api.football-data.org/v1/teams/81
             */

            private String href;

            public String getHref() {
                return href;
            }

            public void setHref(String href) {
                this.href = href;
            }
        }
    }

    public static class HomeBean {
        /**
         * goals : 13
         * goalsAgainst : 1
         * wins : 3
         * draws : 0
         * losses : 0
         */

        private int goals;
        private int goalsAgainst;
        private int wins;
        private int draws;
        private int losses;

        public int getGoals() {
            return goals;
        }

        public void setGoals(int goals) {
            this.goals = goals;
        }

        public int getGoalsAgainst() {
            return goalsAgainst;
        }

        public void setGoalsAgainst(int goalsAgainst) {
            this.goalsAgainst = goalsAgainst;
        }

        public int getWins() {
            return wins;
        }

        public void setWins(int wins) {
            this.wins = wins;
        }

        public int getDraws() {
            return draws;
        }

        public void setDraws(int draws) {
            this.draws = draws;
        }

        public int getLosses() {
            return losses;
        }

        public void setLosses(int losses) {
            this.losses = losses;
        }
    }

    public static class AwayBean {
        /**
         * goals : 4
         * goalsAgainst : 1
         * wins : 2
         * draws : 0
         * losses : 0
         */

        private int goals;
        private int goalsAgainst;
        private int wins;
        private int draws;
        private int losses;

        public int getGoals() {
            return goals;
        }

        public void setGoals(int goals) {
            this.goals = goals;
        }

        public int getGoalsAgainst() {
            return goalsAgainst;
        }

        public void setGoalsAgainst(int goalsAgainst) {
            this.goalsAgainst = goalsAgainst;
        }

        public int getWins() {
            return wins;
        }

        public void setWins(int wins) {
            this.wins = wins;
        }

        public int getDraws() {
            return draws;
        }

        public void setDraws(int draws) {
            this.draws = draws;
        }

        public int getLosses() {
            return losses;
        }

        public void setLosses(int losses) {
            this.losses = losses;
        }
    }

    @Override
    public String toString() {
        return "Team{" +
                "position=" + position +
                ", teamName='" + teamName + '\'' +
                ", points=" + points +
                '}';
    }
}

