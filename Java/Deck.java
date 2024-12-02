import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        String[] suits = {"Cookies", "Candy Canes", "Presents", "Snowflakes"};
        String[] ranks = {"Elf", "Snowman", "Reindeer", "Angel", "Ornament", "Bell", "Star", "Wish", "List", "Jack Frost", "Mrs. Claus", "Santa Claus", "Christmas Miracle"};
        int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11};

        for(String suit: suits) {
            for(int i = 0; i < ranks.length; i++) {
                cards.add(new Card(suit, ranks[i], values[i]));
            }
        }

        Collections.shuffle(cards);
    }
    public Card drawCard() {
        return cards.remove(0);
    }
}