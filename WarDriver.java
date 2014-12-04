/*Mckenna Todd
  CS 110
*/
/**
   The WarDriver class creates the frame to hold and display an instance of the WarGUI class.
*/

//Imports the needed packages.
import javax.swing.*;

//Creates the WarDriver class.
public class WarDriver
{
   //Creates the main method for the WarDriver class.
   public static void main(String [] args)
   {
      //Creates a new JFrame for the instance of the WarGUI class.
      JFrame frame = new WarGUI();
      
      //Sets it so that the program will close when the exit button is pressed.
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      //Sets its size, then packs the GUI together and sets it so that it is visible.
      frame.setSize(1000, 400);
      frame.validate();
      frame.setVisible(true);
   }
}