/**
*/
import java.util.ArrayList;
public class Game
{
   private static boolean victory = false;
   private static boolean p1Wins = false;
   public static void main(String [] args)
   {
      ArrayList<Card> cardsArray = new ArrayList<Card>();
      Deck deck = new Deck();
      int mid = deck.numCards()/2;
      
      deck.shuffle();
      CardPile hand1 = deck.getHalf(0, mid);
      CardPile hand2 = deck.getHalf(mid, deck.numCards()-1);
      
      int turns = 0;
      while(!victory)
      {
         battle(hand1, hand2, cardsArray);
         turns++;  
      }
   }
   
   public static void battle(CardPile hand1, CardPile hand2, ArrayList<Card> cardsArray)
   {
      while(hand1.numCards() != 0 || hand2.numCards() != 0)
      {
         Card card1 = hand1.flipTop();
   		Card card2 = hand2.flipTop();
   		if(card1.getRank() >	card2.getRank())
   		{
   			hand1.addCard(0, card1);
   			hand1.addCard(0, card2);
   		}
   		else if(card2.getRank()	> card1.getRank())
   		{
   			hand2.addCard(0, card1);
   			hand2.addCard(0, card2);
   		}
   		else
   		{
   			cardsArray.add(card1);
   			cardsArray.add(card2);
   			war(hand1, hand2,	cardsArray);
   		}
      }
      getWinner(hand1, hand2);
   }
   
   public static void war(CardPile hand1, CardPile hand2, ArrayList<Card> cardsArray)
   {
      while(hand1.numCards() != 0 || hand2.numCards() != 0)
      {
         Card war1 = hand1.flipTop();
         Card war2 = hand2.flipTop();
         cardsArray.add(war1);
         cardsArray.add(war2);
         war1.setFaceUp(false);
         war2.setFaceUp(false);
         
         Card war3 = hand1.flipTop();
         Card war4 = hand2.flipTop();
         cardsArray.add(war3);
         cardsArray.add(war4);
         if(war3.getRank() > war4.getRank())
         {
            for(int i = 0; i < cardsArray.size(); i++)
            {
               hand1.addCard(cardsArray.get(i));
            }   
         }
         else if(war4.getRank() > war3.getRank())
         {
            for(int i = 0; i < cardsArray.size(); i++)
            {
               hand2.addCard(cardsArray.get(i));
            }  
         }
         else
         {
            war(hand1, hand2, cardsArray); 
         }
      }
      getWinner(hand1, hand2);
   }
   
   public static void getWinner(CardPile hand1, CardPile hand2)
   {
      if(hand1.numCards() == 0)
      {
         victory = true;
         p1Wins = true;  
      }
      else if(hand2.numCards() == 0)
      {
         victory = true;
      }
   }
  
}