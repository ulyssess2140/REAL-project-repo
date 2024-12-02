public class Card {
    private String suit;
    private String rank;
    private int value;

    public Card (String suit, String rank, int value) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        return rank + " to " + suit;
    }
}