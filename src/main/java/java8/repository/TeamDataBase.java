package java8.repository;

import java8.model.Team;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public interface TeamDataBase {

    //here used new future of java 8 static method in the Interface
    static List<Team> getTeams() {
        return Arrays
                .asList(Team
                                .builder()
                                .name("Manchester United")
                                .coachName("Ferguson")
                                .footballerList(Arrays.asList("Pogba"))
                                .wonCupsList(Arrays.asList("champion league","National league","premier league"))
                                .build(),
                        Team
                                .builder()
                                .coachName("Guardiola")
                                .name("Barcelona")
                                .footballerList(Arrays.asList("Xavi", "Messi", "Inesta"))
                                .wonCupsList(Arrays.asList("champion league","National league","La league"))
                                .build(),
                        Team
                                .builder()
                                .coachName("Zidane")
                                .name("Real Madrid")
                                .footballerList(Arrays.asList("Ronaldo", "Ramos", "Bale"))
                                .wonCupsList(Collections.singletonList("champion league"))
                                .build(),
                        Team
                                .builder()
                                .coachName("Konte")
                                .name("Juventus")
                                .footballerList(Arrays.asList("Buffon", "Pirlo", "Chelini"))
                                .wonCupsList(Arrays.asList("champion league","Italian league"))
                                .build());
    }
}
