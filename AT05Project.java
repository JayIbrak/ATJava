import java.util.Random;
public class AT05Project
{
    public static void main(String[] args) {
        Random random = new Random();

        Card card1 = new Card(Card.Suit.CLUBS, Card.Rank.FIVE);
        System.out.println("The following card should be the FIVE of CLUBS: " + card1.getFace());
        //Printing a given face
        System.out.println("10 random cards...");
        for(int i = 1; i<=10; i++)
        {
            Card randomCard = new Card();
            System.out.println(randomCard.getFace());
        }
        //Looping through random cards. Using default constructor here when looping(The default constructor did not work when I tried printing a face--ask Mr Eng)

    }
}

class Card
{
    public enum Suit{HEARTS, CLUBS, SPADES, DIAMONDS}
    public enum Rank{TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE}

    private Suit suit;
    private Rank rank;

    private static final char HEARTS_CHAR = '\u2660';
    private static final char CLUBS_CHAR = '\u2660';
    private static final char SPADES_CHAR = '\u2660';
    private static final char DIAMONDS_CHAR = '\u2660';
    //all just initializing for the class

    public Card()
    {
        Random random = new Random();
        int randomSuit = random.nextInt(4);
        if(randomSuit == 0)
        {
            suit = Suit.HEARTS;
        }
        else if(randomSuit == 1)
        {
            suit = Suit.CLUBS;
        }
        else if(randomSuit == 2)
        {
            suit = Suit.SPADES;
        }
         else if(randomSuit == 3)
        {
            suit = Suit.DIAMONDS;
        }

        int randomRank = random.nextInt(13);
        if(randomRank == 0)
        {
            rank = Rank.TWO;
        }
        else if(randomRank == 1)
        {
            rank = Rank.THREE;
        }
        else if(randomRank == 2)
        {
            rank = Rank.FOUR;
        }
        else if(randomRank == 3)
        {
            rank = Rank.FIVE;
        }
        else if(randomRank == 4)
        {
            rank = Rank.SIX;
        }
        else if(randomRank == 5)
        {
            rank = Rank.SEVEN;
        }
        else if(randomRank == 6)
        {
            rank = Rank.EIGHT;
        }
        else if(randomRank == 7)
        {
            rank = Rank.NINE;
        }
        else if(randomRank == 8)
        {
            rank = Rank.TEN;
        }
        else if(randomRank == 9)
        {
            rank = Rank.JACK;
        }
        else if(randomRank == 10)
        {
            rank = Rank.QUEEN;
        }
        else if(randomRank == 11)
        {
            rank = Rank.KING;
        }
        else if(randomRank == 12)
        {
            rank = Rank.ACE;
        }
        //assigning random values to the ranks and suits
    }
    public Card(Suit suitType, Rank rankType)
        {
            suit = suitType;
            rank = rankType;
        }
    
    public Suit getSuit()
    {
        return suit;
    }
    
    public Rank getRank()
    {
        return rank;
    }

    public String getFace()
    {
        char suitSymbol = '/';

        if(suit == Suit.HEARTS)
        {
            suitSymbol = '\u2661';
        }
        else if(suit == Suit.CLUBS)
        {
            suitSymbol = '\u2663';
        }
         else if(suit == Suit.SPADES)
        {
            suitSymbol = '\u2660';
        }
         else if(suit == Suit.DIAMONDS)
        {
            suitSymbol = '\u2662';
        }

        String rankSymbol = "";

        if(rank == Rank.TWO)
        {
            rankSymbol = "2";
        }
        else if(rank == Rank.THREE)
        {
            rankSymbol = "3";
        }
        else if(rank == Rank.FOUR)
        {
            rankSymbol = "4";
        }
        else if(rank == Rank.FIVE)
        {
            rankSymbol = "5";
        }
        else if(rank == Rank.SIX)
        {
            rankSymbol = "6";
        }
        else if(rank == Rank.SEVEN)
        {
            rankSymbol = "7";
        }
        else if(rank == Rank.EIGHT)
        {
            rankSymbol = "8";
        }
        else if(rank == Rank.NINE)
        {
            rankSymbol = "9";
        }
        else if(rank == Rank.TEN)
        {
            rankSymbol = "T";
        }
        else if(rank == Rank.JACK)
        {
            rankSymbol = "J";
        }
        else if(rank == Rank.QUEEN)
        {
            rankSymbol = "Q";
        }
        else if(rank == Rank.KING)
        {
            rankSymbol = "K";
        }
        else if(rank == Rank.ACE)
        {
            rankSymbol = "A";
        }
        return suitSymbol + rankSymbol;
        //Constructors and methods...returning the symbols themselves
    }
 }  


