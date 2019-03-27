package java8.repository;

import java8.model.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TeamRepository {

    private List<Team> teamList;

    public TeamRepository() {
        //get teams for used static method of the interface
        teamList = TeamDataBase.getTeams();
    }

    public List<Team> getByCoach(String coach) {
        //here used filter method of Stream object then return new List
        return teamList
                .stream()
                .filter(team -> team.getCoachName().equals(coach))
                .collect(Collectors.toList());
    }

    public Optional<Team> getByName(String name) {
        //here used filter method of Stream object then return first Element
        return teamList
                .stream()
                .filter(team -> team.getName().equals(name))
                .findFirst();
    }

    public List<String> getFootballersNameByStartWith(String startParam) {
        List<String> footballers = new ArrayList<>();
        //here used forEach method of Stream which is helping get all Footballers whose names are start with this startParam
        teamList
                .forEach(team -> team
                        .getFootballerList()
                        .forEach(footballer -> {
                            if (footballer.startsWith(startParam)) {
                                footballers.add(footballer);
                            }
                        }));
        return footballers;
    }

    public List<String> getTeamNamesByFootballersSizeAndWonCupCount(int footballersSize, int wonCupCount) {
        //here used filter of Stream Object then call map method which is helping change Generic type of Stream
        return teamList
                .stream()
                .filter(team -> team.getFootballerList().size() == footballersSize && team.getWonCupsList().size() == wonCupCount)
                .map(Team::getName)
                .collect(Collectors.toList());
    }

    public int countByGreaterThanEqualWonCupCupsCount(int wonCupsCount) {
        //here used filter of Stream Object then call count method which is getting list count
        return (int) teamList
                .stream()
                .filter(team -> team.getWonCupsList().size() >= wonCupsCount)
                .count();
    }

    public String joinTeamNamesByJoinOperatorAndCupName(String joinParam, String cupName) {
        //here first used filter of Stream Object then call map method which is give new List<String> then call reduce method which is join all strings of the list
        return teamList
                .stream()
                .filter(team -> team.getWonCupsList().contains(cupName))
                .map(Team::getName)
                .reduce((name1, name2) -> name1 + joinParam + " " + name2)
                .orElse("");
    }

    public List<String> getCoachNamesByWonCups(List<String> cupList) {
        return teamList
                .stream()
                .filter(team -> team
                        .getWonCupsList()
                        .stream().anyMatch(cupList::contains))
                .map(Team::getCoachName)
                .collect(Collectors.toList());
    }

}