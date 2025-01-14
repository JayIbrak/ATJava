
/*
 * Jahja Ibrakovic
 * 1/10/25
 */

/*
 * import java.util.*;
 * public class BlackjackWorkingPage {
 * public static void main(String[] args) {
 * Scanner in = new Scanner(System.in);
 * boolean repeat = true;
 * 
 * while (repeat) {
 * playHand(in);
 * System.out.println("Play another hand? (yes/no)");
 * repeat = in.nextLine().equalsIgnoreCase("yes");
 * }
 * System.out.println("Thanks for playing!");
 * }
 * 
 * public static Card drawCard() {
 * String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades", };
 * String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "T", "A", "J",
 * "K", "Q" };
 * String rank = ranks[new Random().nextInt(ranks.length)];
 * String suit = suits[new Random().nextInt(suits.length)];
 * return new Card(rank, suit);
 * }
 * }
 * 
 * class Card {
 * public String suit;
 * public String rank;
 * 
 * public Card(String r, String s) {
 * suit = s;
 * rank = r;
 * }
 * 
 * public String getRank() {
 * return rank;
 * }
 * 
 * public String getSuit() {
 * return suit;
 * }
 * 
 * public String fullCard() {
 * return rank + "of" + suit;
 * }
 * }
 */
// Some experimenting here
// Keeping it just in case