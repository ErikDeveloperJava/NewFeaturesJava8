package java8;

import java8.model.Team;
import java8.repository.TeamRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Test {

    private static TeamRepository teamRepository;

    static {
        teamRepository = new TeamRepository();
    }

    public static void main(String[] args) throws IOException {
        boolean isRan = true;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (isRan) {
            printCommands();
            int command;
            try {
                command = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException e) {
                command = -1;
            }
            switch (command) {
                case 0:
                    isRan = false;
                    break;
                case 1:
                    System.out.println("please input coachName");
                    String coachName = reader.readLine();
                    List<Team> teamList = teamRepository.getByCoach(coachName);
                    System.out.println(!teamList.isEmpty() ? teamList : "teams are not exist");
                    break;
                case 2:
                    System.out.println("please input team name");
                    String name = reader.readLine();
                    Optional<Team> teamOptional = teamRepository.getByName(name);
                    System.out.println(teamOptional.isPresent() ? teamOptional.get() : "team is not exists");
                    break;
                case 3:
                    System.out.println("please input start param");
                    String startParam = reader.readLine();
                    List<String> footballerList = teamRepository.getFootballersNameByStartWith(startParam);
                    System.out.println(!footballerList.isEmpty() ? footballerList : "footballers are not exist");
                    break;
                case 4:
                    System.out.println("please input footballersCount,wonCupsCount");
                    String[] countParams = reader.readLine().split(",");
                    List<String> teamNamesList = teamRepository.getTeamNamesByFootballersSizeAndWonCupCount(Integer.parseInt(countParams[0]), Integer.parseInt(countParams[1]));
                    System.out.println(!teamNamesList.isEmpty() ? teamNamesList : "teams are not exist");
                    break;
                case 5:
                    System.out.println("please input wonCupsCount");
                    String wonCup = reader.readLine();
                    int teamsCount = teamRepository.countByGreaterThanEqualWonCupCupsCount(Integer.parseInt(wonCup));
                    System.out.println("found teams count: " + teamsCount);
                    break;
                case 6:
                    System.out.println("please input joinOperator,cupName for example(,/champions league)");
                    String[] joinParams = reader.readLine().split("/");
                    String teamNames = teamRepository.joinTeamNamesByJoinOperatorAndCupName(joinParams[0], joinParams[1]);
                    System.out.println(teamNames.equals("") ? "teams are not exist" : teamNames);
                    break;
                case 7:
                    System.out.println("please input wonCups for example (a,b,c)");
                    String[] wonCups = reader.readLine().split(",");
                    List<String> coachNamesList = teamRepository.getCoachNamesByWonCups(Arrays.asList(wonCups));
                    System.out.println(!coachNamesList.isEmpty() ? coachNamesList : "coaches are not exist");
                    break;
                default:
                    System.out.println("you input invalid command");
            }
        }
    }

    public static void printCommands() {
        System.out.println("please input 0 for exit");
        System.out.println("please input 1 see all Teams by coach name");
        System.out.println("please input 2 see Team by name");
        System.out.println("please input 3 see all footballers whose names are start with");
        System.out.println("please input 4 see all Team names by Footballers count and won cups count");
        System.out.println("please input 5 see Teams count by param which is greater than equal won cup count");
        System.out.println("please input 6 see joined team names by Join operator and cup name");
        System.out.println("please input 7 see coaches by won cups");
    }

}
