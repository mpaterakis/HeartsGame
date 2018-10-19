package UI;

import Human.HeartsDealer;
import Human.HeartsPlayer;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

/**
 * Main frame for the game, where all the visible game objects are located
 * 
 * @author Emmanouil Paterakis
 */
public class MainFrame extends JFrame {

    // Constructor
    public MainFrame(HeartsPlayer player1, HeartsPlayer player2, HeartsDealer dealer) {
        this.player1 = player1;
        this.player2 = player2;
        this.dealer = dealer;

        initComponents();

        dealer.setDeckPanel(deckPanel);
        dealer.setInfoArea(infoArea);
        player1.setInfoArea(infoArea);
        player2.setInfoArea(infoArea);
    }

    // Custom methods
    private void initComponents() {

        // JScrollPane
        deckScrollPane = new JScrollPane();

        // JTextArea
        infoArea = new JTextArea("Welcome to my game!");
        infoArea.setEditable(false);

        // JButtons
        p1IntroduceBtn = new JButton("Introduce");
        p2IntroduceBtn = new JButton("Introduce");
        dealerIntroduceBtn = new JButton("Introduce");
        p1ShowHandBtn = new JButton("Show hand");
        p2ShowHandBtn = new JButton("Show hand");
        dealBtn = new JButton("Deal");
        showDeckBtn = new JButton("Show Deck");
        decideWinnerBtn = new JButton("Decide Winner");

        p1ShowHandBtn.setEnabled(false);
        p2ShowHandBtn.setEnabled(false);
        dealBtn.setEnabled(false);
        showDeckBtn.setEnabled(false);
        decideWinnerBtn.setEnabled(false);

        // Add ActionListeners
        showDeckBtn.addActionListener(e -> doShowDeck());
        p1IntroduceBtn.addActionListener(e -> doIntroducePlayer(1));
        p2IntroduceBtn.addActionListener(e -> doIntroducePlayer(2));
        dealerIntroduceBtn.addActionListener(e -> doIntroduceDealer());
        dealBtn.addActionListener(e -> doDeal());
        p1ShowHandBtn.addActionListener(e -> doShowHand(1));
        p2ShowHandBtn.addActionListener(e -> doShowHand(2));
        decideWinnerBtn.addActionListener(e -> doDecideWinner());

        // JLabels
        p1Label = new JLabel("Player 1   |   Points: 0", SwingConstants.CENTER);
        p2Label = new JLabel("Player 2   |   Points: 0", SwingConstants.CENTER);
        dealerLabel = new JLabel("Dealer", SwingConstants.CENTER);

        // JPanels
        bottomPanel = new JPanel(new BorderLayout());
        gamePanel = new JPanel(new GridLayout(4, 1));
        actionsPanel = new JPanel(new GridLayout(4, 1));
        p1Panel = new JPanel(new GridLayout(2, 1));
        p2Panel = new JPanel(new GridLayout(2, 1));
        dealerPanel = new JPanel(new GridLayout(2, 1));
        deckPanel = new JPanel(new GridLayout(11, 5));
        p1DeckPanel = new JPanel(new FlowLayout());
        p2DeckPanel = new JPanel(new FlowLayout());
        
        // Set up JPanels
        p1Panel.add(p1Label);
        JPanel p1ButtonsPanel = new JPanel(new FlowLayout());
        p1ButtonsPanel.add(p1IntroduceBtn);
        p1ButtonsPanel.add(p1ShowHandBtn);
        p1Panel.add(p1ButtonsPanel);

        p2Panel.add(p2Label);
        JPanel p2ButtonsPanel = new JPanel(new FlowLayout());
        p2ButtonsPanel.add(p2IntroduceBtn);
        p2ButtonsPanel.add(p2ShowHandBtn);
        p2Panel.add(p2ButtonsPanel);

        dealerPanel.add(dealerLabel);
        JPanel dealerButtonsPanel = new JPanel(new GridLayout(2, 2));
        dealerButtonsPanel.add(dealerIntroduceBtn);
        dealerButtonsPanel.add(showDeckBtn);
        dealerButtonsPanel.add(dealBtn);
        dealerButtonsPanel.add(decideWinnerBtn);
        dealerPanel.add(dealerButtonsPanel);

        // Add players' cards (which are empty at this moment) to their decks
        refreshPlayerDeckPanels();

        // Set deckPanel as the View for scrollPane
        deckScrollPane.setViewportView(deckPanel);

        // Add all the JPanels together
        actionsPanel.add(p1Panel);
        actionsPanel.add(dealerPanel);
        actionsPanel.add(p2Panel);
        gamePanel.add(p1DeckPanel);
        gamePanel.add(deckScrollPane);
        gamePanel.add(infoArea);
        gamePanel.add(p2DeckPanel);
        bottomPanel.add(gamePanel, BorderLayout.EAST);
        bottomPanel.add(actionsPanel, BorderLayout.WEST);

        add(bottomPanel);

        // JFrame config
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Hearts Game");
        setVisible(true);
    }

    // Custom methods
    // Introduce dealer action
    private void doIntroduceDealer() {
        dealer.introduceSelf();
        dealerIntroduceBtn.setEnabled(false);
        tryEnablingShowDeckButton();
    }

    // Introduce player action
    private void doIntroducePlayer(int playerNumber) {
        if (playerNumber == 1) {
            player1.introduceSelf();
            p1IntroduceBtn.setEnabled(false);
        } else if (playerNumber == 2) {
            player2.introduceSelf();
            p2IntroduceBtn.setEnabled(false);
        }
        tryEnablingShowDeckButton();
    }

    // Show deck action
    private void doShowDeck() {
        dealer.showDeck();
        showDeckBtn.setEnabled(false);
        dealBtn.setEnabled(true);
    }

    // Deal action
    private void doDeal() {
        dealer.dealToPlayers(player1, player2);
        dealBtn.setEnabled(false);
        
        p1ShowHandBtn.setEnabled(true);
        p2ShowHandBtn.setEnabled(true);
        
        refreshPlayerDeckPanels();
    }

    // Show hand action
    private void doShowHand(int playerNumber) {
        if (playerNumber == 1) {
            player1.showHand();
            p1ShowHandBtn.setEnabled(false);
        } else if (playerNumber == 2) {
            player2.showHand();
            p2ShowHandBtn.setEnabled(false);
        }
        tryEnablingDecideWinnerButton();
    }
    
    // Decide winner action
    private void doDecideWinner() {
        dealer.decideWinner(player1, player2);
        
        decideWinnerBtn.setEnabled(false);
        showDeckBtn.setEnabled(true);
        
        refreshPlayerDeckPanels();
        
        p1Label.setText("Player 1   |   Points: " + player1.getPoints());
        p2Label.setText("Player 2   |   Points: " + player2.getPoints());
    }

    // Try to enable the "Show Deck" button. All "Introduce" buttons must be pressed.
    private void tryEnablingShowDeckButton() {
        if (!p1IntroduceBtn.isEnabled() && !p2IntroduceBtn.isEnabled() && !dealerIntroduceBtn.isEnabled()) {
            showDeckBtn.setEnabled(true);
        }
    }
    
    // Try to enable the "Decide Winner" button. All "Show Hand" buttons must be pressed.
    private void tryEnablingDecideWinnerButton() {
        if (!p1ShowHandBtn.isEnabled() && !p2ShowHandBtn.isEnabled()) {
            decideWinnerBtn.setEnabled(true);
        }
    }
    
    // Refresh the players' deck panels
    private void refreshPlayerDeckPanels() {
        p1DeckPanel.removeAll();
        for (int i = 0; i < player1.getCardsInHand().size(); i++) {
            p1DeckPanel.add(player1.getCardsInHand().get(i));
        }
        p1DeckPanel.revalidate();
        
        p2DeckPanel.removeAll();
        for (int i = 0; i < player2.getCardsInHand().size(); i++) {
            p2DeckPanel.add(player2.getCardsInHand().get(i));
        }
        p2DeckPanel.revalidate();
    }

    // Fields
    private JPanel bottomPanel, actionsPanel, p1Panel, p2Panel, dealerPanel,
            p1DeckPanel, p2DeckPanel, deckPanel, gamePanel;
    private JButton p1IntroduceBtn, p2IntroduceBtn, p1ShowHandBtn, p2ShowHandBtn,
            dealerIntroduceBtn, showDeckBtn, decideWinnerBtn, dealBtn;
    private JTextArea infoArea;
    private JScrollPane deckScrollPane;
    private JLabel p1Label, p2Label, dealerLabel;
    private HeartsDealer dealer;
    private HeartsPlayer player1, player2;
}
