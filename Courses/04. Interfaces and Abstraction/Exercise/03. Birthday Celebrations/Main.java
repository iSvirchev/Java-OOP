import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputOrEnd = scanner.nextLine();

        List<Birthable> birthables = new ArrayList<>();

        while (!"End".equals(inputOrEnd)){
            String[] split = inputOrEnd.split("\\s+");

            switch (split[0]) {
                case "Citizen":
                    Citizen citizen = new Citizen(split[1],Integer.parseInt(split[2]),split[3],split[4]);
                    birthables.add(citizen);
                    break;
                case "Pet":
                    Pet pet = new Pet(split[1],split[1]);
                    birthables.add(pet);
                    break;
                case "Robot":
                    break;
            }

            inputOrEnd = scanner.nextLine();
        }

        String birthYear = scanner.nextLine();

        for (Birthable birthable : birthables) {
            if(birthable.getBirthDate().endsWith(birthYear)){
                System.out.println(birthable.getBirthDate());
            }
        }

    }

}
