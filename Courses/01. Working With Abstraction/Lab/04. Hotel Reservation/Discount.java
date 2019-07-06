public enum Discount {
    VIP(0.2),
    SECONDVISIT(0.1),
    NONE(0);

    private double discountPercent;

    Discount(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }
}
