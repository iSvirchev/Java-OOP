import restaurant.Cake;

public class Main {

    public static void main(String[] args) {

        Cake cake = new Cake("Space Cake");

        System.out.println(cake.getName());
        System.out.println(cake.getPrice());
        System.out.println(cake.getGrams());

    }
}
