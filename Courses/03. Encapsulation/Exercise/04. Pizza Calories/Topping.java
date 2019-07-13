public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        Validator.validateToppingType(toppingType);
        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        Validator.validateToppingWeight(weight, this.getToppingType());
        this.weight = weight;
    }

    private String getToppingType() {
        return this.toppingType;
    }

    public double calculateCalories() {
        double calories = this.weight * 2;

        if ("Meat".equals(this.toppingType)) calories *= 1.2;
        else if ("Veggies".equals(this.toppingType)) calories *= 0.8;
        else if ("Cheese".equals(this.toppingType)) calories *= 1.1;
        else if ("Sauce".equals(this.toppingType)) calories *= 0.9;

        return calories;
    }
}
