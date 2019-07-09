import animals.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String cmdOrBeast = scanner.nextLine();

        List<Animal> animals = new ArrayList<>();

        while (!"Beast!".equals(cmdOrBeast)) {
            String classType = cmdOrBeast;
            String[] elements = scanner.nextLine().split("\\s+");
            String name = elements[0];
            int age = Integer.parseInt(elements[1]);
            String gender = elements[2];
            
            switch (classType) {
                case "Dog":
                    Dog dog = new Dog(name,age,gender);
                    animals.add(dog);
                    break;
                case "Cat":
                    Cat cat = new Cat(name,age,gender);
                    animals.add(cat);
                    break;
                case "Frog":
                    Frog frog = new Frog(name,age,gender);
                    animals.add(frog);
                    break;
                case "Kitten":
                    Kitten kitten = new Kitten(name,age);
                    animals.add(kitten);
                    break;
                case "Tomcat":
                    Tomcat tomcat = new Tomcat(name,age);
                    animals.add(tomcat);
                    break;

            }

            cmdOrBeast = scanner.nextLine();
        }


        for (Animal animal : animals) {
            System.out.println(animal.toString());
        }
    }
}
