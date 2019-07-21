import wildFarm.animal.*;
import wildFarm.food.Food;
import wildFarm.food.Meat;
import wildFarm.food.Vegetable;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!"End".equals(input)) {
            String[] split = input.split("\\s+");
            Animal animal = null;
            if (split.length == 4) {
                animal = createAnimal(split[0], split[1], Double.parseDouble(split[2]), split[3]);
            } else {
                animal = new Cat(split[1], split[0], Double.parseDouble(split[2]), split[3], split[4]);
            }
            Food food = null;
            split = scanner.nextLine().split("\\s+");
            if ("Meat".equals(split[0])) {
                food = new Meat(Integer.parseInt(split[1]));
            } else {
                food = new Vegetable(Integer.parseInt(split[1]));
            }

            animal.makeSound();
            animal.eat(food);

            input = scanner.nextLine();
        }

    }

    private static Animal createAnimal(String type, String name, double weight, String area) {
        Animal animal = null;

        if (type.equals("Mouse")) animal = new Mouse(name, type, weight, area);
        else if (type.equals("Tiger")) animal = new Tiger(name, type, weight, area);
        else if (type.equals("Zebra")) animal = new Zebra(name, type, weight, area);

        return animal;
    }
}