public class Main {

    public static void main(String[] args) {

        Pizza pizza = new Pizza("Bulgarian",2);
        Dough dough = new Dough("Tip500", "Crispy", 100);
        Topping topping1 = new Topping("Veggies", 50);
        Topping topping2 = new Topping("Cheese", 50);
        pizza.addTopping(topping1);
        pizza.addTopping(topping2);
        pizza.setDough(dough);

        System.out.println(pizza.getName());
        System.out.println(pizza.getOverallCalories());

    }
}
