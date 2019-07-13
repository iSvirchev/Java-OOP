import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;
    private int numberOfToppings;

    public Pizza(String name, int numberOfToppings) {
        this.setName(name);
        this.setToppings(numberOfToppings);
        this.toppings = new ArrayList<>(this.numberOfToppings);
    }

    private void setName(String name) {
        Validator.validatePizzaName(name);
        this.name = name;
    }

    private void setToppings(int numberOfToppings) {
        Validator.validateNumberOfToppings(numberOfToppings);
        this.numberOfToppings = numberOfToppings;
    }

    public String getName(){
        return this.name;
    }


    public void setDough(Dough dough){
        this.dough = dough;
    }

    public void addTopping(Topping topping){
        if(this.toppings.size() < this.numberOfToppings){
            this.toppings.add(topping);
        }
    }

    public double getOverallCalories(){
        double calories = 0;

        for (Topping topping : this.toppings) {
            calories += topping.calculateCalories();
        }
        return dough.calculateCalories() + calories;
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f", this.getName(),
                this.getOverallCalories());
    }
}
