/**
*/
import java.util.ArrayList;
public class War
{
   private ArrayList<Card> cardsArray;
   private Deck deck;
   private CardPile hand1;
   private CardPile hand2;
   private int turns;
   private boolean victory;
   private boolean p1Wins;
   
   public War()
   {
      deck = new Deck();
      int mid = deck.numCards()/2;
      
      deck.shuffle();
      hand1 = deck.getHalf(0, mid);
      hand2 = deck.getHalf(mid, deck.numCards()-1);
      
      turns = 0;
      victory = false; 
   }
   
   public void battle()
   {
      if(hand1.numCards() != 0 || hand2.numCards() != 0)
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
   			war();
   		}
      }
      getWinner();
      turns++;
   }
   
   public void war()
   {
      if(hand1.numCards() != 0 || hand2.numCards() != 0)
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
               turns++;
            }   
         }
         else if(war4.getRank() > war3.getRank())
         {
            for(int i = 0; i < cardsArray.size(); i++)
            {
               hand2.addCard(cardsArray.get(i));
               turns++;
            }  
         }
         else
         {
            turns++;
            war(); 
         }
      }
      getWinner();
   }
   
   public void getWinner()
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
  
   public int getTurns()
   {
      return turns;
   }
   
}