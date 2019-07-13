import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.next();
        String pizzaName = scanner.next();
        int nToppings = scanner.nextInt();
        scanner.nextLine();
        scanner.next();

        String doughtName = scanner.next();
        String doughType = scanner.next();
        double doughWeight = scanner.nextDouble();
        scanner.nextLine();

        Pizza pizza = new Pizza();
        Dough dough = new Dough();

        try {
            pizza = new Pizza(pizzaName, nToppings);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        try {
            dough = new Dough(doughtName, doughType, doughWeight);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        pizza.setDough(dough);

        String end = scanner.nextLine();

        while (!"END".equalsIgnoreCase(end)) {
            String[] split = end.split("\\s+");
            String name = split[1];
            double weight = Double.parseDouble(split[2]);

            try{
                Topping topping = new Topping(name,weight);
                pizza.addTopping(topping);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                return;
            }

            end = scanner.nextLine();
        }

        System.out.println(pizza.toString());
    }
}
