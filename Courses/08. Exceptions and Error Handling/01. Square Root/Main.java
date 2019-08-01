import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();

        try{
            DecimalFormat decimalFormat = new DecimalFormat("##.##");
            System.out.println(decimalFormat.format(Math.sqrt(Integer.parseInt(str))));
        }catch (NumberFormatException ex){
            System.out.println("Invalid number");
        }finally {
            System.out.println("Good bye");
        }

    }
}
