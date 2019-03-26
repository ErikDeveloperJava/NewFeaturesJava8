package java8;

import java8.model.Team;
import java8.repository.TeamRepository;
import java8.util.WriterFuncInterface;
import lombok.Cleanup;

import java.io.*;
import java.util.Optional;

public class Test {

    private static TeamRepository teamRepository;

    static {
        teamRepository = new TeamRepository();
    }

    //you can input coach name and file name until running application
    public static void main(String[] args) throws IOException {
        System.out.println("please input coach name and fileName(if you want to write result to file) for example (Alex,f.txt)");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = null;
        String inputText = reader.readLine();
        args = inputText.split(",");

        String outputText;
        //here used method reference from lambda expression
        WriterFuncInterface writerFuncInterface;

        String coachName = args[0];
        String fileName = args.length == 2 ? args[1] : null;
        Optional<Team> optionalTeam = teamRepository.getByCoach(coachName);
        // here check is exists Team Object in Optional
        if (optionalTeam.isPresent()) {
            Team team = optionalTeam.get();
            outputText = team.toString();
        } else {
            outputText = "Coach whose name is '" + coachName + "' does not exist";
        }
        //here checking Did fileName input?
        if (fileName != null) {
            writer = new BufferedWriter(new FileWriter(fileName));
            writerFuncInterface = writer::write;
            System.out.println("result was written to '" + fileName + "' this file");
        } else {
            writerFuncInterface = System.out::println;
        }
        writerFuncInterface.outputText(outputText);
        if(writer != null){
            writer.close();
        }
    }

}
