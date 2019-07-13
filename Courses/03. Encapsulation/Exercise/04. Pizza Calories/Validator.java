import java.util.Arrays;

public class Validator {
    public static void validatePizzaName(String name) {
        if (name == null
                || name.trim().isEmpty()
                || name.trim().length() < 1
                || name.trim().length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
    }

    public static void validateNumberOfToppings(int numberOfToppings) {
        if (numberOfToppings < 0 || numberOfToppings > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
    }

    public static void validateDoughWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
    }

    public static void validateFlourType(String flourType) {
        if(!"White".equals(flourType) && !"Wholegrain".equals(flourType)){
            throw new IllegalArgumentException("Invalid type of dough.");
        }

    }

    public static void validateToppingWeight(double weight, String name) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(name + " weight should be in the range [1..50].");
        }
    }

    public static void validateBakingTechnique(String bakingTechnique) {
        if(!"Crispy".equals(bakingTechnique)
        && !"Chewy".equals(bakingTechnique)
        && !"Homemade".equals(bakingTechnique)){
            throw  new IllegalArgumentException("Invalid type of dough.");
        }
    }

    public static void validateToppingType(String toppingType) {
        String[] table = {"Meat", "Veggies", "Cheese", "Sauce"};

        if(!Arrays.asList(table).contains(toppingType)){
            throw new IllegalArgumentException("Cannot place "+ toppingType +" on top of your pizza.");
        }
    }
}
