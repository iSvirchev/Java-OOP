import vehicle.Bus;
import vehicle.Car;
import vehicle.Truck;
import vehicle.Vehicle;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Vehicle> vehicles = new HashMap<>();

        String[] split = scanner.nextLine().split("\\s+");
        try {
            Vehicle car = new Car(Double.parseDouble(split[1]), Double.parseDouble(split[2]), Double.parseDouble(split[3]));
            vehicles.put("Car", car);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        split = scanner.nextLine().split("\\s+");
        try {
            Vehicle truck = new Truck(Double.parseDouble(split[1]), Double.parseDouble(split[2]), Double.parseDouble(split[3]));
            vehicles.put("Truck", truck);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        split = scanner.nextLine().split("\\s+");
        try {
            Vehicle bus = new Bus(Double.parseDouble(split[1]), Double.parseDouble(split[2]), Double.parseDouble(split[3]));
            vehicles.put("Bus", bus);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] elements = scanner.nextLine().split("\\s+");
            String action = elements[0];
            String vehicle = elements[1];
            Double value = Double.parseDouble(elements[2]);

            if ("Car".equals(vehicle)) {
                if ("Refuel".equals(action)) {
                    try {
                        vehicles.get("Car").refuel(value);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                } else{
                    try {
                        vehicles.get("Car").drive(value);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
            } else if ("Truck".equals(vehicle)) {
                if ("Refuel".equals(action)) {
                    try {
                        vehicles.get("Truck").refuel(value);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                } else{
                    try {
                        vehicles.get("Truck").drive(value);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
            } else {
                if ("Refuel".equals(action)) {
                    try {
                        vehicles.get("Bus").refuel(value);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                } else if("Drive".equals(action)){
                    try {
                        vehicles.get("Bus").driveFull(value);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }else{
                    try {
                        vehicles.get("Bus").drive(value);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }

            }

        }

        System.out.println(vehicles.get("Car").toString());
        System.out.println(vehicles.get("Truck").toString());
        System.out.println(vehicles.get("Bus").toString());
    }


}
