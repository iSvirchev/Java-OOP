import border.Citizen;
import border.Identifiable;
import border.Robot;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputOrEnd = scanner.nextLine();

        List<Identifiable> identifiables = new ArrayList<>();

        while (!"End".equalsIgnoreCase(inputOrEnd)){
            String[] split = inputOrEnd.split("\\s+");
            String nameOrModel = split[0];

            if(split.length==2){ // create robot
                Robot robot = new Robot(split[1],nameOrModel);
                identifiables.add(robot);
            }else { // create citizen
                Citizen citizen = new Citizen(nameOrModel,Integer.parseInt(split[1]),split[2]);
                identifiables.add(citizen);
            }

            inputOrEnd = scanner.nextLine();
        }

        String fake = scanner.nextLine();

        for (Identifiable identifiable : identifiables) {
            if(identifiable.getId().endsWith(fake)){
                System.out.println(identifiable.getId());
            }
        }
    }
}
