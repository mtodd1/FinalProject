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
      int mid = (numCards()/2);
      half1 = super.getHalf(0, mid);
      half2 = super.getHalf(mid, numCards()-1);
   }
   
   public ArrayList<Card> getHalf1()
   {
      return half1;
   }
   
   public ArrayList<Card> getHalf2()
   {
      return half2;
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