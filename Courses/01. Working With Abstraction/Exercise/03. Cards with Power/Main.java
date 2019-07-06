import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        String cmd = scanner.nextLine();
//        System.out.println(cmd + ":");
//
//        printEnum(cmd);

        String rank = scanner.nextLine();
        String suit = scanner.nextLine();

        Card card = new Card(rank,suit);
        System.out.println(card);
    }

    private static void printEnum(String type) {

        if ("Card Suits".equalsIgnoreCase(type)) {
            for (int i = 0; i < CardSuits.values().length; i++) {
                String name = CardSuits.values()[i].toString();
                int value = CardSuits.valueOf(name).getValue();

                System.out.println(String.format("Ordinal value: %d; Name value: %s", value, name));
            }
        }else if("Card Ranks".equalsIgnoreCase(type)){
            for (int i = 0; i < CardRank.values().length; i++) {
                String name = CardRank.values()[i].toString();
                int value = CardRank.valueOf(name).getValue();

                System.out.println(String.format("Ordinal value: %d; Name value: %s", value, name));

            }
        }
    }
}
