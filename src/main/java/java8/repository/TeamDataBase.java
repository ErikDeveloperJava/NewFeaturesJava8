package java8.repository;

import java8.model.Team;

import java.util.Arrays;
import java.util.List;

public interface TeamDataBase {

    //here used new future of java 8 static method in the Interface
    static List<Team> getTeams() {
        return Arrays
                .asList(Team
                                .builder()
                                .name("Manchester United")
                                .coachName("Ferguson")
                                .footballerList(Arrays.asList("Pogba","Nani","Rooney"))
                                .build(),
                        Team
                                .builder()
                                .coachName("Guardiola")
                                .name("Barcelona")
                                .footballerList(Arrays.asList("Xavi","Messi","Inesta"))
                                .build(),
                        Team
                                .builder()
                                .coachName("Zidane")
                                .name("Real Madrid")
                                .footballerList(Arrays.asList("Ronaldo","Ramos","Bale"))
                                .build());
    }
}
