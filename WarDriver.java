/**
*/

import javax.swing.*;

public class WarDriver
{
   public static void main(String [] args)
   {
      JFrame frame = new WarGUI();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(800, 400);
      frame.validate();
      frame.setVisible(true);
   }
}