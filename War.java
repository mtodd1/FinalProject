/*Mckenna Todd
  CS 110
*/
/**
   The War class simulates a game of war. It includes methods for simulating a "battle", with 2 cards, as 
   well as a "war", with 4 more. It also includes methods to get the sizes of the hands, as well as the cards
   to be added to them from the battles, finding a face-down card, and getting the winner of a battle or war.
*/

//Imports the needed packages.
import java.util.ArrayList;
import javax.swing.JOptionPane;

//Creates the War class. 
public class War
{
   //Initializes constants to return for not finding a faceUp card, and which player won.
   private static final int NOT_FOUND = -1;
   private static final int P1_WINS = 1;
   private static final int P2_WINS = 2;
   private static final int TIE = 3;
   
   //Creates two ArrayLists to hold the cards currently on the field.
   private ArrayList<Card> cardsArray1;
   private ArrayList<Card> cardsArray2;
   private ArrayList<Card> leftovers1;
   private ArrayList<Card> leftovers2;
   
   //Creates the Deck for the game, as well as two CardPiles for each player.
   private Deck deck;
   private CardPile hand1;
   private CardPile hand2;
   
   //Creates two cards to hold the cards put onto the field.
   private Card card1;
   private Card card2;
   
   //Creates variables to hold the number of turns and which player won.
   private int turns;   
   private int playerWins;
   private int warWinner;
 
   /**
      This constructor creates a game of War. It first creates a new deck and two ArrayLists to
      hold the cards on the field. It then splits the deck in half and assigns one half to player
      1's hand, and the other to player 2. 
   */
   public War()
   {
      //Creates the deck and the ArrayLists to hold the cards on the field.
      deck = new Deck();
      cardsArray1 = new ArrayList<Card>();
      cardsArray2 = new ArrayList<Card>();
      
      //Gets the middle of the deck.
      int mid = ((deck.numCards())/2);
      
      //Shuffles the deck so the cards are randomly arranged. 
      deck.shuffle();
      
      //Calls the getHalf method to assign one half of the deck to each player's hand.
      hand1 = deck.getHalf(0, mid);
      hand2 = deck.getHalf(mid, deck.numCards());
      
      //Sets the number of turns to 0 and the winning player to 0.
      turns = 0;
      playerWins = 0;
      
   }
   
   /**
      The battle method simulates a battle of cards in the game of War. It first calls the flipTop
      method to remove a card from each hand, then adds them to the ArrayLists of cards on the field.
      It them compares them based on rank and adds them to the winning player's hand. If there is a 
      War, the cards are not added and are kept to compare in the War.
      @exception IndexOutOfBoundsException When there is an error with the indexes of the hands or 
                 the ArrayLists of cards on the field.
      @exception Exception If any critical error or otherwise should occur.
   */
   public void battle()
   {
      try
      {
         //"Flips" cards off of both hands if they have cards to do so with and adds them to the ArrayLists.
         if(hand1.numCards() != 0 || hand2.numCards() != 0)
         {
            //Increments the number of turns. 
            turns++;
            
            card1 = hand1.flipTop();
            card2 = hand2.flipTop();
            
            cardsArray1.add(card1);
            cardsArray2.add(card2);
            
            /*Compares the cards. If player 1 had the higher rank, adds both cards to their hands, and vice
              versa if player 2 had the highest, and then sets the playerWins variable accordingly. If there 
              is a tie, sets the playerWins variable to 3 to show that a war should happen.
            */
            if(card1.getRank() > card2.getRank())
            {
               hand1.addCard(0, card1);
               hand1.addCard(0, card2);
               playerWins = P1_WINS;
            }
            else if(card2.getRank() > card1.getRank())
            {
               hand2.addCard(0, card1);
               hand2.addCard(0, card2);
               playerWins = P2_WINS; 
            }
            else if(card1.getRank()==card2.getRank())
            {
               playerWins = TIE;
            }
         }
         
         //Checks the hand's cards. If either or both are zero, declares the winner of the overall game.
         if(hand1.numCards()==0 || hand2.numCards()==0)
         {
            getWarWinner();
         }
      }
      
      /*Catches an IndexOutOfBoundsException if an error should occur with the indexes
        of the hands or the cards on the field.
      */
      catch(IndexOutOfBoundsException e)
      {
         //If someone does not have any cards, calls the getWarWinner method to declare them the winner.
         if(hand1.numCards()==0 || hand2.numCards()==0)
         {
            getWarWinner();
         }
         //Otherwise, prints an error message using a JOptionPane message box.
         else
         {
            JOptionPane.showMessageDialog(null, "Index out of bounds.");
         }
      }
      //Catches any other critical errors to occur with the progam and exits.
      catch(Exception e)
      {
         JOptionPane.showMessageDialog(null, "Error with the program. Closing...");
         System.exit(0); 
      }
   }
   
   /**
      The war method simulates a "war" when the two player's cards have equal ranks. It
      first "flips" two more cards off of each hand, one face down, then compares the face-up
      cards; the player with the higher rank gets all the cards, including the ones that triggered
      the war. If there is another tie, sets playerWins to 3 to show that there is another war.
      @exception IndexOutOfBoundsException When there is an error with the indexes of the hands or 
                 the ArrayLists of cards on the field.
      @exception Exception If any critical error or otherwise should occur.
   */
   public void war()
   {
      try
      {
         //Increments the number of turns.
         turns++;
         
         //If the hands have cards available, "flips" two off of each hand, with two face-down, and adds them to the ArrayLists.
   		if(hand1.numCards() != 0 || hand2.numCards()	!=	0 && playerWins == TIE)
   		{
            //Flips the first two cards off and sets them face-down.
   			Card war1 =	hand1.flipTop();
   			Card war2 =	hand2.flipTop();
   			cardsArray1.add(war1);
   			cardsArray2.add(war2);
   			war1.setFaceUp(false);
   			war2.setFaceUp(false);
   			
            //Flips the second two cards off.
   			Card war3 =	hand1.flipTop();
   			Card war4 =	hand2.flipTop();
   			cardsArray1.add(war3);
   			cardsArray2.add(war4);
            
            /*Compares the ranks of the first cards flipped. If player 1's rank is higher, adds every card, including
              the ones from the first battle, to their hand, and vice versa for player 2, and sets the playerWins field
              accordingly. If there is a tie again, sets playerWins to 3.
            */
   			if(war3.getRank()	> war4.getRank())
   			{
               playerWins = P1_WINS;
   				for(int i =	0;	i < cardsArray1.size();	i++)
   				{
   					hand1.addCard(cardsArray1.get(i));
   				} 
   				for(int i =	0;	i < cardsArray2.size();	i++)
   				{
   					hand1.addCard(cardsArray2.get(i));
   				}
   			}
   			else if(war4.getRank() > war3.getRank())
   			{
               playerWins = P2_WINS;
   				for(int i =	0;	i < cardsArray1.size();	i++)
   				{
   					hand2.addCard(cardsArray1.get(i));
   				} 
   				for(int i =	0;	i < cardsArray2.size();	i++)
   				{
   					hand2.addCard(cardsArray2.get(i));
   				} 
   			}
   			else if(war3.getRank()==war4.getRank())
   			{ 
               playerWins = TIE;
   			}
   		}
      }
      
      /*Catches an IndexOutOfBoundsException in case an error should occur with the indexes
        of the hands or the cards on the fields.
      */
      catch(IndexOutOfBoundsException e)
      {
         //If someone does not have any cards, calls the getWarWinner method to declare them the winner.
         if(hand1.numCards()==0 || hand2.numCards()==0)
         {
            getWarWinner();
         }
         else
         {  
            JOptionPane.showMessageDialog(null, "Index out of bounds.");
         }
      }
      catch(Exception e)
      {
         JOptionPane.showMessageDialog(null, "Error with the program.");
      }
   }
   
   /**
      The getPlayerWins method returns an integer to represent which player won. If it is
      3, it means there was a tie.
      @return The integer representing which player won.
   */
   public int getPlayerWins()
   {
      return playerWins;
   }
   
   /**
      The getWarWinner method compares the number of cards in a player's hand. If either
      has 0, declares them the winner. If both are 0, there is a tie. The method then
      returns the number of the player who won, or 3 if there is a tie.
      @return The number of the player who won.
   */
   public int getWarWinner()
   {
      if(hand1.numCards()==0)
      {
         warWinner = P1_WINS;
         return warWinner;
      }
      else if(hand2.numCards()==0)
      {
         warWinner = P2_WINS;
         return warWinner;
      }
      else
      {
         warWinner = TIE;
         return warWinner;
      }
   }
   
   /**
      The clearSpoils method clears the cards from the ArrayLists representing
      the cards on the field.
   */
   public void clearSpoils()
   {
      cardsArray1.clear();
      cardsArray2.clear();
   }
   
   /**
      The clearHands method clears all the cards from both player's hands.
   */
   public void clearHands()
   {
      hand1.removeAll();
      hand2.removeAll();
   }
   
   /**
      The getSpoilsP1 method returns the cards belonging to player 1 that are on the field.
      @return The ArrayList of cards on the field belonging to player 1.
   */
   public ArrayList<Card> getSpoilsP1()
   {
      return cardsArray1;
   }
   
   /**
      The getSpoilsP2 method returns the cards belonging to player 2 that are on the field.
      @return The ArrayList of cards on the field belonging to player2.
   */
   public ArrayList<Card> getSpoilsP2()
   {
      return cardsArray2;
   }
   
   /**
      The getCardsP1 method returns the number of cards in player 1's hand.
      @return The number of cards in player 1's hand.
   */
   public int getCardsP1()
   {
      return hand1.numCards();
   }
   
   /**
      The getCardsP2 method returns the number of cards in player 2's hand.
      @return The number of cards in player 2's hand.
   */
   public int getCardsP2()
   {
      return hand2.numCards();
   }
   
   /**
      The findFaceUpCard method accepts an ArrayList of Card objects passed in
      as an argument. It then performs a selection search to find each face-down
      card in the ArrayList and returns an ArrayList of integers containing the
      index of each one.
      @return The ArrayList containing the indexes of each face-down card.
   */
   public int findFaceDownCard(ArrayList<Card> cards)
   { 
      //Iterates through each card to find the face-down ones.
      for(Card card : cards)
      {
         //Initializes variables for if the card is found as well as the current index.
         boolean found = false;
         int count = 0;
         
         //Creates a while loop to iterate while the card isn't found and the count in the ArrayList's bounds.
         while(!found && count < cards.size())
         {
            //If the card is face up, adds its index to the ArrayList and increments count.
            if(!card.getFaceUp())
            {
               found = true;
               return count;
            }
            count++;
         }
      }
      return NOT_FOUND;   
   }
   
   /**
      The getTurns method returns the number of turns that have passed.
      @return The current number of turns.
   */
   public int getTurns()
   {
      return turns;
   }
   
}