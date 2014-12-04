/*Mckenna Todd
  CS 110
*/
/**
   The WarGUI class is an interface for a simulation of the card game War. It creates a window that shows
   each player's decks and the cards they put down, with a button that then enacts the "war." It includes 
   methods for creating the individual panels and parts of the GUI, as well as a method to respond to
   a button press and enact the game.
*/

//Imports the needed packages.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

//Creates the WarGUI class, which extends the JFrame class.
public class WarGUI extends JFrame
{
   //Creates the actual card game.
   private War game;
   //Creates variables for the visual representations of the player's decks.
   private CardPanel deck1;
   private CardPanel deck2;
   
   private JPanel gamePanel; //Creates variables for the panel to hold the game space,
   private JPanel titlePanel; //the panel to hold the title,
   private JPanel p1Panel; //panels to hold each player's cards they put down,
   private JPanel p2Panel;
   private JPanel playerPanel; //a panel to hold those two panels,
   private JPanel labelHolder; //and a panel for the player's names and hand sizes.
   
   //Creates the button to activate the game.
   private JButton battleButton;
   
   private JLabel turns; //Creates variables for the label to hold the number of turns,
   private JLabel title; //the title of the game,
   private JLabel victory; //who won the war,
   private JLabel p1Label; //and the player's names and card sizes.
   private JLabel p2Label;
   
   //Creates the CardPanels to hold the representations of the cards each player has down.
   private CardPanel cardFace1;
   private CardPanel cardFace2;
   private CardPanel warDown1;
   private CardPanel warDown2;
   private CardPanel warUp1;
   private CardPanel warUp2;
 
   //Initializes constants to tell if the game is a tie.
   private static final int TIE = 3;
   private static final int P1 = 1;
   private static final int P2 = 2;
   
   //Creates the WarGUI class.
   public WarGUI()
   {
      //Creates a BorderLayout for the entire frame. 
      setLayout(new BorderLayout(10, 10));
      //Initializes a new game of cards.
      game = new War();
      
      /*Calls the methods to create the overall game panel, the title panel, the panels to
        hold the cards, and the labels for the players.
      */
      createGamePanel();
      createCardPanel();
      createTitlePanel();
      createPlayerLabels();
     
      //Adds each panel to the frame.
      add(gamePanel, BorderLayout.CENTER);
      add(titlePanel, BorderLayout.NORTH);
      add(battleButton, BorderLayout.SOUTH);    
   }
   
   /**
      The createGamePanel method creates the overall panel for the game itself, including a layout of
      cards for each player, with an overall panel to hold those. It then sets their backgrounds and 
      adds them to the game panel. It also creates the button to activate the game, and the button
      Listener to respond to it. 
   */ 
   public void createGamePanel()
   {
      //Creates the JPanel to hold the entire game, gives it a BorderLayout and sets the background.
      gamePanel = new JPanel(new BorderLayout(100, 10));
      gamePanel.setBackground(Color.GREEN.darker().darker());
      
      //Creates two JPanels to hold each player's cards and sets their backgrounds.
      p1Panel = new JPanel(new BorderLayout(5, 5));
      p2Panel = new JPanel(new BorderLayout(5, 5));
      p1Panel.setBackground(Color.GREEN.darker().darker());
      p2Panel.setBackground(Color.GREEN.darker().darker());
      
      /*Creates the JPanel to hold the two player's layouts and adds them, then sets the background and
        adds it to the overall game panel.
      */
      playerPanel = new JPanel(new BorderLayout());
      playerPanel.setBackground(Color.GREEN.darker().darker());
      playerPanel.add(p1Panel, BorderLayout.WEST);
      playerPanel.add(p2Panel, BorderLayout.EAST);
      gamePanel.add(playerPanel, BorderLayout.CENTER);
      
      //Creates the button to activate the game, as well as its ButtonListener
      battleButton = new JButton("Battle!");
      battleButton.addActionListener(new ButtonListener());
   }
   
   /**
      The createCardPanel method creates the CardPanels to hold the representations of the player's
      decks and the cards that they have down on the field. It then sets their background colors
      and adds them to the overall panel for the game itself.
   */
   public void createCardPanel()
   {
      //Creates two CardPanels to represent each player's decks and sets their backgrounds.
      deck1 = new CardPanel();
      deck2 = new CardPanel();
      deck1.setBack();
      deck2.setBack();
      deck1.setBackground(Color.GREEN.darker().darker());
      deck2.setBackground(Color.GREEN.darker().darker());
      
      //Creates the CardPanels to represent the cards each player has on the field and sets their backgrounds.
      cardFace1 = new CardPanel();
      cardFace2 = new CardPanel();
      warDown1 = new CardPanel();
      warDown2 = new CardPanel();
      warUp1 = new CardPanel();
      warUp2 = new CardPanel();
      
      cardFace1.setBackground(Color.GREEN.darker().darker());
      cardFace2.setBackground(Color.GREEN.darker().darker());
      warDown1.setBackground(Color.GREEN.darker().darker());
      warDown2.setBackground(Color.GREEN.darker().darker());
      warUp1.setBackground(Color.GREEN.darker().darker());
      warUp2.setBackground(Color.GREEN.darker().darker());
      
      //Adds all of the CardPanels to their respective JPanels.
      p1Panel.add(cardFace1, BorderLayout.WEST);
      p1Panel.add(warDown1, BorderLayout.CENTER);
      p1Panel.add(warUp1, BorderLayout.EAST);
      p2Panel.add(cardFace2, BorderLayout.EAST);
      p2Panel.add(warDown2, BorderLayout.CENTER);
      p2Panel.add(warUp2, BorderLayout.WEST);
      
      //Adds the two deck CardPanels to the game panel.
      gamePanel.add(deck1, BorderLayout.WEST);
      gamePanel.add(deck2, BorderLayout.EAST);
   }
   
   /**
      The createTitlePanel method creates a panel for the title of the game, then creates a label
      for the title and adds it.
   */
   public void createTitlePanel()
   {
      //Creates a new JPanel to hold the title and sets its background.
      titlePanel = new JPanel(new BorderLayout());
      titlePanel.setBackground(Color.LIGHT_GRAY);
      
      //Creates a JLabel for the title, sets its message and background, and adds it to the title panel.
      title = new JLabel("War!");
      title.setFont(new Font("LUCIDA", Font.BOLD, 24));
      title.setBackground(Color.LIGHT_GRAY);
      title.setHorizontalAlignment(SwingConstants.CENTER);
      titlePanel.add(title, BorderLayout.NORTH);  
   }
   
   /**
      The createPlayerLabels method creates the names for each player and the message that 
      displays who the winner of the war was.
   */
   public void createPlayerLabels()
   {
      //Creates a new JPanel to hold the player labels, sets its background and adds it.
      labelHolder = new JPanel(new BorderLayout());
      labelHolder.setBackground(Color.LIGHT_GRAY);
      titlePanel.add(labelHolder, BorderLayout.SOUTH);
      
      //Creates a JLabel for player 1's name, sets its message and background, and adds it.
      p1Label = new JLabel("Player 1");
      p1Label.setHorizontalAlignment(SwingConstants.LEFT);
      p1Label.setBackground(Color.LIGHT_GRAY);
      p1Label.setFont(new Font("LUCIDA", Font.PLAIN, 24));
      labelHolder.add(p1Label, BorderLayout.WEST);
      
      //Creates the same for player 2.
      p2Label = new JLabel("Player 2");
      p2Label.setBackground(Color.LIGHT_GRAY);
      p2Label.setFont(new Font("LUCIDA", Font.PLAIN, 24));
      p2Label.setHorizontalAlignment(SwingConstants.RIGHT);
      labelHolder.add(p2Label, BorderLayout.EAST);
      
      //Creates a JLabel to hold the number of turns, sets its message and background, and adds it.
      turns = new JLabel("Turns: " + game.getTurns());
      turns.setBackground(Color.LIGHT_GRAY);
      turns.setFont(new Font("LUCIDA", Font.PLAIN, 24));
      turns.setHorizontalAlignment(0);
      labelHolder.add(turns, BorderLayout.CENTER);
      
      //Creates a JLabel to hold the message displaying which player won, sets its message and background, and adds it.
      victory = new JLabel();
      victory.setBackground(Color.LIGHT_GRAY);
      victory.setFont(new Font("LUCIDA", Font.BOLD, 36));
      victory.setHorizontalAlignment(0);
      playerPanel.add(victory, BorderLayout.SOUTH);
   }
   
   /**
      The winnerText method calls the getWarWinner method from the War class in order
      to determine what message to display, based on who won the game.
   */
   public void winnerText()
   {
      switch(game.getWarWinner())
      {
         case P1:
            victory.setText("No more cards. Player 1 wins!");
            break;
         case P2:
            victory.setText("No more cards. Player 2 wins!");
            break;
         case TIE:
            victory.setText("No more cards. Everyone wins!");
            break;
      }
   }
   
   /**
      The ButtonListener class implements the ActionListener class and includes a method for activating the 
      War game when the button on the bottom of the GUI is pressed by the player.
   */
   private class ButtonListener implements ActionListener
   {
      //Creates variables for face-down cards' indexes and one for the winner's number.
      int index1;
      int index2;
      int winner;
 
      /**
         The actionPerformed method accepts an ActionEvent as an argument. If the battleButton is
         pressed, this method will call either the battle or war method from the War class, and
         display the cards on the fields accordingly.
         @param e The ActionEvent to trigger the action performed.
         @exception IndexOutOfBoundsException If there is a problem with the indexes of the hands or cards on the field.
         @exception Exception If any other sort of critical error should occur.
      */
      public void actionPerformed(ActionEvent e)
      {
         try
         {
            //If no one has any cards, determines and displays the winner and disables the button.
            if(game.getCardsP1()==0 || game.getCardsP2()==0)
            {
               victory.setText("No more cards.");
               winnerText();
               battleButton.setEnabled(false);
            }
            else
            {
               victory.setText("");
               
               //If the previous battle wasn't a tie, calls the battle method.
               if(winner!=TIE)
               {
                  //Clears the cards from the field. 
                  game.clearSpoils();
                  //Calls the battle method to initiate a card battle.
                  game.battle();
                  
                  //Sets the fronts of the cards for the battle.
                  Card card1 = game.getSpoilsP1().get(0);
                  Card card2 = game.getSpoilsP2().get(0);
                  card1.setFaceUp(true);
                  card2.setFaceUp(true);
                  cardFace1.setFront(card1);
                  cardFace2.setFront(card2);
                  
                  //Sets placeholders for the images of the cards displayed during a war.
                  ImageIcon warBack = new ImageIcon("cardPics\\warBack.jpg");
                  warDown1.setImage(warBack);
                  warDown2.setImage(warBack);
                  warUp1.setImage(warBack);
                  warUp2.setImage(warBack); 
               }
               
               //If the previous battle was a tie, calls the war method.
               else if(winner == TIE)
               {
                  //Calls the war method.
                  game.war();
                  
                  //Gets the face-down card from the cards on the field.
                  index1 = game.findFaceDownCard(game.getSpoilsP1());
                  index2 = game.findFaceDownCard(game.getSpoilsP2());
                  
                  //Sets the cards so that they display their backs.
                  Card war1 = new Card(game.getSpoilsP1().get(index1));
                  Card war2 = new Card(game.getSpoilsP2().get(index2));
                  war1.setFaceUp(false);
                  war2.setFaceUp(false);
                  warDown1.setFront(war1);
                  warDown2.setFront(war2);
                  
                  //Gets the cards directly after the face-down cards.
                  Card card1 = new Card(game.getSpoilsP1().get(index1+1));
                  Card card2 = new Card(game.getSpoilsP2().get(index2+1));
                  
                  //Sets the cards so that they display their fronts.
                  card1.setFaceUp(true);
                  card2.setFaceUp(true);
                  warUp1.setFront(card1);
                  warUp2.setFront(card2);
                  
               }
               
               //Gets the winner of the battle or the war by calling the getPlayerWins method.
               winner = game.getPlayerWins();
               
               //Creates a switch statement to determine what the button will display.
               switch(game.getPlayerWins())
               {
                  //If the previous game was not a tie, displays "Battle".
                  case P1:
                  case P2:
                     battleButton.setText("Battle!");
                     break;
                  //If it was a tie, displays "War".
                  case TIE:
                     battleButton.setText("War!!!");
               }
               
               //Updates the turn counter.
               turns.setText("Turns: " + game.getTurns());
            }
            
            //If anyone is out of cards, determines and displays the winner and disables the button.
            if(game.getCardsP1()==0 || game.getCardsP2()==0)
            {
               winnerText();
               battleButton.setEnabled(false);
            }
            
         }
         
         /*Catches any IndexOutOfBoundsExceptions in case there is an error with the indexes
            of the hands or cards on the field, and disables the button.
         */
         catch(IndexOutOfBoundsException ie)
         {
            JOptionPane.showMessageDialog(null, "Error with the game: index out of bounds.");
            battleButton.setEnabled(false);
         }
         //Catches any general exceptions that could cause the program to crash and disables the button.
         catch(Exception ex)
         {
            JOptionPane.showMessageDialog(null, "Error with the game.");
            battleButton.setEnabled(false);
         }
      }
   }
  
}