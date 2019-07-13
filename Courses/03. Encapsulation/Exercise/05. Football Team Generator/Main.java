import football.Player;
import football.Team;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Team> teams = new HashMap<>();
        String cmdOrEnd = scanner.nextLine();

        while (!"END".equalsIgnoreCase(cmdOrEnd)) {
            String[] split = cmdOrEnd.split(";");
            String cmd = split[0];
            String teamName = split[1];

            if ("Team".equalsIgnoreCase(cmd)) {
                try{
                    Team team = new Team(teamName);
                    teams.put(teamName, team);
                }catch (IllegalArgumentException e ){
                    System.out.println(e.getMessage());
                }
            } else if ("Add".equalsIgnoreCase(cmd)) {

                if (!teams.containsKey(teamName)) {
                    System.out.println("Team " + teamName + " does not exist.");
                }else{
                    String pName = split[2];
                    int s1 = Integer.parseInt(split[3]);
                    int s2 = Integer.parseInt(split[4]);
                    int s3 = Integer.parseInt(split[5]);
                    int s4 = Integer.parseInt(split[6]);
                    int s5 = Integer.parseInt(split[7]);

                    try {
                        Player player = new Player(pName, s1, s2, s3, s4, s5);
                        teams.get(teamName).addPlayer(player);
                    }catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                }
            } else if("Remove".equalsIgnoreCase(cmd)){
                if (!teams.containsKey(teamName)) {
                    System.out.println("Team " + teamName + " does not exist.");
                }else{
                    String pName = split[2];
                    try{
                        teams.get(teamName).removePlayer(pName);
                    }catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                }
            }else if("Rating".equalsIgnoreCase(cmd)){
                if (!teams.containsKey(teamName)) {
                    System.out.println("Team " + teamName + " does not exist.");
                }else {
                    System.out.println(String.format("%s - %d", teamName, Math.round(teams.get(teamName).getRating())));
                }
            }


            cmdOrEnd = scanner.nextLine();
        }
    }
}
