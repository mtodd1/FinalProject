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
      
      createCardPanel();
      createGamePanel();
      createTitlePanel();
      createPlayerLabels();
     
           
      add(gamePanel, BorderLayout.CENTER);
      add(titlePanel, BorderLayout.NORTH);
      add(battleButton, BorderLayout.SOUTH);
      
      
      
       
   }
   
   public void createCardPanel()
   {
      deck1 = new CardPanel();
      deck2 = new CardPanel();
      deck1.setBackground(Color.GREEN.darker().darker());
      deck2.setBackground(Color.GREEN.darker().darker());
      
      cardFace1 = new CardPanel();
      cardFace2 = new CardPanel();
      cardFace1.setBackground(Color.GREEN.darker().darker());
      cardFace2.setBackground(Color.GREEN.darker().darker());
      
      gamePanel.add(deck1, BorderLayout.WEST);
      gamePanel.add(deck2, BorderLayout.EAST);
   }
   public void createGamePanel()
   {
      gamePanel = new JPanel(new BorderLayout(100, 10));
      gamePanel.setBackground(Color.GREEN.darker().darker());
      
      p1Grid = new JPanel(new GridLayout(3, 1));
      p2Grid = new JPanel(new GridLayout(3, 1));
      p1Grid.setBackground(Color.GREEN.darker().darker());
      p2Grid.setBackground(Color.GREEN.darker().darker());
      
      gameGrid = new JPanel(new BorderLayout());
      gameGrid.setBackground(Color.GREEN.darker().darker());
      gameGrid.add(p1Grid, BorderLayout.WEST);
      gameGrid.add(p2Grid, BorderLayout.EAST);
      gamePanel.add(gameGrid, BorderLayout.CENTER);
      
      battleButton = new JButton("Battle!");
      battleButton.addActionListener(new ButtonListener());
   }
   public void createTitlePanel()
   {
      titlePanel = new JPanel();
      title = new JLabel("Battle!");
      title.setFont(new Font("LUCIDA", Font.BOLD, 24));
      titlePanel.add(title);
      
      
      
   }
   
   public void createPlayerLabels()
   {
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
      
      victory = new JLabel();
      victory.setFont(new Font("LUCIDA", Font.BOLD, 36));
      victory.setHorizontalAlignment(0);
      gameGrid.add(victory, BorderLayout.SOUTH);
  
   }
   private class ButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if(game.getCardsP1()==0 || game.getCardsP2()==0)
         {
            victory.setText("No more cards.");
            battleButton.setEnabled(false);
         }
         else
         {
            victory.setText("");
            game.battle();
            
            p1Grid.add(cardFace1);
            p2Grid.add(cardFace2);
            cardFace1.setFront(game.getSpoilsP1().get(0));
            cardFace2.setFront(game.getSpoilsP2().get(0));
           
            switch(game.getBattleWinner())
            {
               case 1:
                  victory.setText("Player 1 wins!");
                  
            
                  
                 
                  break;
               case 2:
                  victory.setText("Player 2 wins!");
                  
                  
                  
                  break;
               case 3:
                  victory.setText("Tie!");
                  for(int i = game.findFaceUpCard(game.getSpoilsP1()); i < game.getSpoilsP1().size(); i++)
                  {
                     CardPanel war = new CardPanel();
                     
                     war.setFront(game.getSpoilsP1().get(i));
                     p1Grid.add(war);        
                  }
                  for(int i = game.findFaceUpCard(game.getSpoilsP2()); i < game.getSpoilsP2().size(); i++)
                  {
                     CardPanel war = new CardPanel();
                     
                     war.setFront(game.getSpoilsP2().get(i));
                     p1Grid.add(war);        
                  }
                  break; 
            }
            game.clearCards();
         }
      }
   }
  
}