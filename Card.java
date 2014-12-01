/* Mckenna Todd
   CS 110
*/

/**
   The Card class simulates a playing card, which can be assigned a rank and a suit; however, the card cannot be changed once
   initialized. The class includes methods for getting either the suit or rank of a card, as well as for comparing two cards.
*/

//Creates the Card class.
public class Card
{
   public static final int SPADES = 1, ACE = 1; //Initalizes constants for the Spades suit and Ace,
   public static final int CLUBS = 2; //the Clubs suit,
   public static final int HEARTS = 3; //the Hearts suit,
   public static final int DIAMONDS = 4; //the Diamonds suit,
   public static final int JACK = 11; //the Jack card,
   public static final int QUEEN = 12;//the Queen card,
   public static final int KING = 13;//and finally the King card.
   
   //Initializes constants for the names of the cards and suits.
   public static final String SPADE_STR = "Spades";
   public static final String CLUB_STR = "Clubs";
   public static final String HEART_STR = "Hearts";
   public static final String DIAMOND_STR = "Diamonds";
      
   public static final String ACE_STR = "Ace";
   public static final String KING_STR = "King";
   public static final String QUEEN_STR = "Queen";  
   public static final String JACK_STR = "Jack";
   
   //Creates variables to hold the suit and rank of a card, and if the card is facing up.
   private int suit;
   private int rank;
   private boolean faceUp;
   
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
   
   public Card(Card other)
   {
      this.suit = other.suit;
      this.rank = other.rank;
   } 
   
   /**
      The setSuit method takes a string passed in as an argument, then sets the suit
      field based on that string. If the string is not a valid suit, simply sets it to spades.
      @param s The string that the suit field will be set with.
   */
   public void setSuit(String s)
   {
      switch(s.toLowerCase())
      {
         case "spades":
            suit = SPADES;
            break;
         case "clubs":
            suit = CLUBS;
            break;
         case "hearts":
            suit = HEARTS;
            break;
         case "diamonds":
            suit = DIAMONDS;
            break;
         default:
            System.out.println("Invalid suit name.");
            suit = SPADES;
            break;
      }
   }
   
   /**
      This setSuit method takes an integer passed in as an argument and sets
      the suit field based on its value. If it is not a number from 1 to
      4, simply sets the suit field to 1, or spades.
      @param s The value that the suit field will be set with.
   */
   public void setSuit(int s)
   {
      switch(s)
      {
         case 1:
            suit = SPADES;
            break;
         case 2:
            suit = CLUBS;
            break;
         case 3:
            suit = HEARTS;
            break;
         case 4:
            suit = DIAMONDS;
            break;
         default:
            System.out.println("Invalid suit number.");
            suit = SPADES;
            break;
       }
   }
   
   /**
      The setRank method accepts an integer passed in as an argument, then
      sets the rank field based upon its value. If it is a number below 0 or
      over 13, simply sets it to 1, or an ace.
      @param r The value the rank field will be set with.
   */
   public void setRank(int r)
   {
      switch(r)
      {
         case 1:
            rank = ACE;
            break;
         case 2:
         case 3:
         case 4:
         case 5:
         case 6:
         case 7:
         case 8:
         case 9:
         case 10:
            rank = r;
            break;
         case 11:
            rank = JACK;
            break;
         case 12:
            rank = QUEEN;
            break;
         case 13:
            rank = KING;
            break;
         default:
            System.out.println("Invalid card number.");
            rank = ACE;
            break;
      }  
   }
   
   /**
      This setRank method accepts a string passed in as an argument, then converts
      it to an integer or looks at the card name it holds and sets the rank field 
      based on its value. If it is not a valid card rank, simply sets it to an ace.
      @param r The string that the rank field will be set with.
   */
   public void setRank(String r)
   {
      /*Parses the string to an int and sets the rank field to that value if it is 
        not under 0 or over 11.
      */
      int rNum = Integer.parseInt(r);
      if(rNum > 0 || rNum < 11)
      {
         setRank(rNum);
      }
      
      /*Otherwise, if it is a named card, looks at its name and sets the 
        rank field accordingly.
      */
      else
      {
         switch(r.toLowerCase())
         {
            case "jack":
               rank = JACK;
               break;
            case "queen":
               rank = QUEEN;
               break;
            case "king":
               rank = KING;
               break;
            case "ace":
               rank = ACE;
               break;
            default:
               System.out.println("Invalid rank name.");
               rank = ACE;
               break;
         }
      }
   }
   
   /**
      The setFaceUp method accepts a boolean as an argument and sets the
      faceUp field based on its value.
      @param f The boolean that the faceUp field will be set to.
   */
   public void setFaceUp(boolean f)
   {  
      faceUp = f;
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
      The getFaceUp method returns the boolean value held in the object's 
      faceUp field.
      @return The value the faceUp variable contains.
   */
   public boolean getFaceUp()
   {
      return faceUp;
   }
   
   /**
      The toString method gets the current state of the Card object
      and returns it as a string.
      @return The Card object's current state.
   */
   public String toString()
   {
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