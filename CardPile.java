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
   
   public CardPile(ArrayList<Card> other)
   {
      cards = new ArrayList<Card>();
      for(int i = 0; i <other.size(); i++)
      {
         cards.add(other.get(i));
      }
   }
   
   public CardPile(Card... card)
   {
      int count = 0;
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
   
   public void addCard(Card card)
   {
      cards.add(card);  
   }
   
   public void addCard(int index, Card card)
   {
      cards.add(index, card);
   }
   
   public void addCard(int index, Card... card)
   {
      for(int i = 0; i < card.length; i++)
      {
         cards.add(index, card[i]);
      }
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
      if(index > 0 || index < cards.size())
      {
         cards.set(index, card);
      }
      else
      {
         System.out.println("Index out of bounds.");
      }
   }
   
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
      if(index > 0 || index < cards.size())
      {
         return cards.get(index);
      }
      else
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
   
   public CardPile getHalf(int to, int from)
   {
      List<Card> list = cards.subList(to, from);
      ArrayList<Card> halfList = new ArrayList<Card>(list);
      CardPile half = new CardPile(halfList);
      return half;
   }

   public Card flipTop()
   {
      Card card = getCard(numCards()-1);
      removeCard(getCard(numCards()-1));
      return card;
      
   }
   
   
}