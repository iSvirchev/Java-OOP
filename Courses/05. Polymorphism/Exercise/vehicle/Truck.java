package vehicle;

public class Truck extends Vehicle {

    private static final Double EXTRA_CONSUMPTION = 1.6;

    public Truck(Double fuelQuantity, Double fuelConsumption, Double tankCapacity) {
        super(fuelQuantity, fuelConsumption, EXTRA_CONSUMPTION, tankCapacity); // extraConsumption is set to 1.6 for the car
    }

    @Override
    public void drive(Double km) {
        super.drive(km);
    }

    @Override
    public void driveFull(Double km) {
        super.driveFull(km);
    }

    @Override
    public void refuel(Double liters) {// rework
        if (liters <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        super.setFuelQuantity(super.getFuelQuantity(), (liters - (liters * 0.05)));
    }
}
