package wildFarm.animal;

import wildFarm.food.Food;

import java.text.DecimalFormat;

public class Cat extends Feline {
    private String breed;

    public Cat(String animalName, String animalType, Double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public void eat(Food food) {
        super.setFoodEaten(super.getFoodEaten() + food.getQuantity());
    }

    @Override
    public String toString() { // Cat[Gray, Persian, 1.1, Home, 4]
        DecimalFormat df = new DecimalFormat("0.#####");
        return String.format("%s[%s, %s, %s, %s, %d]",
                super.getClass().getSimpleName(),
                super.getAnimalName(),
                this.breed,
                df.format(super.getAnimalWeight()),
                super.getLivingRegion(),
                super.getFoodEaten()
                );
    }
}
