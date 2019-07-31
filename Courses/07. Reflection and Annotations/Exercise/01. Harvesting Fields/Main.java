import harvestingFields.RichSoilLand;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Class richSoilLand = RichSoilLand.class;

        String cmdOrHarvest = scanner.nextLine();

        while (!"HARVEST".equals(cmdOrHarvest)) {
            switch (cmdOrHarvest){
                case "private":
                    Arrays.stream(richSoilLand.getDeclaredFields())
                            .filter(f -> Modifier.isPrivate(f.getModifiers()))
                            .forEach(f -> System.out.println(String.format("%s %s %s",Modifier.toString(f.getModifiers()),f.getType().getSimpleName(),f.getName())));
                    break;
                case "protected":
                    Arrays.stream(richSoilLand.getDeclaredFields())
                            .filter(f -> Modifier.isProtected(f.getModifiers()))
                            .forEach(f -> System.out.println(String.format("%s %s %s",Modifier.toString(f.getModifiers()),f.getType().getSimpleName(),f.getName())));
                    break;
                case "public":
                    Arrays.stream(richSoilLand.getDeclaredFields())
                            .filter(f -> Modifier.isPublic(f.getModifiers()))
                            .forEach(f -> System.out.println(String.format("%s %s %s",Modifier.toString(f.getModifiers()),f.getType().getSimpleName(),f.getName())));
                    break;
               default:
                   Arrays.stream(richSoilLand.getDeclaredFields())
                           .forEach(f -> System.out.println(String.format("%s %s %s",Modifier.toString(f.getModifiers()),f.getType().getSimpleName(),f.getName())));
                   break;
            }

            cmdOrHarvest = scanner.nextLine();
        }
    }
}
