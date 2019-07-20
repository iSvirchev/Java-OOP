package vehicle;

public class Truck extends Vehicle {

    private static final double EXTRA_CONSUMPTION = 1.6;

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption, EXTRA_CONSUMPTION); // extraConsumption is set to 1.6 for the car
    }

    @Override
    public void drive(double km) {
        super.drive(km);
    }

    @Override
    public void refuel(double liters) {
        super.setFuelQuantity(super.getFuelQuantity() + (liters-(liters*0.05)));
    }
}
