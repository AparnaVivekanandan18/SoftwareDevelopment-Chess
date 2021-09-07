package com.tournament.model;
import java.util.ArrayList;

public class FormTournamentGroups {
    private ArrayList<Player> expert;
    private ArrayList<Player> intermediate;
    private ArrayList<Player> beginner;
    private ArrayList<ArrayList> tournamentList;

    private int numOfUsersActive;
    private int PlayerLevel;
    private int totalBatches;
    private int defaultBatchSize;

    public FormTournamentGroups() {
        this.expert = new ArrayList<>();
        this.intermediate = new ArrayList<>();
        this.beginner = new ArrayList<>();
        tournamentList = new ArrayList<>();
        numOfUsersActive = 0;
        PlayerLevel = 0;
        totalBatches = 0;
        defaultBatchSize = 6;
    }

    private void groupLevels(ArrayList<Player> playerList) {
        for (Player p : playerList) {
            numOfUsersActive = numOfUsersActive + 1;
            PlayerLevel = p.getPlayerLevel();
            if (PlayerLevel == 1) {
                expert.add(p);
            } else if (PlayerLevel == 2) {
                intermediate.add(p);
            } else {
                beginner.add(p);
            }
        }
    }

    public ArrayList<ArrayList> formSubTournamentGroups(ArrayList<Player> playerList)
    {
        groupLevels(playerList);
        totalBatches = numOfUsersActive / defaultBatchSize;
        ArrayList<Player> listOfAllBatches = new ArrayList();
        for (int i = 0; i < totalBatches; i++) {
            ArrayList<Player> tempList = new ArrayList();
             while (tempList.size() < defaultBatchSize)
             {
                if (expert.size() > 0 && tempList.size() <= 6) {
                    tempList.add(expert.get(0));
                    expert.remove(0);
                }

                if (intermediate.size() > 0 && tempList.size() <= 6) {
                    tempList.add(intermediate.get(0));
                    intermediate.remove(0);
                }

                if (beginner.size() > 0 && tempList.size() <= 6) {
                    tempList.add(beginner.get(0));
                    beginner.remove(0);
                }
            }
            listOfAllBatches = tempList;
            tournamentList.add(listOfAllBatches);
        }
        return tournamentList;
    }
}
