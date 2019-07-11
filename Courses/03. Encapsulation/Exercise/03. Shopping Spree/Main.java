import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputPersons = scanner.nextLine().split(";");

        Map<String, Person> people = new HashMap<>();

        for (String inputPerson : inputPersons) {
            String[] split = inputPerson.split("=");
            try {
                Person person = new Person(split[0], Double.parseDouble(split[1]));
                people.put(split[0],person);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        String[] inputProducts = scanner.nextLine().split(";");

        Map<String, Product> products = new HashMap<>();

        for (String inputProduct : inputProducts) {
            String[] split = inputProduct.split("=");
            try {
                Product product = new Product(split[0],Double.parseDouble(split[1]));
                products.put(split[0],product);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        String buyOrEnd = scanner.nextLine();

        while (!"END".equalsIgnoreCase(buyOrEnd)){
            String[] split = buyOrEnd.split("\\s+");
            String person = split[0];
            String product = split[1];

            if(people.isEmpty()) return;
            people.get(person).buyProduct(products.get(product));
            buyOrEnd = scanner.nextLine();
        }

        for (Person value : people.values()) {
            System.out.println(value.toString());
        }

    }
}
