/*Mckenna Todd
  CS 110
*/
/**
   The War class simulates a game of war. It includes methods for simulating a "battle", with 2 cards, as 
   well as a "war", with 4 more. It also includes methods to get the sizes of the hands, as well as the cards
   to be added to them from the battles, finding a face-down card, and getting the winner of a battle or war.
*/

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class War
{
   private static final int NOT_FOUND = -1;
   private static final int P1_WINS = 1;
   private static final int P2_WINS = 2;
   private static final int P3_WINS = 3;
   
   
   private ArrayList<Card> cardsArray1;
   private ArrayList<Card> cardsArray2;
   private Deck deck;
   private CardPile hand1;
   private CardPile hand2;
   
   private Card card1;
   private Card card2;
   
   private int turns; 
   
   private int playerWins;
 
   public War()
   {
      deck = new Deck();
      cardsArray1 = new ArrayList<Card>();
      cardsArray2 = new ArrayList<Card>();
      int mid = (deck.numCards())/2;
      
      deck.shuffle();
      hand1 = deck.getHalf(0, mid);
      hand2 = deck.getHalf(mid, deck.numCards()-1);
      
      
      
      
      turns = 0;
   }
   
   public void battle()
   {
      try
      {
         if(hand1.numCards() != 0 || hand2.numCards() != 0)
         {
            card1 = hand1.flipTop();
            card2 = hand2.flipTop();
            
            cardsArray1.add(card1);
            cardsArray2.add(card2);
            
            if(card1.getRank() > card2.getRank())
            {
               hand1.addCard(0, card1);
               hand1.addCard(0, card2);
               playerWins = 1;
               
            }
            else if(card2.getRank() > card1.getRank())
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
         
         turns++;
      }
      catch(IndexOutOfBoundsException e)
      {
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
      catch(IndexOutOfBoundsException e)
      {
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
   
   public int getPlayerWins()
   {
      return playerWins;
   }
   public int getWarWinner()
   {
      if(hand1.numCards() == 0)
      {
         
         playerWins = 1;
         return playerWins; 
          
      }
      else if(hand2.numCards() == 0)
      {
         playerWins = 2;
         return playerWins;
         
      }
      else
      {
         playerWins = 3;
         return playerWins;
      }
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