import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String cmd = scanner.nextLine();

        System.out.println(cmd + ":");

        for (int i = 0; i < CardSuits.values().length; i++) {
            String name = CardSuits.values()[i].toString();
            int value = CardSuits.valueOf(name).getValue();

            System.out.println(String.format("Ordinal value: %d; Name value: %s",value,name));

        }
    }
}
