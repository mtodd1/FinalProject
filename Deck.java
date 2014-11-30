/* Mckenna Todd
   CS 110
*/
/**
   The Deck class extends the CardPile class and simulates a deck of playing cards. It has a default constructor
   to create a normal Deck of 52 cards, as well as a copy constructor. It also includes a method for randomly
   shuffling all of the cards.
*/

//Imports the needed packages.
import java.util.ArrayList;
import java.util.Random;

//Creates the Deck class, which extends the CardPile class.
public class Deck extends CardPile
{
   /**
      This constructor creates 52 playing cards, with ranks from Ace to King and suits from
      Spades to Diamonds, and then adds them to the Deck. 
   */
   public Deck()
   {
      //Creates two for loops to create the 52 cards.
      for(int i = 1; i <= Card.DIAMONDS; i++)
      {
         for(int j = 1; j <= Card.KING; j++)
         {
            //Adds the cards to the Deck.
            Card card = new Card(i, j);
            addCard(card);
         } 
      } 
   }
   
   /**
      This copy constructor accepts another Deck object as an argument. It then creates
      a card for each card in it, and adds them to the new Deck object.
      @param other The Deck object to be copied.
   */
   public Deck(Deck other)
   {
      //Cycles through each card in the other Deck.
      for(int i = 0; i < other.numCards(); i++)
      {
         //Copies the card at the current index in the other Deck and adds it to the new Deck.
         Card card = new Card(other.getCard(i).getSuit(), other.getCard(i).getRank());
         addCard(card);
      }
   }
   
   /**
      The shuffle method randomly shuffles all of the cards in the Deck.
   */
   public void shuffle()
   {
      //Initializes a new Random object and an int to hold the number generated.
      Random random = new Random();
      int rand;
      
      //Creates a for loop to iterate through every card in the Deck. 
      for(int i = 0; i < numCards()-1; i++)
      {
          //Generates a random number from 0 to the number of cards in the Deck.
          rand = random.nextInt(numCards()-i) + i;
            
          //Pulls a random card from the deck.
          Card tempCard = getCard(rand);
          /*Sets the card at index i to a random index in the deck, then sets the 
            random card from before to index i to fill the gap.
          */
          setCard(rand, getCard(i));
          setCard(i, tempCard);
      }
   }
}