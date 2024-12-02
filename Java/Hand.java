import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public int getTotalValue() {
        int totalValue = 0;
        int aceCounter = 0;

        for(Card card: cards) {
            totalValue += card.getValue();
            if(card.getRank().equals("Christmas Miracle")) {
                aceCounter++;
            }
        }

        while(aceCounter > 0 && totalValue > 21) {
            totalValue -= 10;
            aceCounter--;
        }
        return totalValue;
    }

    public void printHand() {
        for(Card card: cards) {
            System.out.println(card);
        }
    }

    public boolean isBlackJack() {
        return cards.size() == 2 && getTotalValue() == 21;
    }

}