package vehicle;

public class Bus extends Vehicle {

    public Bus(Double fuelQuantity, Double fuelConsumption, Double tankCapacity) {
        super(fuelQuantity, fuelConsumption, 0.0, tankCapacity);
    }

    @Override
    public void drive(Double km) {
        super.drive(km);
    }

    @Override
    public void driveFull(Double km) {
        super.setFuelConsumption(super.getFuelConsumption(), 1.4);
        super.drive(km);
    }

    @Override
    public void refuel(Double liters) {
        if(liters <= 0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        super.setFuelQuantity(super.getFuelQuantity(), liters);
    }
}
