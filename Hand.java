/**

*/

import java.util.ArrayList;

public class Hand extends Deck
{
   private ArrayList<Card> hand;
    
   public Hand()
   {
      hand = new ArrayList<Card>(); 
   }  
   
   public Hand(ArrayList<Card> hand)
   {
      this.hand = hand;
   }

   public Hand(Card...card)
   {
      int count = 0;
      for(int i = 0; i< card.length; i++)
      {
         hand.add(card[i]);
      }
   }

   public void dealTop()
   {
      
      
   }
   
   public void battle()
   {
   
   }


}