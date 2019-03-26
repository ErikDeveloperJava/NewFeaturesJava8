package java8.repository;

import java8.model.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TeamRepository {

    private List<Team> teamList;

    public TeamRepository() {
        //get teams for used static method of the interface
        teamList = TeamDataBase.getTeams();
    }

    //here used Optional class
    public Optional<Team> getByCoach(String coach){
        List<Optional<Team>> optionalList = new ArrayList<>();

        //here used lambda expression which is helping found team by coach name
        teamList.forEach(team -> {
            if(team.getCoachName().equals(coach)){
                optionalList.add(Optional.of(team));
            }
        });
        return optionalList.isEmpty() ? Optional.empty() : optionalList.get(0);
    }
}