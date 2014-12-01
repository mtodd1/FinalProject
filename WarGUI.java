/**
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WarGUI extends JFrame
{
   private War game;
   private CardPanel deck1;
   private CardPanel deck2;
   private JPanel gamePanel;
   private JPanel titlePanel;
   private JButton battleButton;
   private JLabel turns;
   private JLabel victory;
   private JLabel title;
   
   public WarGUI()
   {
      setLayout(new BorderLayout(10, 10));
      War game = new War();
      
      titlePanel = new JPanel();
      title = new JLabel("War!");
      title.setFont(new Font("LUCIDA_CALLIGRAPHY", Font.ITALIC, 24));
      titlePanel.add(title);
      
      gamePanel = new JPanel(new BorderLayout(10, 10));
      turns = new JLabel("Turns: ");
      turns.setFont(new Font("LUCIDA", Font.ITALIC, 12));
      
      
      deck1 = new CardPanel();
      deck2 = new CardPanel();
      gamePanel.add(deck1, BorderLayout.WEST);
      gamePanel.add(deck2, BorderLayout.EAST);
      
      battleButton = new JButton("Battle!");
      battleButton.addActionListener(new ButtonListener());
      
      add(gamePanel, BorderLayout.CENTER);
      add(titlePanel, BorderLayout.NORTH);
      add(battleButton, BorderLayout.SOUTH);
      
   }
   
   private class ButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         
         CardPanel card1 = new CardPanel();
         CardPanel card2 = new CardPanel();
      }
   }
   private void disableAll()
   {
      battleButton.setEnabled(false);   
   }
}