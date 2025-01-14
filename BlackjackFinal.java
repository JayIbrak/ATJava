
/*
 * Jahja Ibrakovic
 * 1/10/25
 * let's do this thing...
 */
import java.util.*;

//I'm going to import everything for this one due to the nature of this assignment I hope this syntax is alright
public class BlackjackFinal {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        boolean repeat = true;

        while (repeat) {
            playHand(in);
            System.out.println("Play another hand? (yes/no)");
            repeat = in.nextLine().equalsIgnoreCase("yes");
        }
        System.out.println("Thanks for playing!");

    }

    private static void playHand(Scanner in) {
        List<Card> playerHand = new ArrayList<>();
        List<Card> dealerHand = new ArrayList<>();

        playerHand.add(drawCard());
        playerHand.add(drawCard());
        dealerHand.add(drawCard());
        dealerHand.add(drawCard());

        System.out.println(
                "Dealer's visible card: " + dealerHand.get(0).getRank() + " of " + dealerHand.get(0).getSuit());
        System.out.println("Your Hand: " + playerHand.get(0).getRank() + " of " + playerHand.get(0).getSuit() + ", "
                + playerHand.get(1).getRank() + " of " + playerHand.get(1).getSuit());

        if (scoreCalculator(playerHand) == 21) {
            System.err.println("You got blackjack!! You win!!!");
            return;
        }

        boolean playerBusted = false;
        while (!playerBusted) {
            System.out.print("Would you like to hit or stand(hit/stand): ");
            String decision = in.nextLine();

            if (decision.equalsIgnoreCase("hit")) {
                playerHand.add(drawCard());
                System.out.print("Your hand: ");

                for (Card card : playerHand) {
                    System.out.print(card.fullCard() + ", ");
                }
                System.out.println();

                if (scoreCalculator(playerHand) > 21) {
                    System.out.println("You busted. Dealer wins.");
                    playerBusted = true; // End the loop if player busts
                    break;
                }
            } else if (decision.equalsIgnoreCase("stand")) {
                playerBusted = false; // End the loop if player stands
                break;
            }
        }

        if (!playerBusted) {
            System.out.print("Dealer's full hand: ");
            for (Card card : dealerHand) {
                System.out.println(card.fullCard() + ", ");
            }
            while (scoreCalculator(dealerHand) < 17) {
                dealerHand.add(drawCard());
                System.out.print("Dealer hits: ");
                for (Card card : dealerHand) {
                    System.out.print(card.fullCard() + ", ");
                }
            }

            int playerScore = scoreCalculator(playerHand);
            int dealerScore = scoreCalculator(dealerHand);

            System.out.println("Your Score: " + playerScore);
            System.out.println("Dealer Score: " + dealerScore);

            if (dealerScore > 21 || playerScore > dealerScore) {
                System.out.println("You win!!");
            } else if (dealerScore == playerScore) {
                System.out.println("It's a draw.");
            } else if (playerScore > 21 || playerScore < dealerScore) {
                System.out.println("You lose.");
            }
        }

    }

    private static int scoreCalculator(List<Card> hand)
    // We have not learned about Lists yet but I learned it a bit
    // ago and I think it could work here for efficiency's sake
    {
        int score = 0;
        int aceCount = 0;

        for (Card card : hand) {
            if (card.getRank().equals("A")) {
                score = score + 11;
                aceCount++;
            } else if (card.getRank().equals("J") || card.getRank().equals("K") || card.getRank().equals("Q")) {
                score = score + 10;
            } else {
                score = score + Integer.parseInt(card.getRank());
            }
            while (score > 21 && aceCount > 0) {
                score = score - 10;
                aceCount--;
            }
        }
        return score;
    }

    public static Card drawCard() {
        String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades", };
        String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "T", "A", "J", "K", "Q" };
        String rank = ranks[new Random().nextInt(ranks.length)];
        String suit = suits[new Random().nextInt(suits.length)];
        return new Card(rank, suit);
    }

    static class Card {
        public String suit;
        public String rank;

        public Card(String r, String s) {
            suit = s;
            rank = r;
        }

        public String getRank() {
            return rank;
        }

        public String getSuit() {
            return suit;
        }

        public String fullCard() {
            return rank + " of " + suit;
        }
    }
}

/*
 * This was a fun one! I achieved a functional game here but there are
 * definitely spots where I can go back and clean up the code, something I hope
 * to revisit!
 */