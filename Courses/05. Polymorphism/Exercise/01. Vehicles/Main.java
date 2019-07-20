import vehicle.Car;
import vehicle.Truck;
import vehicle.Vehicle;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] split = scanner.nextLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(split[1]), Double.parseDouble(split[2]));

        split = scanner.nextLine().split("\\s+");
        Vehicle truck = new Truck(Double.parseDouble(split[1]), Double.parseDouble(split[2]));

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] elements = scanner.nextLine().split("\\s+");
            String cmd = elements[0];
            String vehicle = elements[1];
            double value = Double.parseDouble(elements[2]);

            if("Car".equals(vehicle)){
                if("Refuel".equals(cmd)){
                    car.refuel(value);
                }else{
                    car.drive(value);
                }
            }else{
                if("Refuel".equals(cmd)){
                    truck.refuel(value);
                }else{
                    truck.drive(value);
                }
            }
        }

        System.out.println(car.toString());
        System.out.println(truck.toString());
    }
}
