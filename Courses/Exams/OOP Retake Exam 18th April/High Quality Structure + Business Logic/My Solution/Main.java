import core.ManagerControllerImpl;
import core.interfaces.ManagerController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManagerController controller = new ManagerControllerImpl();

        String input = scanner.nextLine();

        while (!"Exit".equalsIgnoreCase(input)) {
            String[] split = input.split("\\s+");

            String print = "";
            switch (split[0]) {
                case "AddPlayer":
                    try {
                        print = controller.addPlayer(split[1], split[2]);
                    } catch (IllegalArgumentException e) {
                        print = e.getMessage();
                    }

                    break;
                case "AddCard":
                    try {
                        print = controller.addCard(split[1], split[2]);
                    } catch (IllegalArgumentException e) {
                        print = e.getMessage();
                    }

                    break;
                case "AddPlayerCard":
                    try {
                        print = controller.addPlayerCard(split[1], split[2]);
                    } catch (IllegalArgumentException e) {
                        print = e.getMessage();
                    }

                    break;
                case "Fight":
                    try {
                        print = controller.fight(split[1], split[2]);
                    } catch (IllegalArgumentException e) {
                        print = e.getMessage();
                    }

                    break;
                case "Report":
                    print = controller.report();
                    break;
            }

            System.out.println(print);


            input = scanner.nextLine();
        }

    }
}
