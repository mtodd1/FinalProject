/**
*/

import javax.swing.*;
import java.awt.*;

public class CardPanel extends JPanel
{
     ImageIcon back;
     ImageIcon front;
     JLabel card;
     
     public CardPanel()
     {
         back = new ImageIcon("back.jpg");
         card = new JLabel(back); 
     }
     
     public void getFront(Card card)
     {
         StringBuilder suitString = new StringBuilder("");
         switch(card.getSuit())
         {
            case Card.SPADES:
               suitString.append("s");
               break;
            case Card.CLUBS:
               suitString.append("c");
               break;
            case Card.HEARTS:
               suitString.append("h");
               break;
            case Card.DIAMONDS:
               suitString.append("d");
               break;
         }
         switch(card.getRank())
         {
            case Card.ACE:
               suitString.insert(0, "ace");
               break;
            case 2:
               suitString.insert(0, "2");
               break;
            case 3:
               suitString.insert(0, "3");
               break;
            case 4:
               suitString.insert(0, "4");
               break;
            case 5:
               suitString.insert(0, "5");
               break;
            case 6:
               suitString.insert(0, "6");
               break;
            case 7:
               suitString.insert(0, "7");
               break;
            case 8:
               suitString.insert(0, "8");
               break;
            case 9:
               suitString.insert(0, "9");
               break;
            case 10:
               suitString.insert(0, "10");
               break;
            case Card.JACK:
               suitString.insert(0, "jack");
               break;
            case Card.QUEEN:
               suitString.insert(0, "queen");
               break;
            case Card.KING:
               suitString.insert(0, "king");
               break;
         }           
         
         front = new ImageIcon(suitString + ".jpg");
     }
      
     public void setBack()
     {
         card.setIcon(back);   
     }
}