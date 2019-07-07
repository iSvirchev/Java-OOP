public class Main {

    public static void main(String[] args) {
        RaceMotorcycle raceMotorcycle = new RaceMotorcycle(10,25);
        System.out.println(raceMotorcycle.getFuel());
        raceMotorcycle.drive(2);
        System.out.println(raceMotorcycle.getFuel());
        raceMotorcycle.drive(1);
        System.out.println(raceMotorcycle.getFuel());
    }
}
