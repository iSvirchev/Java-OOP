package vehicle;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption; //litres per km
    private double extraConsumption;

    protected Vehicle(double fuelQuantity, double fuelConsumption, double extraConsumption) {
        this.extraConsumption = extraConsumption;
        setFuelConsumption(fuelConsumption,extraConsumption);
        setFuelQuantity(fuelQuantity);
    }

    public void drive(double km){
        double fuelNeeded = km * getFuelConsumption();

        if (fuelNeeded <= getFuelQuantity()) {
            DecimalFormat df = new DecimalFormat("0.##");
            System.out.println(String.format("%s travelled %s km",getClass().getSimpleName(),df.format(km)));
            setFuelQuantity(getFuelQuantity() - fuelNeeded);
        }else {
            System.out.println(getClass().getSimpleName() + " needs refueling");
        }
    };
    public abstract void refuel(double liters);

    protected double getFuelQuantity() {
        return this.fuelQuantity;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    protected double getFuelConsumption() {
        return this.fuelConsumption;
    }

    protected void setFuelConsumption(double fuelConsumption, double extraConsumption) {
        this.fuelConsumption = fuelConsumption + extraConsumption;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f",getClass().getSimpleName(),getFuelQuantity());
    }
}
