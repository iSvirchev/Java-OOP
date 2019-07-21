package vehicle;

import java.text.DecimalFormat;

public class Vehicle {
    private Double fuelQuantity;
    private Double fuelConsumption; //litres per km
    private Double tankCapacity;

    protected Vehicle(Double fuelQuantity, Double fuelConsumption, Double extraConsumption, Double tankCapacity) {
        setTankCapacity(tankCapacity);
        setFuelConsumption(fuelConsumption, extraConsumption);
        setFuelQuantity(fuelQuantity,0.0);
    }

    private Double getTankCapacity() {
        return tankCapacity;
    }

    protected void setTankCapacity(Double tankCapacity) {
        if (tankCapacity <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }

        this.tankCapacity = tankCapacity;
    }

    public void drive(Double km) {
        Double fuelNeeded = km * getFuelConsumption();

        if (fuelNeeded <= getFuelQuantity()) {
            DecimalFormat df = new DecimalFormat("0.##");
            System.out.println(String.format("%s travelled %s km", getClass().getSimpleName(), df.format(km)));
            setFuelQuantity(getFuelQuantity() - fuelNeeded,0.0);
        } else {
            System.out.println(getClass().getSimpleName() + " needs refueling");
        }
    }

    public void driveFull(Double km){
        this.drive(km);
    }

    public void refuel(Double liters){}

    protected Double getFuelQuantity() {
        return this.fuelQuantity;
    }

    protected void setFuelQuantity(Double fuelQuantity, Double litres) {
        if (this.fuelQuantity != null) {
            if (litres + getFuelQuantity() > getTankCapacity()) {
                throw new IllegalArgumentException("Cannot fit fuel in tank");
            }
        }
        this.fuelQuantity = fuelQuantity + litres;
    }

    protected Double getFuelConsumption() {
        return this.fuelConsumption;
    }

    protected void setFuelConsumption(Double fuelConsumption, Double extraConsumption) {
        this.fuelConsumption = fuelConsumption + extraConsumption;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", getClass().getSimpleName(), getFuelQuantity());
    }
}
