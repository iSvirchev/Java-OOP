package solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart;

public class Main {
    public static void main(String[] args) {
        Cart cart = new Cart();
        cart.add(new OrderItem("asd2s",20));
        Order order = new OnlineOrder(cart,"someemail@email.com");

        System.out.println(order.getTotalAmount());
    }
}
