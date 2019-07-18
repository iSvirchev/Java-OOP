import foodShortage.Buyer;
import foodShortage.Citizen;
import foodShortage.Person;
import foodShortage.Rebel;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nPeople = Integer.parseInt(scanner.nextLine());

        Map<String, Buyer> people = new HashMap<>();

        while (nPeople-- > 0) {
            String[] split = scanner.nextLine().split("\\s+");
            String name = split[0];
            if (split.length == 3) {
                Rebel rebel = new Rebel(name,Integer.parseInt(split[1]),split[2]);
                people.put(name,rebel);
            }else{
                Citizen citizen = new Citizen(name,Integer.parseInt(split[1]),split[2],split[3]);
                people.put(name,citizen);
            }
        }

        String inputOrEnd= scanner.nextLine();
        while (!"End".equals(inputOrEnd)){
            if(people.containsKey(inputOrEnd))people.get(inputOrEnd).buyFood();

            inputOrEnd = scanner.nextLine();
        }
        int totalFood = 0;

        for (Buyer person : people.values()) {
            totalFood += person.getFood();
        }

        System.out.println(totalFood);

    }
}
