import java.util.Scanner;

public class BlackjackGame {
    private Deck deck;
    private Hand playerHand;
    private Hand dealerHand;

    public BlackjackGame() {
        deck = new Deck();
        playerHand = new Hand();
        dealerHand = new Hand();
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to a special edition of Black Jack. This is Christmas Themed!");
        System.out.println("Today we'll be spreading our Christmas Spirit with a game to 21!" + "\n");

        // starting deals for dealer and player
        playerHand.addCard(deck.drawCard());
        playerHand.addCard(deck.drawCard());
        dealerHand.addCard(deck.drawCard());
        dealerHand.addCard(deck.drawCard());

        System.out.println("Dealer's Hand:");
        dealerHand.printHand();
        System.out.println("Total Value: " + dealerHand.getTotalValue() + "\n");

        System.out.println("Your Hand");
        playerHand.printHand();
        System.out.println("Total Value: " + playerHand.getTotalValue() + "\n");

        // players turn
        while(true) {
            System.out.println("Enter 'hit' to draw another card or 'stay' to end your turn: ");
            String command = scanner.nextLine();
            if(command.equals("hit")) {
                playerHand.addCard(deck.drawCard());
                System.out.println("Your Hand:");
                playerHand.printHand();
                System.out.println("Total Value: " + playerHand.getTotalValue() + "\n");

                if(playerHand.getTotalValue() > 21) {
                    System.out.println("You bust! The House wins.");
                    return;
                }
            } else if(command.equals("stay")) {
                break;
            }
        }

        //dealers turn
        while(dealerHand.getTotalValue() < 17) {
            dealerHand.addCard(deck.drawCard());
        }
        
        System.out.println("Dealer's Hand:");
        dealerHand.printHand();
        System.out.println("Total Value: " + dealerHand.getTotalValue() + "\n");

        // winner 
        int playerTotal = playerHand.getTotalValue();
        int dealerTotal = dealerHand.getTotalValue();

        if(dealerTotal > 21 || playerTotal > dealerTotal) {
            System.out.println("You win. Merry Christmas!");
        } else if(playerTotal < dealerTotal) {
            System.out.println("You lose. Better luck next Christmas c:");
        } else {
            System.out.println("Its a tie. Have a Merry Christmas!");
        }
    }
}