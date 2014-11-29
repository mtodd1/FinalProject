/**
*/

public class Game
{
   public static void main(String [] args)
   {
      Deck deck = new Deck();
      int mid = deck.numCards()/2;
      
      deck.shuffle();
      CardPile hand1 = deck.getHalf(0, mid);
      CardPile hand2 = deck.getHalf(mid, deck.numCards()-1);
      
      int turns = 0;
      while(hand1.numCards() != 0 || hand2.numCards() != 0)
      {
         battle(hand1, hand2);
         turns++;  
      }
   }
   
   public static void battle(CardPile hand1, CardPile hand2)
   {
      Card card1 = hand1.flipTop();
      Card card2 = hand2.flipTop();
      if(card1.getRank() > card2.getRank())
      {
         hand1.addCard(0, card1);
         hand1.addCard(0, card2);
      }
      else if(card2.getRank() > card1.getRank())
      {
         hand2.addCard(0, card1);
         hand2.addCard(0, card2);
      }
      else
      {
         war();
      }
   }
   
   public static void war()
   {
   
   }
   
   public static void victory()
   {
   }
}