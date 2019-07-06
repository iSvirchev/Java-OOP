public class Card {
    private String rank;
    private String suit;
    private int power;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
        setPower();
    }

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    public int getPower() {
        return power;
    }

    public void setPower() {
        this.power = CardRank.valueOf(this.rank).getValue() + CardSuits.valueOf(this.suit).getValue();
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d", getRank(),getSuit(),getPower());
    }
}
