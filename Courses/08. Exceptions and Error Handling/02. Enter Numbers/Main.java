
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String startStr = scanner.nextLine();
        String endStr = scanner.nextLine();

        int start = 1;
        int end = 99;

        try {

            int parsedStart = Integer.parseInt(startStr);
            int parsedEnd = Integer.parseInt(endStr);

            if (start > parsedStart
                    || end < parsedEnd
                    || parsedStart >= parsedEnd) {
                throw new NumberFormatException();
            } else {
                start = parsedStart;
                end = parsedEnd;
            }
        } catch (NumberFormatException ex) {
            System.out.println("Invalid number");
            return;
        }

        printNumbers(start,end);
    }

    private static void printNumbers(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(i + " ");
        }
    }
}
