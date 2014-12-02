/**
*/

import java.util.ArrayList;
public class War
{
   private ArrayList<Card> cardsArray1;
   private ArrayList<Card> cardsArray2;
   private QueueReferenceBased cardQueue;
   private Deck deck;
   private CardPile hand1;
   private CardPile hand2;
   private int turns;
   private boolean victory;
   private boolean p1WinsWar;
   private int playerWins;
   private static final int NOT_FOUND = -1;
   private Card card1;
   private Card card2;
   
   public War()
   {
      deck = new Deck();
      cardsArray1 = new ArrayList<Card>();
      cardsArray2 = new ArrayList<Card>();
      cardQueue = new QueueReferenceBased();
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
         card1 = hand1.flipTop();
   		card2 = hand2.flipTop();
         
         cardsArray1.add(card1);
         cardsArray2.add(card2);
         
   		if(card1.getRank() >	card2.getRank())
   		{
   			hand1.addCard(0, card1);
   			hand1.addCard(0, card2);
            playerWins = 1;
            
   		}
   		else if(card2.getRank()	> card1.getRank())
   		{
   			hand2.addCard(0, card1);
   			hand2.addCard(0, card2);
            playerWins = 2;
            
   		}
   		else
   		{
            playerWins = 3;
   			war();
   		}
      }
      //getWarWinner();
      turns++;
   }
   
   public void war()
   {
      try
      {
         turns++;
   		if(hand1.numCards() != 0 || hand2.numCards()	!=	0)
   		{
   			Card war1 =	hand1.flipTop();
   			Card war2 =	hand2.flipTop();
   			cardsArray1.add(war1);
   			cardsArray2.add(war2);
   			war1.setFaceUp(false);
   			war2.setFaceUp(false);
   			
   			Card war3 =	hand1.flipTop();
   			Card war4 =	hand2.flipTop();
   			cardsArray1.add(war3);
   			cardsArray2.add(war4);
   			if(war3.getRank()	> war4.getRank())
   			{
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
   				for(int i =	0;	i < cardsArray1.size();	i++)
   				{
   					hand2.addCard(cardsArray1.get(i));
   				} 
   				for(int i =	0;	i < cardsArray2.size();	i++)
   				{
   					hand2.addCard(cardsArray2.get(i));
   				} 
   			}
   			else
   			{ 
   				war(); 
   			}
   		}
      }
      catch(IllegalArgumentException e)
      {
         if(hand1.numCards()==0 || hand2.numCards()==0)
         {
         }
      }
   }
   
   public void getWarWinner()
   {
      if(hand1.numCards() == 0)
      {
         victory = true;
         p1WinsWar = true; 
          
      }
      else if(hand2.numCards() == 0)
      {
         victory = true;
         
      }
   }
   
   public int getBattleWinner()
   {
      return playerWins;
   }
   public void clearCards()
   {
      cardsArray1.clear();
      cardsArray2.clear();
   }
   public ArrayList<Card> getSpoilsP1()
   {
      return cardsArray1;
   }
   public ArrayList<Card> getSpoilsP2()
   {
      return cardsArray2;
   }
   
   public int getCardsP1()
   {
      return hand1.numCards();
   }
   
   public int getCardsP2()
   {
      return hand2.numCards();
   }
   
   public int findFaceUpCard(ArrayList<Card> cards)
   {
      for(Card card : cards)
      {
         boolean found = false;
         int count = 0;
         while(!found && count < cards.size())
         {
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
   public int getTurns()
   {
      return turns;
   }
   
}