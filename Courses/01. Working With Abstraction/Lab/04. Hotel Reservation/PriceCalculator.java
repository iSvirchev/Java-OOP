public class PriceCalculator {

    private double pricePerDay;
    private int nDays;
    private Season season;
    private Discount discount;

    public PriceCalculator(double pricePerDay, int nDays, Season season, Discount discount) {
        this.pricePerDay = pricePerDay;
        this.nDays = nDays;
        this.season = season;
        this.discount = discount;
    }

    public double calculate(){
       double total = calculateSeasons();
       double discountPercent = discount.getDiscountPercent();

       total -= total*discountPercent;

       return total;
    }

    private double calculateSeasons() {
        return season.getValue() * nDays * pricePerDay;
    }


}
