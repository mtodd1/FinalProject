/* Mckenna Todd
   CS 110
*/

/**
   The Card class simulates a playing card, which can be assigned a rank and a suit; however, the card cannot be changed once
   initialized. The class includes methods for getting either the suit or rank of a card, as well as for comparing two cards.
*/

//Creates the Card class
public class Card
{
   public static final int SPADES = 1, ACE = 1; //Initalizes constants for the Spades suit and Ace,
   public static final int CLUBS = 2; //the Clubs suit,
   public static final int HEARTS = 3; //the Hearts suit,
   public static final int DIAMONDS = 4; //the Diamonds suit,
   public static final int JACK = 11; //the Jack card,
   public static final int QUEEN = 12;//the Queen card,
   public static final int KING = 13;//and finally the King card
   
   //Creates variables to hold the suit and rank of a card 
   private int suit;
   private int rank;
   
   /**
      This constructor sets the card's suit and rank to the integer values
      passed in as arguments.
      @param suit The card's suit.
      @param rank The card's rank.
   */ 
   public Card(int suit, int rank)
   {
      this.suit = suit;
      this.rank = rank;
   }
   
   /**
      The getSuit method returns the value held in the object's 
      suit field.
      @return The value the suit variable contains.
   */
   public int getSuit()
   {
      return suit;
   }
   
   /**
      The getRank method returns the value held in the object's
      rank field.
      @return The value the rank variable contains.
   */
   public int getRank()
   {
      return rank;
   }
   
   /**
      The toString method gets the current state of the Card object
      and returns it as a string.
      @return The Card object's current state.
   */
   public String toString()
   {
      //Initializes constants for the names of the cards and suits.
      final String SPADE_STR = "Spades";
      final String CLUB_STR = "Clubs";
      final String HEART_STR = "Hearts";
      final String DIAMOND_STR = "Diamonds";
      
      final String ACE_STR = "Ace";
      final String KING_STR = "King";
      final String QUEEN_STR = "Queen";  
      final String JACK_STR = "Jack";
      
      String suitName = ""; //Initializes variables to hold the suit name,
      String rankName = ""; //rank name,
      String str = ""; //and the string returned at the end
      
      //Creates a switch statement to assign the proper suit name to the suitName variable
      switch(suit)
      {
         case 1:
            suitName = SPADE_STR;
            break;
         case 2:
            suitName = CLUB_STR;
            break;
         case 3:
            suitName = HEART_STR;
            break;
         case 4:
            suitName = DIAMOND_STR;
            break;
      }
      
      //If the card is an Ace, Jack, Queen, or King, assigns it the proper name
      if((rank == ACE) || (rank >= JACK))
      {
         switch(rank)
         {
            case 1:
               rankName = ACE_STR;
               break;
            case 11:
               rankName = JACK_STR;
               break;
            case 12:
               rankName = QUEEN_STR;
               break;
            case 13:
               rankName = KING_STR;
               break;
         }
         str = "\nRank: " + rankName + "\nSuit: " + suitName;
      }
      
      //Otherwise, keeps the rank as a number
      else
      {
         str = "\nRank: " + rank + "\nSuit: " + suitName;
      }
      
      //Returns the string containing the object's state
      return str;
   }
   
   /**
      The equals method accepts a Card object passed in as an argument 
      and compares the two objects' suits and ranks. If they are equal,
      it returns true. Otherwise, it returns false.
      @return Whether or not the two objects are equal.
   */
   public boolean equals(Card otherCard)
   {
      if (rank == otherCard.rank)
         return true;
      return false;
   }
   
   
   
   




}