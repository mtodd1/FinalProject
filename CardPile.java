/**

*/
import java.util.ArrayList;
public class CardPile
{
   private ArrayList<Card> cards;
   
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



}