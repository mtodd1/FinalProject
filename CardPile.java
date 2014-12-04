/* Mckenna Todd
   CS 110
*/
/**
   The CardPile class simply simulates a pile of cards. It includes methods for adding, setting, getting, and
   removing cards, as well as dividing the pile in half and "flipping" the top card off of the pile. The card at
   index 0 is considered to be the bottom card.
*/

//Imports the needed packages.
import java.util.ArrayList;
import java.util.List;

//Creates the CardPile class.
public class CardPile
{
   //Initializes an empty ArrayList of Card objects to hold all of the cards.
   private ArrayList<Card> cards;
   
   /**
      This constructor simply creates an empty CardPile.
   */
   public CardPile()
   {
      cards = new ArrayList<Card>();  
   }
   
   /**
      This copy constructor accepts another CardPile passed in as an argument.
      It then gets each card from it and copies them over to the new CardPile.
      @param other The CardPile to be copied.
   */
   public CardPile(CardPile other)
   {
      cards = new ArrayList<Card>();
      for(int i = 0; i <other.numCards(); i++)
      {
         cards.add(other.getCard(i));
      }
   }
   
   /**
      This constructor accepts an ArrayList of cards passed in as an argument.
      It then gets each card from it and copies them over to the new CardPile.
      @param other The ArrayList to be copied.
   */
   public CardPile(ArrayList<Card> other)
   {
      cards = new ArrayList<Card>();
      for(int i = 0; i < other.size(); i++)
      {
         cards.add(other.get(i));
      }
   }
   
   /**
      This constructor accepts an arbitrary number of Card objects passed in
      as an argument. It then adds them to the new CardPile.
      @param card The array of cards to be copied.
   */
   public CardPile(Card... card)
   {
      for(int i = 0; i< card.length; i++)
      {
         cards.add(card[i]);
      }
   }
   
   /**
      The numCards method returns the size of the CardPile.
      @return The size of the CardPile.
   */
   public int numCards()
   {
      return cards.size();
   }
   
   /**
      The addCard method accepts a Card object passed in as an argument.
      It then adds the Card to the end of the CardPile.
      @param card The Card object to be added.
   */
   public void addCard(Card card)
   {
      cards.add(card);  
   }
   
   /**
      The overloaded addCard method accepts an index and a Card object as an
      argument. It then adds the Card object at the specified index in the CardPile.
      @param index The index for the Card to be added at.
      @param card The Card object to be added.
   */
   public void addCard(int index, Card card)
   {
      cards.add(index, card);
   }
   
   /**
      The setCard method accepts an integer for an index and a 
      Card object passed in as an argument, and then sets the Card
      object at the specified index. If the index is out of the bounds
      of the CardPile, prints an error message saying so.
      @param index The index for the card to be set at.
      @param card The Card object to be set at the specified index.
   */
   public void setCard(int index, Card card)
   {
      try
      {
         cards.set(index, card);
      }
      catch(IndexOutOfBoundsException e)
      {
         System.out.println("Index out of bounds.");
      }
   }
   
   /**
      The removeCard method accepts a Card object passed in as 
      an argument. It then removes the Card from the CardPile.
      If it cannot find the card, prints an error message.
      @param card The Card object to be removed.
   */
   public void removeCard(Card card)
   {
      if(cards.contains(card))
      {
         cards.remove(card);
      }
      else
      {
         System.out.println("Card not found.");
      }
   }
   
   /**
      The getCard method accepts an integer passed in as an argument, then
      returns the card at that index. If the index is below zero or greater
      than the size of the CardPile, prints an error message and returns null.
      @param index The index of the card to be returned.
   */
   public Card getCard(int index)
   {
      try
      {
         return cards.get(index);
      }
      catch(IndexOutOfBoundsException e)
      {
         System.out.println("Index out of bounds.");
         return null;
      }
   }
   
   /**
      The removeAll method simply removes all of the cards from the pile.
   */
   public void removeAll()
   {
      cards.clear();
   }
   
   /**
      The getHalf method accepts two ints as arguments for a starting and 
      ending index. It then creates a subList using those ints, turns it into
      a CardPile, and returns it.
      @param from The index to start at.
      @param to The index to end at.
      @return The new part of the CardPile. 
   */
   public CardPile getHalf(int from, int to)
   {
      //Creates a subList and turns it into an ArrayList, and then a new CardPile.
      List<Card> list = cards.subList(from, to);
      ArrayList<Card> halfList = new ArrayList<Card>(list);
      CardPile half = new CardPile(halfList);
      return half;
   }

   /**
      The flipTop method simulates flipping a card off of the top of the CardPile.
      It gets the Card object at the end of the CardPile, then removes it from the
      CardPile and returns it.
      @return The Card object at the end of the CardPile.
   */
   public Card flipTop()
   {
      Card card = getCard(numCards()-1);
      removeCard(getCard(numCards()-1));
      return card;
      
   }
   
   
}