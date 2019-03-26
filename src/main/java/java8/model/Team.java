package java8.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Team {

    private List<String> footballerList;

    private String name;

    private String coachName;

    @Override
    public String toString() {
        return "team name : " +
                name +
                "\n" +
                "coach name : " +
                coachName +
                "\n" +
                "footballers : " +
                footballerList;
    }
}