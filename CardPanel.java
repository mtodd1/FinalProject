/*Mckenna Todd
  CS 110
*/
/**
   The CardPanel class simulates a card icon for a GUI. It includes methods for setting and getting
   the front and the back of a card.
*/

//Imports the needed packages.
import javax.swing.*;
import java.awt.*;

//Creates the CardPanel class, which extends the JPanel class.
public class CardPanel extends JPanel
{
     /*Creates variables for the fronts and backs of the card, as well as
       a label to hold the card image itself.
     */
     ImageIcon back;
     ImageIcon front;
     JLabel card;
     
     /**
        This constructor sets the default image of the card to the back and
        adds the Label to the Panel the CardPanel is added to.
     */
     public CardPanel()
     { 
         back = new ImageIcon();
         card = new JLabel(back);
         add(card);
     }
     
     /**
        The setFront method accepts a Card object passed in as an argument. It then
        gets its rank and suit and puts them into a StringBuilder, which is then used to find
        the correct image to set the front of the card to. If the Card object is supposed to
        be facing down, sets the image to a card back instead.
        @param cardOther The Card object that needs an image.
     */
     public void setFront(Card cardOther)
     {
        
         StringBuilder suitString = new StringBuilder("");
         //Creates a switch statement to put the card's suit into the StringBuilder.
         switch(cardOther.getSuit())
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
         
         //Creates a switch statement to put the card's rank into a StringBuilder.
         switch(cardOther.getRank())
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
         
         //If the card is facing up, sets its image using the created StringBuilder.
         if(cardOther.getFaceUp())
         {
            suitString.insert(0, "cardPics\\");
            String imageString = suitString.toString() + ".jpg";
            front = new ImageIcon(imageString);
            card.setIcon(front);
         }
         //Otherwise, sets the image to a card back.
         else
         {
            setBack();
         }
         
     }
     
     /**
        The setBack method sets the image of the CardPanel to a card back.
     */
     public void setBack()
     {
         back = new ImageIcon("cardPics\\back.jpg");
         card.setIcon(back);
     }
     
     /**
        The getFront method returns the ImageIcon for the current front of the 
        CardPanel.
        @return The ImageIcon for the current front of the CardPanel.
     */
     public ImageIcon getFront()
     {
        return front;
     }
     
     /**
        The getBack method returns the ImageIcon for the current back of the 
        CardPanel.
        @return The ImageIcon for the current back of the CardPanel.
     */
     public ImageIcon getBack()
     {
        return back;
     }
     
     /**
        The setImage method sets the icon of the CardPanel to the ImageIcon passed
        in as an argument.
        @param image The ImageIcon that the CarPanel will be set to.
     */
     public void setImage(ImageIcon image)
     {
         card.setIcon(image);
     }
}