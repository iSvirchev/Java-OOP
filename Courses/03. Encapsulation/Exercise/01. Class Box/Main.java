import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try{
            Box box = new Box(scanner.nextDouble(),scanner.nextDouble(),scanner.nextDouble());
            System.out.println(box.toString());
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }
}
