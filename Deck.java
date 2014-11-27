/**

*/

public class Deck extends CardPile
{
   
   
   public Deck()
   {
      for(int i = 0; i <= Card.DIAMONDS; i++)
      {
         for(int j = 0; j <= Card.KING; j++)
         {
            Card card = new Card(i, j);
            addCard(card);
         } 
      } 
   }
   
   public void divide()
   {
   
   }
   
   public void shuffle()
   {
   
   
   }
   


}