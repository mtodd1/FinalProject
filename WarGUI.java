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
   private JPanel p1Grid;
   private JPanel p2Grid;
   private JPanel gameGrid;
   private JPanel labelHolder;
   private JButton battleButton;
   private JLabel turns;
   private JLabel victory;
   private JLabel title;
   private JLabel p1Label;
   private JLabel p2Label;
   private CardPanel cardFace1;
   private CardPanel cardFace2;
   
   public WarGUI()
   {
      setLayout(new BorderLayout(10, 10));
      game = new War();
      
      titlePanel = new JPanel();
      title = new JLabel("Battle!");
      title.setFont(new Font("LUCIDA", Font.BOLD, 24));
      titlePanel.add(title);
      
      gamePanel = new JPanel(new BorderLayout(100, 10));
      turns = new JLabel("Turns: " + game.getTurns());
      turns.setHorizontalAlignment(0);
      turns.setFont(new Font("LUCIDA", Font.ITALIC, 24));
      
      
      p1Grid = new JPanel(new GridLayout(1, 1));
      p2Grid = new JPanel(new GridLayout(1, 1));
      
      gameGrid = new JPanel(new BorderLayout());
      gameGrid.add(p1Grid, BorderLayout.WEST);
      gameGrid.add(p2Grid, BorderLayout.EAST);
      
      
      labelHolder = new JPanel(new BorderLayout());
      gamePanel.add(labelHolder, BorderLayout.NORTH);
      p1Label = new JLabel("Player 1");
      p1Label.setHorizontalAlignment(SwingConstants.LEFT);
      p1Label.setFont(new Font("LUCIDA", Font.PLAIN, 18));
      labelHolder.add(p1Label, BorderLayout.WEST);
      
      p2Label = new JLabel("Player 2");
      
      p2Label.setFont(new Font("LUCIDA", Font.PLAIN, 18));
      p2Label.setHorizontalAlignment(SwingConstants.RIGHT);
      labelHolder.add(p2Label, BorderLayout.EAST);
      labelHolder.add(turns, BorderLayout.CENTER);
      
      victory = new JLabel();
      victory.setFont(new Font("LUCIDA", Font.ITALIC, 24));
      victory.setHorizontalAlignment(0);
      gameGrid.add(victory, BorderLayout.SOUTH);
      
      gamePanel.add(gameGrid, BorderLayout.CENTER);
   
      deck1 = new CardPanel();
      deck2 = new CardPanel();
      
      gamePanel.add(deck1, BorderLayout.WEST);
      gamePanel.add(deck2, BorderLayout.EAST);
      
      battleButton = new JButton("Battle!");
      battleButton.addActionListener(new ButtonListener());
            
      add(gamePanel, BorderLayout.CENTER);
      add(titlePanel, BorderLayout.NORTH);
      add(battleButton, BorderLayout.SOUTH);
      
      cardFace1 = new CardPanel();
      cardFace2 = new CardPanel();
      
       
       
   }
   
   private class ButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if(game.getCardsP1()==0 || game.getCardsP2()==0)
         {
            victory.setText("No more cards.");
            
         }
         else
         {
            victory.setText("");
            game.battle();
            turns.setText("Turns: " + game.getTurns());
            p1Grid.add(cardFace1);
            p2Grid.add(cardFace2);
            cardFace1.setFront(game.getSpoilsP1().get(0));
            cardFace2.setFront(game.getSpoilsP2().get(0));
           
            if(game.getBattleWinner()== 1)
            {
               victory.setText("Player 1 wins!");
            }
            else if(game.getBattleWinner() == 2)
            {
               victory.setText("Player 2 wins!");
            }
            else if(game.getBattleWinner() == 3)
            {
               victory.setText("Tie!"); 
            }
            game.clearCards();
         }
      }
   }
  
}