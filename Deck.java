/**

*/
import java.util.ArrayList;
import java.util.Random;
public class Deck extends CardPile
{
   private ArrayList<Card> half1;
   private ArrayList<Card> half2;
   
   public Deck()
   {
      for(int i = 1; i <= Card.DIAMONDS; i++)
      {
         for(int j = 1; j <= Card.KING; j++)
         {
            Card card = new Card(i, j);
            System.out.println(card);
            addCard(card);
         } 
      } 
   }
   
   
   public void shuffle()
   {
      Random random = new Random();
      int rand;
      for(int i = 0; i < numCards()-1; i++)
      {
          rand = random.nextInt(numCards()-i) + i;
          
          Card tempCard = getCard(rand);
          setCard(rand, getCard(i));
          setCard(i, tempCard);
      
      }
   
   }
}